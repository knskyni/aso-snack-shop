package snack.helper;

public class StringHelper {

    public static String nullToBlank(String str) {
        if(str == null) return "";
        return str;
    }

}
