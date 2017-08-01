package zolostays.zolo.Interactor;

import zolostays.zolo.Utils.InvalidType;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface ILoginInteractor {
    void matchLoginPassword(OnLoginFinishedListener listener, String username, String password);
    InvalidType validateInput(String email, String password);
}
