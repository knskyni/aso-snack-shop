package snack.helper;

import javax.servlet.http.HttpServletRequest;

public class WebHelper {
    public static String getRootURL(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
