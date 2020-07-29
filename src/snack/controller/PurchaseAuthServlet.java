package snack.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;
import snack.model.UserModel;

@WebServlet("/purchase/auth")
public class PurchaseAuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        HashMap<Integer,Integer> carts = (HashMap<Integer,Integer>)session.getAttribute("cart");

        if(carts == null) {
            response.sendError(404);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/reauth.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = (String)request.getParameter("email");
        String password = (String)request.getParameter("password");

        UserModel userModel = new UserModel();
        UserBean userAuth = userModel.reauth(email,password);

        if(userAuth == null) {
            String msg = "ログインに失敗しました。ログイン内容を確認してください";

            request.setAttribute("msg", msg);

            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/purchase/auth.jsp");
            dispatcher.forward(request, response);

        }else {

            HttpSession session = request.getSession(true);
            session.setAttribute("userAuth",userAuth);
            response.sendRedirect("select");
        }
    }

}
