package zolostays.zolo.Presenter;

import zolostays.zolo.Utils.InvalidType;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface ILoginPresenter {

    void loginClicked(String phone, String pass);

    void createAccountClicked();

    void forgotPasswordClicked();

    void inputModified(String phone, String pass);

}

