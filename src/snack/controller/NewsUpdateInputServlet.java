package snack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.NewsBean;
import snack.helper.ErrorHelper;
import snack.model.NewsModel;

@WebServlet("/news/update/input")
public class NewsUpdateInputServlet extends HttpServlet {

    private static final String jsp = "../../WEB-INF/jsp/news/update_input.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // パラメータからIDを取得
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch(Exception e) {
            response.sendError(400);
            return;
        }

        // データベースから情報取得
        NewsModel newsModel = new NewsModel();
        NewsBean newsBean = newsModel.show(id);

        // データベースに存在しなかった場合に404エラー
        if(newsBean == null) {
            response.sendError(404);
            return;
        }

        // セッションに情報を保存
        HttpSession session = request.getSession(false);
        session.setAttribute("updateNews", newsBean);

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // フォームから値の受け取り
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        // エラーメッセージ
        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();

        // 件名が空のとき
        if(subject.isEmpty()) {
            errors = ErrorHelper.add(errors, "subject", "入力してください。");
        }

        // 内容が空のとき
        if(content.isEmpty()) {
            errors = ErrorHelper.add(errors, "content", "入力してください。");
        }

        // 件名が文字数オーバーのとき
        if(subject.length() > 32) {
            errors = ErrorHelper.add(errors, "subject", "1文字以上、32文字以内で入力してください。");
        }

        // 内容が文字数オーバーのとき
        if(content.length() > 4096) {
            errors = ErrorHelper.add(errors, "content", "1文字以上、4096文字以内で入力してください。");
        }

        // セッション取得
        HttpSession session = request.getSession(false);

        // セッションからBean取得
        NewsBean news = (NewsBean)session.getAttribute("updateNews");

        // 入力内容をBeanに格納
        news.setSubject(subject);
        news.setContent(content);

        // 入力内容をセッションに格納
        session.setAttribute("news", news);

        // エラーの存在によって遷移先の切り替え
        if(errors.isEmpty()) {
            response.sendRedirect("confirm");
        } else {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }

    }

}
