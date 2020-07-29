package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.bean.NewsBean;
import snack.model.NewsModel;
@WebServlet("/news/show")
public class NewsDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                throws ServletException, IOException{
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

        request.setAttribute("newsBean", newsBean);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("../WEB-INF/jsp/news/detail.jsp");
        dispatcher.forward(request, response);
    }
}
