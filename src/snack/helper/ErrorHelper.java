package snack.helper;

import java.util.ArrayList;
import java.util.HashMap;

public class ErrorHelper {

    public static HashMap<String, ArrayList<String>> add(HashMap<String, ArrayList<String>> errors, String key, String message) {

        if(errors == null) {
            errors = new HashMap<String, ArrayList<String>>();
        }

        // キー（エラー項目）がすでに存在するなら
        if(errors.containsKey(key)) {
            ArrayList<String> messages = errors.get(key); //

            if(messages == null) {
                messages = new ArrayList<String>();
            }

            messages.add(message);
            errors.put(key, messages);
        } else {
            ArrayList<String> messages = new ArrayList<String>();
            messages.add(message);
            errors.put(key, messages);
        }

        return errors;

    }

    public static ArrayList<String> get(HashMap<String, ArrayList<String>> errors, String key) {

        ArrayList<String> messages = errors.get(key);
        if(messages != null) {
            return messages;
        } else {
            return new ArrayList<String>();
        }

    }

}
