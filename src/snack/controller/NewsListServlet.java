package snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.bean.NewsBean;
import snack.model.NewsModel;
@WebServlet("/news/list")
public class NewsListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                throws ServletException, IOException{
     // データベースから情報取得
        NewsModel newsModel = new NewsModel();
        List<NewsBean> news = newsModel.list();

        request.setAttribute("news", news);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("../WEB-INF/jsp/news/list.jsp");
        dispatcher.forward(request, response);
    }
}
