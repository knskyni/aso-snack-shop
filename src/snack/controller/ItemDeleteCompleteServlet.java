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

@WebServlet("/item/delete/complete")
public class ItemDeleteCompleteServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/delete_complete.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッション
        HttpSession session = request.getSession(false);
        ItemBean news = (ItemBean)session.getAttribute("deleteItem");

        // Beanの存在確認
        if(news == null) {
            response.sendError(400);
            return;
        }

        // セッションから削除
        session.removeAttribute("deleteItem");

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
