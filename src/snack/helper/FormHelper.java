package snack.helper;

import java.util.ArrayList;
import java.util.HashMap;

public class FormHelper {
    public static HashMap<String, ArrayList<String>> checkEmpty(HashMap<String, ArrayList<String>> errors, String name, String str) {
        if(str == null) {
            return ErrorHelper.add(errors, name, "入力してください。");
        }

        if(str.replaceAll(" ", "").equals("")) {
            return ErrorHelper.add(errors, name, "入力してください。");
        }

        return errors;
    }
}
