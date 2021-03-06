package snack.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.bean.ItemBean;
import snack.bean.NewsBean;
import snack.model.ItemModel;
import snack.model.NewsModel;

@WebServlet("/search")
public class SearchResultServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("word");

        // データベースから情報取得
        ItemModel itemModel = new ItemModel();

        List<ItemBean> items = itemModel.search(search);


        request.setAttribute("itemBean", items);

        NewsModel newsModel = new NewsModel();
        List<NewsBean> news = newsModel.list();
        request.setAttribute("news", news);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/search_result.jsp");
        dispatcher.forward(request, response);
    }
}
