package snack.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.model.ItemModel;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{


     // データベースから情報取得
        ItemModel itemModel = new ItemModel();
        //ItemBean item = itemModel.create(item.getId());

        //request.setAttribute("itemBean",item );

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/searchresult/searchresult.jsp");
        dispatcher.forward(request, response);

    }
}
