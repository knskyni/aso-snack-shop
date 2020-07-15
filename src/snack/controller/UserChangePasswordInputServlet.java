package snack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;
import snack.model.UserModel;

@WebServlet("/account/change-password/input")
public class UserChangePasswordInputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // フォームから値取得
        String pass = request.getParameter("newpass");

        // セッション取得
        HttpSession session = request.getSession();

        // ユーザー情報取得・パスワード格納
        UserBean user = (UserBean)session.getAttribute("userInfo");
        user.setPassword(pass);

        // データベース
        UserModel userModel = new UserModel();
        boolean result = userModel.updatePassword(user);

        if(result) {
            response.sendRedirect("/account/change-password/complete");
        } else {
            response.sendError(400);
        }
    }
}