package zolostays.zolo.Modules.Login;

import android.os.Handler;

import zolostays.zolo.Utils.InvalidType;
import zolostays.zolo.Utils.OnLoginFinishedListener;

import static zolostays.zolo.Utils.InputValidation.isValidEmail;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginInteractor {

    public LoginInteractor() { }

    public void matchLoginPassword(final OnLoginFinishedListener listener, final String username, final String password){
        new Handler().post(new Runnable() {
            @Override public void run() {
                //TODO - mysql code here
//                    listener.onSuccess();
//                    listener.onError();
            }
        });
    }

    public InvalidType validateInput(final String email, final String password) {
        if (!isValidEmail(email)) return InvalidType.EMAIL;
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) return InvalidType.PASSWORD;
        return InvalidType.VALID;
    }
}
