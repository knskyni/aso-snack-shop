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

/**
 * Servlet implementation class UserInfoShowServlet
 */
@WebServlet("/user/detail")
public class UserInfoShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");
        int id = userInfo.getId();
	    UserModel userModel = new UserModel();
        UserBean userbean = userModel.show(id);
        request.setAttribute("user",userbean);
	    RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/detail.jsp");
        rd.forward(request, response);
	}
}
