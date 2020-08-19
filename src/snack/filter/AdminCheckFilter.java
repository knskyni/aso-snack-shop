package snack.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import snack.bean.UserBean;

@WebFilter("/*")
public class AdminCheckFilter implements Filter {
    private final String[] path = {
            "/item/create/input", "/item/create/confirm", "/item/create/complete",
            "/item/update/input", "/item/update/confirm", "/item/update/complete",
            "/item/delete/confirm", "/item/delete/complete",
            "/news/create/input", "/news/create/confirm", "/news/create/complete",
            "/news/update/input", "/news/update/confirm", "/news/update/complete",
            "/news/delete/confirm", "/news/delete/complete"
            };
    private final String[] exclude = {"/cart/list", "/cart/add", "/favorite/list", "/favorite/add", "/purchase/auth", "/purchase/select", "/purchase/comfirm", "/purchase/complete"};

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String accessPath = ((HttpServletRequest)request).getServletPath();
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");

        if(Arrays.asList(path).contains(accessPath)) {
            if(userInfo != null && userInfo.getType().equals("admin")) {
                chain.doFilter(request, response);
                return;
            }
            ((HttpServletResponse)response).sendError(403);
            return;
        }

        // 管理者でアクセスできないページをブロック
        if(Arrays.asList(exclude).contains(accessPath)) {
            if(userInfo != null && userInfo.getType().equals("admin")) {
                ((HttpServletResponse)response).sendError(403);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
