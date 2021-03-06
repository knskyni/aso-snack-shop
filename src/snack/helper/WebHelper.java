package snack.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.codec.digest.DigestUtils;

import snack.exception.FormFileEmptyException;

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

    public static String saveFileFromPart(HttpServletRequest request, String name, String path) throws ServletException, IOException, FormFileEmptyException {
        Part part = request.getPart(name);
        path = System.getProperty("user.home") + "/B5_sweeter/" + path;

        if(part.getHeader("Content-Disposition").contains("filename=\"\"")) {
            throw new FormFileEmptyException();
        }

        // ディレクトリ生成
        File directory = new File(path);
        if(!directory.exists()) {
            directory.mkdirs();
        }

        // ファイルデータのハッシュ値取得（ファイル名に使用）
        String fileName = DigestUtils.md5Hex(part.getInputStream());

        // 拡張子の取得
        try {
            for(String line : part.getHeader("Content-Disposition").split(";")) {
                line = line.trim();
                if(line.startsWith("filename")) {
                    fileName += line.substring(line.indexOf(".")).replaceAll("\"", "");
                }
            }
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("拡張子がないファイルが投稿されました。\"" + fileName + "\"で保存しました。");
        }

        // ファイルの保存
        part.write(path + fileName);

        return fileName;
    }
}
