package snack.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart/add")
@SuppressWarnings("unchecked")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // IDの取得
        int itemId = 0;
        int count = 0;
        try {
            itemId = Integer.parseInt(request.getParameter("id"));
            count = Integer.parseInt(request.getParameter("count"));
        } catch(NumberFormatException e) {
            response.sendError(400);
            return;
        }

        // セッション取得
        HttpSession session = request.getSession(false);
        Map<Integer, Integer> cart = (Map<Integer, Integer>)session.getAttribute("cart");
        if(cart == null) cart = new HashMap<Integer, Integer>();

        if(count == 0) {
            cart.remove(itemId);
        } else {
            cart.put(itemId, count);
        }

        // セッションに格納
        session.setAttribute("cart", cart);
    }
}
