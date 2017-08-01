package zolostays.zolo.Interactor;

import android.os.Handler;

import zolostays.zolo.Utils.InvalidType;
import zolostays.zolo.Utils.OnLoginFinishedListener;

import static zolostays.zolo.Utils.ValidityUtils.isValidEmail;
import static zolostays.zolo.Utils.ValidityUtils.isValidName;
import static zolostays.zolo.Utils.ValidityUtils.isValidPassword;
import static zolostays.zolo.Utils.ValidityUtils.isValidPhone;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class RegistrationInteractor implements IRegistrationInteractor {
    @Override
    public void enterCredsInDb(OnLoginFinishedListener listener, String phone, String email, String name, String pass) {
        new Handler().post(new Runnable() {
        @Override public void run() {
            //TODO - mysql code here
            //listener.onSuccess();
            //listener.onError();
        }
    });
}
    @Override
    public InvalidType validateInput(String phone, String email, String name, String password) {
        if (!isValidEmail(email)) return InvalidType.EMAIL;
        if (!isValidName(name)) return InvalidType.NAME;
        if (!isValidPhone(phone)) return InvalidType.PHONE;
        if (!isValidPassword(password)) return InvalidType.PASSWORD;
        return InvalidType.VALID;
    }
}
