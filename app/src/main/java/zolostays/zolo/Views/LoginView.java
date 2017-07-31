package zolostays.zolo.Views;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface LoginView {
    
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
