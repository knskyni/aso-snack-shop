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
import snack.model.UserModel;
@WebServlet("/user/delete/confirm")
public class UserDeleteConfirmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("../../WEB-INF/jsp/user/delete_confirm.jsp");
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserBean userInfo = new UserBean();
        userInfo = (UserBean)session.getAttribute("userInfo");
        int id = userInfo.getId();
        UserModel userModel = new UserModel();
        userModel.delete(id);
        session.invalidate();
        response.sendRedirect("complete");
    }
}
