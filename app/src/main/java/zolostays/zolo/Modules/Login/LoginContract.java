package zolostays.zolo.Modules.Login;

import zolostays.zolo.BaseView;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{
        void showSnackbarError();
        void hideSnackbar();

        void showErrorOnEmail();
        void showErrorOnPassword();
        void clearErrors();

        void showDialog();
        void dismissDialog();

        void openRegistrationPage();
        void openForgotPassPage();
        void openProfilePage();
    }

    interface Presenter {
        void loginClicked(String phone, String pass);

        void createAccountClicked();

        void forgotPasswordClicked();

        void inputModified(String phone, String pass);
    }
}
