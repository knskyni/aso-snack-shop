package snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.ItemBean;
import snack.model.ItemModel;


@WebServlet("/cartadd")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  カートに商品追加
        //商品ID
        int id = Integer.parseInt("id");

        ItemModel itemModel = new ItemModel();

        List<ItemBean> Cart = itemModel.getList(id);

        //////////////////////////////////////
        //sessionに格納
        HttpSession session = request.getSession(false);
        session.setAttribute("cartList", Cart);
    }
}
