package snack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import snack.bean.PurchaseBean;
import snack.bean.UserBean;
import snack.model.ItemModel;
import snack.model.PurchaseModel;

@WebServlet("/purchase/comfirm")
public class PurchaseComfirmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションから取得
        HttpSession session = request.getSession(false);
        UserBean userInfo = (UserBean)session.getAttribute("userAuth");
        //HashMap<Integer,Integer> carts = (HashMap<Integer,Integer>)session.getAttribute("cart");

        Map<Integer, Integer> carts  = new HashMap<Integer, Integer>() ;
        carts.put(1, 3);
        carts.put(2, 2);

        ItemModel itemModel = new ItemModel();

        List<ItemBean> items = new ArrayList<ItemBean>();
        int totalPrice = 0;

        for(HashMap.Entry<Integer,Integer> cart : carts.entrySet()) {
            int id = cart.getKey();;
            int count = cart.getValue();;

            ItemBean itemInfo = itemModel.show(id);
            itemInfo.setCount(count);
            items.add(itemInfo);

            totalPrice += itemInfo.getPrice() * count;
        }

        PurchaseBean purchaseBean = new PurchaseBean();
        purchaseBean.setItems(items);
        purchaseBean.setTotalPrice(totalPrice);
        purchaseBean.setUserId(userInfo.getId());

        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("purchase", purchaseBean);

        Date d = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        d = calendar.getTime();

        SimpleDateFormat d2 = new SimpleDateFormat("yyyy年MM月dd日");
        String c2 = d2.format(d);

        session.setAttribute("date", c2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/comfirm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッション取得
        HttpSession session = request.getSession(false);
        PurchaseBean purchaseBean = (PurchaseBean)session.getAttribute("purchase");

        if(purchaseBean == null) {
            response.sendError(400);
            return;
        }

        PurchaseModel purchaseModel = new PurchaseModel();
        purchaseModel.execute(purchaseBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../WEB-INF/jsp/purchase/complete.jsp");
        dispatcher.forward(request, response);
    }
}
