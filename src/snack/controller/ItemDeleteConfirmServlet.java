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

@WebServlet("/item/delete/confirm")
public class ItemDeleteConfirmServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/delete_confirm.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータからIDを取得
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch(Exception e) {
            response.sendError(400);
            return;
        }

        // データベースから情報取得
        ItemModel itemModel = new ItemModel();
        ItemBean itemBean = itemModel.show(id);

        // データベースに存在しなかった場合に404エラー
        if(itemBean == null) {
            response.sendError(404);
            return;
        }

        // セッションに情報を保存
        HttpSession session = request.getSession(false);
        session.setAttribute("deleteItem", itemBean);

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション
        HttpSession session = request.getSession(false);
        ItemBean news = (ItemBean)session.getAttribute("deleteItem");

        // Beanの存在確認
        if(news == null) {
            response.sendError(400);
            return;
        }

        // データベース登録
        ItemModel itemModel = new ItemModel();
        boolean result = itemModel.delete(news.getId());

        // 遷移
        if(result) {
            response.sendRedirect("complete");
        } else {
            response.sendError(400);
        }
    }
}
