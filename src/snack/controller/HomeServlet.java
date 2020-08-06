package snack.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.bean.ItemBean;
import snack.model.ItemModel;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{

        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch(Exception e) {
            response.sendError(400);
            return;
        }

        // データベースから情報取得
        ItemModel itemDao = new ItemModel();
        ItemBean item = itemDao.show(id);

           request.setAttribute("item", item);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("../WEB-INF/jsp/home/top.jsp");
        dispatcher.forward(request, response);
    }
}