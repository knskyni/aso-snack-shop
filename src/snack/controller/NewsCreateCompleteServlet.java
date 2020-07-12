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

@WebServlet("/news/create/complete")
public class NewsCreateCompleteServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/news/create_complete.jsp";

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

        // セッションから削除
        session.removeAttribute("updateNews");

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
