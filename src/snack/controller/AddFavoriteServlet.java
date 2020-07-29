package snack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;
import snack.model.FavoriteModel;

@WebServlet("/favorite/add")
public class AddFavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // IDの取得
        int itemId = 0;
        try {
            itemId = Integer.parseInt(request.getParameter("id"));
        } catch(NumberFormatException e) {
            response.sendError(400);
            return;
        }

        // セッション取得
        HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        // データベース
        FavoriteModel favModel = new FavoriteModel();
        int result = favModel.action(userInfo.getId(), itemId);

        PrintWriter out = response.getWriter();
        out.println(result);
    }
}
