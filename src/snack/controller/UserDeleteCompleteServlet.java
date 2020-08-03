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
@WebServlet("/user/delete/complete")
public class UserDeleteCompleteServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/user/delete_complete.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        // Beanの存在確認
        if(userInfo == null) {
            response.sendError(400);
            return;
        }

        session.invalidate();

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);

    }
}
