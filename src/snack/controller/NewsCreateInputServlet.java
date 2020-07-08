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

@WebServlet("/news/create/input")
public class NewsCreateInputServlet extends HttpServlet {

    private static final String jsp = "../WEB-INF/jsp/news/create_input.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        // 入力内容をBeanに格納
        NewsBean news = new NewsBean();
        news.setSubject(subject);
        news.setContent(content);

        // 入力内容をセッションに格納
        HttpSession session = request.getSession(false);
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
