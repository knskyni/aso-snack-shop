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
import snack.bean.UserBean;

@WebServlet("/purchase/comfirm")
public class PurchaseComfirmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        UserBean userAuth = (UserBean)session.getAttribute("userAuth");
        request.setAttribute("userAuth", userAuth);
        ItemBean items = (ItemBean)session.getAttribute("items");
        session.setAttribute("items", items);


        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/user/update_input.jsp");
        dispatcher.forward(request, response);
    }
}
