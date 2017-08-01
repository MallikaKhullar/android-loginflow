package zolostays.zolo.Utils;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class InputValidation {

    public static boolean isValidEmail(String email){
        return email!=null && !email.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidName(String name){
        return name!=null && !name.isEmpty() && name.length() > 4;
    }

    public static boolean isValidPhone(String phone){
        return phone!= null && !phone.isEmpty() && phone.length() == 10;
    }

    public static boolean isValidPassword(String password){
        if (password != null
                && !password.isEmpty()
                && password.length() >= 6
                && password.length() <= 10
                && password.matches(".+[A-Z].+")
                && password.matches(".+[a-z].+")
                && password.matches(".+[1-9].+")) {
            return true;
        }
        return false;
    }

    public static boolean doPasswordsMatch(String value1, String value2) {
        return value1.trim().contentEquals(value2.trim());
    }
}
