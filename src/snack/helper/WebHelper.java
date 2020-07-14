package snack.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class WebHelper {
    public static String getRootURL(HttpServletRequest request) {
        return "//" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static String getStrParamFromPart(HttpServletRequest request, String name) throws ServletException, IOException, IllegalStateException {
        String param = null;
        Part part = request.getPart(name);
        String contentType = part.getContentType();

        if(contentType == null) {
            try(InputStream is = part.getInputStream()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                param = br.lines().collect(Collectors.joining(System.getProperty("line.separator")));
            } catch(IOException e) {
                throw e;
            }
        }

        return param;
    }
}
