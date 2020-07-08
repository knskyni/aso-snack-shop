package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.NewsBean;
import snack.model.NewsModel;

@WebServlet("/news/create/confirm")
public class NewsCreateConfirmServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/news/create_confirm.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション
        HttpSession session = request.getSession(false);
        NewsBean news = (NewsBean)session.getAttribute("news");

        // Beanの存在確認
        if(news == null) {
            response.sendError(400);
            return;
        }

        // JSP表示
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション
        HttpSession session = request.getSession(false);
        NewsBean news = (NewsBean)session.getAttribute("news");

        // Beanの存在確認
        if(news == null) {
            response.sendError(400);
            return;
        }

        // データベース登録
        NewsModel newsModel = new NewsModel();
        boolean result = newsModel.create(news);

        // 遷移
        if(result) {
            response.sendRedirect("complete");
        } else {
            response.sendError(400);
        }
    }
}
