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
import snack.model.ItemModel;

@WebServlet("/item/create/confirm")
public class ItemCreateConfirmServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/create_confirm.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション
        HttpSession session = request.getSession(false);
        ItemBean news = (ItemBean)session.getAttribute("createItem");

        // Beanの存在確認
        if(news == null) {
            response.sendError(400);
            return;
        }

        // JSP表示
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション
        HttpSession session = request.getSession(false);
        ItemBean item = (ItemBean)session.getAttribute("createItem");

        // Beanの存在確認
        if(item == null) {
            response.sendError(400);
            return;
        }

        // データベース登録
        ItemModel itemModel = new ItemModel();
        boolean result = itemModel.create(item);

        // 遷移
        if(result) {
            response.sendRedirect("complete");
        } else {
            response.sendError(400);
        }
    }
}
