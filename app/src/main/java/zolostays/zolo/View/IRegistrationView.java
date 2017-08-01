package zolostays.zolo.View;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */


public interface IRegistrationView {

    void showErrorOnPhone();
    void showErrorOnPassword();
    void showErrorOnName();
    void showErrorOnEmail();

    void showDialog();
    void dismissDialog();

    void openLoginPage();
}
