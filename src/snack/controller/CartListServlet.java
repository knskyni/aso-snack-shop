package snack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.ItemBean;
import snack.model.ItemModel;

@WebServlet("/cart")
@SuppressWarnings("unchecked")
public class CartListServlet extends HttpServlet {
    private static final String jsp = "./WEB-INF/jsp/cart.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッション取得
        HttpSession session = request.getSession(false);
        Map<Integer, Integer> cart = (Map<Integer, Integer>)session.getAttribute("cart");
        if(cart == null) cart = new HashMap<Integer, Integer>();

        // 商品一覧
        List<ItemBean> items = new ArrayList<ItemBean>();

        // データベース
        ItemModel itemModel = new ItemModel();

        // 商品情報取得
        for (Map.Entry<Integer, Integer> row : cart.entrySet()) {
            ItemBean item = itemModel.show(row.getKey());
            item.setCount(row.getValue());

            items.add(item);
        }

        // JSP
        request.setAttribute("items", items);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
