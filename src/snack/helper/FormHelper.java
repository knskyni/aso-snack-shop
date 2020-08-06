package snack.helper;

public class FormHelper {
    public static boolean checkEmpty(String str) {
        if(str == null) {
            return true;
        }

        if(str.replaceAll(" ", "").equals("")) {
            return true;
        }

        return false;
    }
}
