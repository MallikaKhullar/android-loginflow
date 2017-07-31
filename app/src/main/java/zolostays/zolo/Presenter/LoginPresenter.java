package zolostays.zolo.Presenter;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface LoginPresenter {

    void loginClicked(String phone, String pass);

    void createAccountClicked();

    void forgotPasswordClicked();

    void phoneModified();

    void passwordModified();

    void onDestroy();
}

