package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;

@WebServlet("/purchase/select")
public class PurchaseSelectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        UserBean userAuth = (UserBean)session.getAttribute("userAuth");
        if(userAuth == null) {
            response.sendError(404);
        }else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/select.jsp");
        dispatcher.forward(request, response);

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String select = request.getParameter("selectRadios");
        String cardNum = request.getParameter("cardNumber");

        if(select == "card" && cardNum.equals("")) {
            String msg = "カード番号を入力してください";
            request.setAttribute("msg", msg);

            RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/select.jsp");
            dispatcher.forward(request, response);
        }else if(select == null) {
            String msg = "＊決済方法を選択してください";

            request.setAttribute("msg", msg);

            RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/select.jsp");
            dispatcher.forward(request, response);
        }else {
            response.sendRedirect("comfirm");
        }
    }
}
