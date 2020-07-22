package snack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import snack.model.ItemModel;

@WebServlet("/purchase/comfirm")
public class PurchaseComfirmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションから取得
        HttpSession session = request.getSession(false);
        UserBean userAuth = (UserBean)session.getAttribute("userAuth");
        HashMap<Integer,Integer> cart = (HashMap<Integer,Integer>)session.getAttribute("cart");

        ItemModel itemModel = new ItemModel();

        List<ItemBean> items = new ArrayList<ItemBean>();
        int totalPrice = 0;

        for(HashMap.Entry<Integer,Integer> Cart : cart.entrySet()) {
            int id = Cart.getKey();
            int count = Cart.getValue();

            ItemBean itemInfo = itemModel.show(id);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/comfirm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
