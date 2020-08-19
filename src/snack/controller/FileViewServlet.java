package snack.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/view")
public class FileViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dir = System.getProperty("user.home") + "/B5_sweeter/";
        String fileName = request.getParameter("name");

        int iData = 0;

        ServletOutputStream out = null;
        BufferedInputStream in = null;

        try {
            out = response.getOutputStream();

            in = new BufferedInputStream(new FileInputStream(dir + fileName));

            while((iData = in.read()) != -1) {
                out.write(iData);
            }
        } catch(Exception e) {

        } finally {
            if(in != null) in.close();
            if(out != null) out.close();
        }
    }
}
