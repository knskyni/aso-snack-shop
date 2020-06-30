package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;

import snack.bean.NewsBean;

@WebServlet("/news/create")
public class NewsCreateInputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/news/create_input.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // フォームから値の受け取り
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        // 値が空で400エラー
        if(subject.isEmpty() || content.isEmpty()) {
            response.sendError(400);
        }

        // 文字数オーバーで414エラー
        if(subject.length() > 32 || content.length() > 4096) {
            response.sendError(414);
        }

        // 入力内容をBeanに格納
        NewsBean news = new NewsBean();
        news.setSubject(StringEscapeUtils.escapeHtml4(subject));
        news.setContent(content);

        // 入力内容をセッションに格納
        HttpSession session = request.getSession(false);
        session.setAttribute("news", news);

        response.sendRedirect("confirm");

    }

}
