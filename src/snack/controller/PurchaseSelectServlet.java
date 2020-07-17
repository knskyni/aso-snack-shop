package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/purchase/select")
public class PurchaseSelectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/select.jsp");
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String select = request.getParameter("selectRadios");
        String card = request.getParameter("cardNumber");

        if(select == null) {
            String msg = "＊決済方法を選択してください";

            request.setAttribute("msg", msg);

            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/user/select.jsp");
            dispatcher.forward(request, response);
        } else {

            if(select == "card" && card == null) {
                String msg = "カード番号を入力してください";

                request.setAttribute("msg", msg);

                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/user/select.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("comfirm");

            }
        }
    }
}
