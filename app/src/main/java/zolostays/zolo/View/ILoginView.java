package zolostays.zolo.View;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface ILoginView {

    void showSnackbarError();
    void hideSnackbar();

    void showErrorOnEmail();
    void showErrorOnPassword();

    void showDialog();
    void dismissDialog();

    void openRegistrationPage();
    void openForgotPassPage();
    void openProfilePage();
}
