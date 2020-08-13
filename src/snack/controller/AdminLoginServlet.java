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
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/admin/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        // パラメータ取得
        String email = (String)request.getParameter("email");
        String password = (String)request.getParameter("password");

        // データベースからAdminの称号
        UserModel userModel = new UserModel();
        UserBean userInfo = userModel.authAdmin(email, password);

        // ログイン結果の判定
        if(userInfo.getEmail() != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userInfo", userInfo);
            response.sendRedirect("../home");
        } else {
            request.setAttribute("msg", "*メールアドレスかパスワードが間違っています");
            RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/admin/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
