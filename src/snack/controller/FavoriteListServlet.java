package snack.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/favorite/list")
public class FavoriteListServlet extends HttpServlet {
    private static final String jsp = "../WEB-INF/jsp/favorite/user_list.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション取得
        HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        // お気に入り取得
        FavoriteModel favModel = new FavoriteModel();
        List<ItemBean> items = favModel.userFavorite(userInfo.getId());

        // リクエスト格納
        request.setAttribute("favItems", items);

        // JSP
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
