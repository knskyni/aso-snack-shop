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

import snack.bean.UserBean;
import snack.helper.ErrorHelper;
import snack.model.UserModel;

@WebServlet("/acount/update")
public class UserUpdateInputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        UserBean userInfoBean = (UserBean)session.getAttribute("userInfo");

        UserBean userUpdateInfo = new UserBean();
        userUpdateInfo.setId(userInfoBean.getId());
        int id = userUpdateInfo.getId();

        UserModel userModel = new UserModel();
        UserBean userInfo = userModel.show(id);

        session.setAttribute("userIdInfo", userInfo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/user/update_input.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String lastNameFurigana = request.getParameter("lastNameFurigana");
        String firstNameFurigana = request.getParameter("firstNameFurigana");
        String email = request.getParameter("email");
        String postalNumber = request.getParameter("postalNumber");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();

        if(lastName.isEmpty()) {
            errors = ErrorHelper.add(errors, "lastName", "*姓を入力してください");
        }

        if(firstName.isEmpty()) {
            errors = ErrorHelper.add(errors, "firstName", "*名を入力してください");
        }

        if(lastNameFurigana.isEmpty() || lastNameFurigana.matches("^[\\u30A0-\\u30FF]+$")) {
            errors = ErrorHelper.add(errors, "lastNameFurigana", "*せいをひらがなで入力してください");
        }

        if(firstNameFurigana.isEmpty() || firstNameFurigana.matches("^[\\u30A0-\\u30FF]+$")) {
            errors = ErrorHelper.add(errors, "firstNameFurigana", "*めいをひらがなで入力してください");
        }

        if(email.isEmpty()) {
            errors = ErrorHelper.add(errors, "email", "*正しく入力してください");
        }

        if(postalNumber.isEmpty() || !postalNumber.matches("[0-9a-zA-Z\\-\\_]+" )){
            errors = ErrorHelper.add(errors, "postalNumber", "*ハイフンを使って正しく入力してください");
        }

        if(address.isEmpty()) {
            errors = ErrorHelper.add(errors, "address", "*住所を入力してください");
        }

        if(phoneNumber.isEmpty() || !phoneNumber.matches("[0-9a-zA-Z\\-\\_]+")) {
            errors = ErrorHelper.add(errors, "phoneNumber", "*ハイフンを使って電話番号を入力してください");
        }

        if(lastName.length() > 16) {
            errors = ErrorHelper.add(errors, "lastName", "*16文字以内で入力してください");
        }

        if(firstName.length() > 32) {
            errors = ErrorHelper.add(errors, "firstName", "*32文字以内で入力してください");
        }

        if(lastNameFurigana.length() > 32) {
            errors = ErrorHelper.add(errors, "lastNameFurigana", "*32文字以内で入力してください");
        }

        if(firstNameFurigana.length() > 16) {
            errors = ErrorHelper.add(errors, "lastNameFurigana", "*16文字以内で入力してください");
        }

        if(email.length() > 128) {
            errors = ErrorHelper.add(errors, "email", "*128文字以内で入力してください");
        }

        if(postalNumber.length() > 8) {
            errors = ErrorHelper.add(errors, "postalNumber", "*16文字以内で入力してください");
        }

        if(address.length() > 128) {
            errors = ErrorHelper.add(errors, "address", "*128文字以内で入力してください");
        }

        if(phoneNumber.length() > 13) {
            errors = ErrorHelper.add(errors, "phoneNumber", "*13文字以内で入力してください");
        }

        HttpSession session = request.getSession(true);
        UserBean userIdInfo = (UserBean)session.getAttribute("userIdInfo");

        UserBean userUpdateInfo = new UserBean();
        userUpdateInfo.setId(userIdInfo.getId());
        userUpdateInfo.setLastName(lastName);
        userUpdateInfo.setFirstName(firstName);
        userUpdateInfo.setFirstNameFurigana(firstNameFurigana);
        userUpdateInfo.setLastNameFurigana(lastNameFurigana);
        userUpdateInfo.setEmail(email);
        userUpdateInfo.setPostalCode(postalNumber);
        userUpdateInfo.setAddress(address);
        userUpdateInfo.setPhoneNumber(phoneNumber);

        if(errors.isEmpty()) {
            UserModel userModel = new UserModel();
            userModel.update(userUpdateInfo);
            response.sendRedirect("/acount/show");
        } else {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/user/update_input.jsp");
            rd.forward(request, response);
        }
    }
}
