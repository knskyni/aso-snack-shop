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

@WebServlet("/item/update/complete")
public class ItemUpdateCompleteServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/update_complete.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッション
        HttpSession session = request.getSession(false);
        ItemBean item = (ItemBean)session.getAttribute("updateItem");

        // Beanの存在確認
        if(item == null) {
            response.sendError(400);
            return;
        }

        // セッションから削除
        session.removeAttribute("updateItem");

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
