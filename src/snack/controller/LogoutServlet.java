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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                throws ServletException, IOException{
        HttpSession session = request.getSession(true);
        UserBean userBean = (UserBean)session.getAttribute("userBean");
        if(userBean.getFirstName() != null) {
            session.invalidate();
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("./WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);
        }else {
            session.invalidate();
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("../WEB-INF/jsp/admin/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}