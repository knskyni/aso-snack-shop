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

    public static boolean checkLength(String str, int min, int max) {
        int length = str.length();
        if(length >= min && length <= max) {
            return false;
        }

        return true;
    }
}
