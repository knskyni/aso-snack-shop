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

@WebServlet("/user/input")
public class UserCreateInputServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/create_input.jsp");
        rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォームから値の受け取り
        String lastName = request.getParameter("Ksei");
        String firstName = request.getParameter("Kmei");
        String lastNameFurigana= request.getParameter("Hsei");
        String firstNameFurigana = request.getParameter("Hmei");
        String email = request.getParameter("mail");
        String password = request.getParameter("pass");
        String passwordConfirm = request.getParameter("Kpass");
        String postCode = request.getParameter("post");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("number");

        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();

        // 入力チェック //
        // 姓
        if(lastName.isEmpty()) {
           errors = ErrorHelper.add(errors, "Kmei", "入力してください");
        } else if(lastName.length() > 16) {
           errors = ErrorHelper.add(errors, "Kmei", "1文字以上、16文字以内で入力してください。");
        }

        // 名
        if(firstName.isEmpty()) {
            errors = ErrorHelper.add(errors, "Ksei", "入力してください。");
        } else if(firstName.length() > 16) {
            errors = ErrorHelper.add(errors, "Ksei", "1文字以上、16文字以内で入力してください。");
        }

        // 姓（ふりがな）
        if(lastNameFurigana.isEmpty()) {
            errors = ErrorHelper.add(errors, "Hsei", "入力してください。");
        } else if(!lastNameFurigana.matches("^[ぁ-ん]+$")) {
            errors = ErrorHelper.add(errors, "Hsei", "ひらがなで入力してください。");
        } else if(lastNameFurigana.length() > 32) {
            errors = ErrorHelper.add(errors, "Hsei", "1文字以上、32文字以内で入力してください。");
        }

        // 名（ふりがな）
        if(firstNameFurigana.isEmpty()) {
            errors = ErrorHelper.add(errors, "Hmei", "入力してください。");
        } else if(!firstNameFurigana.matches("^[ぁ-ん]+$")) {
            errors = ErrorHelper.add(errors,"Hmei", "ひらがなで入力してください。");
        } else if(firstNameFurigana.length() > 32) {
            errors = ErrorHelper.add(errors, "Hmei", "1文字以上、32文字以内で入力してください。");
        }

        // パスワード
        if(password.isEmpty()) {
            errors = ErrorHelper.add(errors, "pass", "入力してください。");
        } else if (!password.matches("^[a-zA-Z\\d]{8,100}$")) {
            errors = ErrorHelper.add(errors, "pass", "半角英数字で入力してください。");
        } else if(password.length() < 8 || password.length() > 128) {
            errors = ErrorHelper.add(errors, "pass", "8文字以上、128文字以内で入力してください。");
        }if(passwordConfirm.isEmpty()) {
            errors = ErrorHelper.add(errors, "Kpass", "入力してください。");
        }else if(!password.equals(passwordConfirm)) {
            errors = ErrorHelper.add(errors, "Kpass", "上のパスワードと一致しません");
        }

        // メールアドレス
        if(email.isEmpty()) {
            errors = ErrorHelper.add(errors, "mail", "入力してください。");
        } else if (!email.matches("^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$")) {
            errors = ErrorHelper.add(errors, "mail", "正しく入力されていません");
        } else if(email.length() > 128) {
            errors = ErrorHelper.add(errors, "mail", "1文字以上、128文字以内で入力してください。");
        }

        // 郵便番号
        if(postCode.isEmpty()) {
            errors = ErrorHelper.add(errors, "post", "入力してください。");
        } else if (!postCode.matches("^[0-9]{3}-[0-9]{4}$")) {
            errors = ErrorHelper.add(errors, "post", "ハイフンがないか半角数字ではありません");
        } else if(postCode.length() > 8) {
            errors = ErrorHelper.add(errors, "post", "1文字以上、8文字以内で入力してください。");
        }

        // 電話番号
        if(phoneNumber.isEmpty()) {
            errors = ErrorHelper.add(errors, "number", "入力してください。");
        } else if(phoneNumber.isEmpty() ||!phoneNumber.matches("[0-9a-zA-Z\\-\\_]+")) {
            errors = ErrorHelper.add(errors, "number", "*ハイフンを使って電話番号を入力してください");
        } else if(phoneNumber.length() > 13) {
            errors = ErrorHelper.add(errors, "number", "1文字以上、13文字以内で入力してください。");
        }

        // 住所
        if(address.isEmpty()) {
            errors = ErrorHelper.add(errors, "address", "住所を入力してください");
        } else if(address.length() > 128) {
            errors = ErrorHelper.add(errors, "address", "1文字以上、128文字以内で入力してください。");
        }

        // パスワードをハッシュ化
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String hashedPassword = bcrypt.encode(password);

        // 入力内容をBeanに格納
        UserBean user = new UserBean();
        user.setFirstName(lastName);
        user.setLastName(firstName);
        user.setFirstNameFurigana(lastNameFurigana);
        user.setLastNameFurigana(firstNameFurigana);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setPostalCode(postCode);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);

        HttpSession session = request.getSession(false);
        session.setAttribute("user", user);

        if(errors.isEmpty()) {
            response.sendRedirect("confirm");
        } else {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/create_input.jsp");
            rd.forward(request, response);
        }
	}
}
