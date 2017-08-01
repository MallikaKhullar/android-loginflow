package zolostays.zolo.Interactor;

import zolostays.zolo.Utils.InvalidType;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface IRegistrationInteractor {
    void enterCredsInDb(OnLoginFinishedListener listener, String phone, String email, String name, String pass);
    InvalidType validateInput(String phone, String email, String name, String pass);
}