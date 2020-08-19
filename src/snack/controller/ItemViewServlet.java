package snack.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.ItemBean;
import snack.bean.UserBean;
import snack.model.FavoriteModel;
import snack.model.ItemModel;

@WebServlet("/item/show")
public class ItemViewServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch(Exception e) {
            response.sendError(400);
            return;
        }

        // データベースから情報取得
        ItemModel itemDao = new ItemModel();
        ItemBean itemBean = itemDao.show(id);

        // セッション取得
        HttpSession session = request.getSession(true);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        // ユーザーがお気に入り追加しているか
        if(userInfo != null && userInfo.getType().equals("user")) {
            FavoriteModel favModel = new FavoriteModel();
            boolean faved = favModel.exist(userInfo.getId(), id);

            request.setAttribute("faved", faved);
        } else {
            request.setAttribute("faved", false);
        }


        request.setAttribute("itemview", itemBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/item/detail.jsp");
        dispatcher.forward(request, response);
    }
}
