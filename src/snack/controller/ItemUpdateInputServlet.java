package snack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.ItemBean;
import snack.helper.ErrorHelper;
import snack.helper.FormHelper;
import snack.helper.WebHelper;
import snack.model.ItemModel;

@MultipartConfig(location="")
@WebServlet("/item/update/input")
public class ItemUpdateInputServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/update_input.jsp";

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
        session.setAttribute("updateItem", itemBean);

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // エラーメッセージ
        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();

        // Formから取得
        String name = WebHelper.getStrParamFromPart(request, "name");
        String description = WebHelper.getStrParamFromPart(request, "description");
        int price = 0;

        try {
            price = Integer.parseInt(WebHelper.getStrParamFromPart(request, "price"));
        } catch(NumberFormatException e) {
            errors = ErrorHelper.add(errors, "price", "価格が正確な値ではありません。");
        }

        errors = FormHelper.checkEmpty(errors, "name", name);
        errors = FormHelper.checkEmpty(errors, "description", description);

        // セッション取得
        HttpSession session = request.getSession(false);
        ItemBean item = (ItemBean)session.getAttribute("updateItem");

        // Beanに格納
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        // セッションに格納
        session.setAttribute("updateItem", item);

        // エラーの存在によって遷移先の切り替え
        if(errors.isEmpty()) {
            response.sendRedirect("confirm");
        } else {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }
}
