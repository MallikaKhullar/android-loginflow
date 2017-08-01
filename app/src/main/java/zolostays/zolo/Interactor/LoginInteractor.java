package zolostays.zolo.Interactor;

import android.os.Handler;

import zolostays.zolo.Utils.InvalidType;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginInteractor implements ILoginInteractor {

    public LoginInteractor() { }



    public void matchLoginPassword(final OnLoginFinishedListener listener, final String username, final String password){
        new Handler().post(new Runnable() {
            @Override public void run() {
                //TODO - mysql code here
//                if ((username.length() > 3) && (password.length() > 3)) {
//                    listener.onSuccess();
//                } else {
//                    listener.onError();
//                }
            }
        });
    }

    public InvalidType validateInput(final String email, final String password) {
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return InvalidType.EMAIL;
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) return InvalidType.PASSWORD;
        return InvalidType.VALID;
    }
}
