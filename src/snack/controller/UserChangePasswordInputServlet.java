package snack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import snack.bean.UserBean;
import snack.helper.ErrorHelper;
import snack.helper.FormHelper;
import snack.model.UserModel;

@WebServlet("/account/change-password/input")
public class UserChangePasswordInputServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/user/password_input.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから値取得
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String newPasswordConfirm = request.getParameter("new_password_confirm");

        // エラー
        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();

        // 確認用パスワードの入力チェックと同一チェック
        if(FormHelper.checkEmpty(oldPassword)) {
            errors = ErrorHelper.add(errors, "errors", "変更前パスワードを入力してください。");
        } else if(!newPassword.equals(newPasswordConfirm)) {
            errors = ErrorHelper.add(errors, "errors", "変更後のパスワードと確認用のパスワードが一致しません。");
        }

        // 変更後パスワードの入力チェック
        if(FormHelper.checkEmpty(newPassword)) {
            errors = ErrorHelper.add(errors, "errors", "変更後パスワードを入力してください。");
        }

        // 確認用の変更後パスワードの入力チェック
        if(FormHelper.checkEmpty(newPasswordConfirm)) {
            errors = ErrorHelper.add(errors, "errors", "確認用の変更後パスワードを入力してください。");
        }

        // この時点でエラーがあればエラー表示
        if(!errors.isEmpty()) {
            request.setAttribute("errors", errors);

            RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
            dispatcher.forward(request, response);
        }

        // セッション取得
        HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        // データベースからユーザー情報取得
        UserModel userModel = new UserModel();
        userInfo = userModel.show(userInfo.getId());

        // 変更前パスワード認証に失敗した場合
        if(userModel.auth(userInfo.getEmail(), oldPassword) == null) {
            errors = ErrorHelper.add(errors, "errors", "変更前のパスワードが間違っています。");
            request.setAttribute("errors", errors);

            RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
            dispatcher.forward(request, response);
            return;
        }

        // パスワードをハッシュ化
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String hashedPassword = bcrypt.encode(newPassword);

        // パスワード変更
        userInfo.setPassword(hashedPassword);
        boolean result = userModel.updatePassword(userInfo);

        if(result) {
            response.sendRedirect("complete");
        } else {
            response.sendError(400);
        }
    }
}