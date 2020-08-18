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

        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();
        //if (!Ksei.matches("^[一-龥]+$")) {
          // errors = ErrorHelper.add(errors,"Ksei","漢字ではありません");
        //}
        //if(Ksei.length() > 16) {
            //errors = ErrorHelper.add(errors, "Ksei", "1文字以上、16文字以内で入力してください。");
        //}
        //if (!Kmei.matches("^[一-龥]+$")) {
            //errors = ErrorHelper.add(errors,"Kmei","漢字ではありません");
        //}
        if(Ksei.isEmpty()) {
           errors = ErrorHelper.add(errors, "Kmei", "入力してください");
        }else if(Ksei.length() > 16) {
           errors = ErrorHelper.add(errors, "Kmei", "1文字以上、16文字以内で入力してください。");
        }
        if(Kmei.isEmpty()) {
            errors = ErrorHelper.add(errors, "Ksei", "入力してください。");
        }else if(Kmei.length() > 16) {
            errors = ErrorHelper.add(errors, "Ksei", "1文字以上、16文字以内で入力してください。");
        }
        if(Hsei.isEmpty()) {
            errors = ErrorHelper.add(errors, "Hsei", "入力してください。");
        }else if (!Hsei.matches("^[ぁ-ん]+$")) {
            errors = ErrorHelper.add(errors,"Hsei","ひらがなではありません");
        }else if(Hsei.length() > 32) {
            errors = ErrorHelper.add(errors, "Hsei", "1文字以上、32文字以内で入力してください。");
        }
        if(Hmei.isEmpty()) {
            errors = ErrorHelper.add(errors, "Hmei", "入力してください。");
        }else if (!Hmei.matches("^[ぁ-ん]+$")) {
            errors = ErrorHelper.add(errors,"Hmei","ひらがなではありません");
        }else if(Hmei.length() > 32) {
            errors = ErrorHelper.add(errors, "Hmei", "1文字以上、32文字以内で入力してください。");
        }
        if(pass.isEmpty()) {
            errors = ErrorHelper.add(errors, "pass", "入力してください。");
        }else if (!pass.matches("^[a-zA-Z0-9\\d]{8,128}$")) {
            errors = ErrorHelper.add(errors,"pass","半角英数字で入力してください");
        }else if(!pass.equals(Kpass)){
            errors = ErrorHelper.add(errors,"pass","上のパスワードと一致しません");
        }else if(pass.length() > 128) {
            errors = ErrorHelper.add(errors, "pass", "1文字以上、128文字以内で入力してください。");
        }else if (!pass.matches("^[0-9a-zA-Z]+$")) {
            errors = ErrorHelper.add(errors,"pass","半角英数字ではありません");
        }
        if(mail.isEmpty()) {
            errors = ErrorHelper.add(errors, "mail", "入力してください。");
        }else if (!mail.matches("^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$")) {
            errors = ErrorHelper.add(errors,"mail","正しく入力されていません");
        }else if(mail.length() > 128) {
            errors = ErrorHelper.add(errors, "mail", "1文字以上、128文字以内で入力してください。");
        }
        if(post.isEmpty()) {
            errors = ErrorHelper.add(errors, "post", "入力してください。");
        }else if (!post.matches("[0-9a-zA-Z\\-\\_]+")) {
            errors = ErrorHelper.add(errors,"post","ハイフンがないか半角数字ではありません");
        }else if(post.length() > 8) {
            errors = ErrorHelper.add(errors, "post", "1文字以上、8文字以内で入力してください。");
        }
        if(namber.isEmpty()) {
            errors = ErrorHelper.add(errors, "namber", "入力してください。");
        }else if(namber.isEmpty() ||!namber.matches("[0-9a-zA-Z\\-\\_]+")) {
            errors = ErrorHelper.add(errors, "namber", "*ハイフンを使って電話番号を入力してください");
        }else if(namber.length() > 13) {
            errors = ErrorHelper.add(errors, "namber", "1文字以上、13文字以内で入力してください。");
        }
        if(address.isEmpty()) {
            errors = ErrorHelper.add(errors, "address", "住所を入力してください");
        }//else if(address.isEmpty()) {
            //errors = ErrorHelper.add(errors, "address", "入力してください。");
        //}
        else if(address.length() > 128) {
            errors = ErrorHelper.add(errors, "address", "1文字以上、128文字以内で入力してください。");
        }

        // パスワードをハッシュ化
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String hashedPassword = bcrypt.encode(pass);

        // 入力内容をBeanに格納
        UserBean user = new UserBean();
        user.setFirstName(Ksei);
        user.setLastName(Kmei);
        user.setFirstNameFurigana(Hsei);
        user.setLastNameFurigana(Hmei);
        user.setEmail(mail);
        user.setPassword(hashedPassword);
        user.setPostalCode(post);
        user.setAddress(address);
        user.setPhoneNumber(namber);

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
