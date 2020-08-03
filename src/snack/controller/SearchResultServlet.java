package snack.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.ItemBean;
import snack.model.ItemModel;

@WebServlet("/search")
public class SearchResultServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{

        HttpSession session = request.getSession();
        ItemBean itemBean = (ItemBean)session.getAttribute("itemBean");
     // データベースから情報取得
        ItemModel itemModel = new ItemModel();
        ItemBean item = itemModel.search(itemBean.getName());

        request.setAttribute("itemBean", itemModel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/searchresult/searchresult.jsp");
        dispatcher.forward(request, response);

    }
}
