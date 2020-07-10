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

/**
 * Servlet implementation class UserCreateInputServlet
 */
@WebServlet("/user/input")
public class UserCreateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/create_input.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォームから値の受け取り
        String Ksei = request.getParameter("Ksei");
        String Kmei = request.getParameter("Kmei");
        String Hsei= request.getParameter("Hsei");
        String Hmei = request.getParameter("Hmei");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        String Kpass = request.getParameter("Kpass");
        String post = request.getParameter("post");
        String address = request.getParameter("address");
        String namber = request.getParameter("namber");

        // 入力内容をBeanに格納
        UserBean user = new UserBean();
        user.setFirstName(Ksei);
        user.setLastName(Kmei);
        user.setFirstNameFurigana(Hsei);
        user.setLastNameFurigana(Hmei);
        user.setEmail(mail);
        user.setPassword(pass);
        user.setPostalCode(post);
        user.setAddress(address);
        user.setPhoneNumber(namber);

        HttpSession session = request.getSession(false);
        session.setAttribute("user", user);

	    response.sendRedirect("confirm");
	}

}
