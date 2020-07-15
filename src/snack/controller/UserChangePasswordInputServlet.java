package snack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;

@WebServlet("/account/change-password/input")
public class UserChangePasswordInputServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("newpass");

		UserBean updateBean = new UserBean();
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("userInfo");

		updateBean.setNewpassword(pass);
		updateBean.setId(user.getId());

		session.setAttribute("updateBean", updateBean);

		response.sendRedirect("/account/change-password/complete");
		}
	}