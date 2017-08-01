package zolostays.zolo.View;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */


public interface IRegistrationView {

    void openLoginPage();

    void showErrorOnPhone();

    void showErrorOnPassword();

    void showErrorOnName();

    void dismissDialog();

    void showDialog();

    void showErrorOnEmail();
}
