package snack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register/complete")

public class UserCreateCompleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/create_complete.jsp");
    rd.forward(request, response);

}


}