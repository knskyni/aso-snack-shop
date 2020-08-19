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
import snack.exception.FormFileEmptyException;
import snack.helper.ErrorHelper;
import snack.helper.FormHelper;
import snack.helper.WebHelper;

@MultipartConfig(location="")
@WebServlet("/item/create/input")
public class ItemCreateInputServlet extends HttpServlet {
    private static final String jsp = "../../WEB-INF/jsp/item/create_input.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String imagePath = "";
        int price = 0;

        // nameの入力チェック
        if(FormHelper.checkEmpty(name)) {
            errors = ErrorHelper.add(errors, "name", "入力してください。");
        } else if(FormHelper.checkLength(name, 1, 64)) {
            errors = ErrorHelper.add(errors, "name", "商品名は1文字以上、64文字以内で入力してください。");
        }

        // descriptionの入力チェック
        if(FormHelper.checkEmpty(description)) {
            errors = ErrorHelper.add(errors, "description", "入力してください。");
        } else if(FormHelper.checkLength(description, 1, 4096)) {
            errors = ErrorHelper.add(errors, "description", "説明文は1文字以上、4096文字以内で入力してください。");
        }

        // 画像のチェック
        try {
            imagePath = WebHelper.saveFileFromPart(request, "image", "images/items/");
        } catch(FormFileEmptyException e) {
            errors = ErrorHelper.add(errors, "image", "画像ファイルが選択されていません。");
        }

        // 価格の入力チェック
        try {
            price = Integer.parseInt(WebHelper.getStrParamFromPart(request, "price"));
        } catch(NumberFormatException e) {
            errors = ErrorHelper.add(errors, "price", "価格が正確な値ではありません。");
        }

        // Beanに格納
        ItemBean item = new ItemBean();
        item.setName(name);
        item.setDescription(description);
        item.setImagePath(imagePath);
        item.setPrice(price);

        // セッションに格納
        HttpSession session = request.getSession(false);
        session.setAttribute("createItem", item);

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
