package zolostays.zolo.Modules.PasswordReset;

import zolostays.zolo.BaseView;
import zolostays.zolo.Modules.Login.LoginContract;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface ForgotPassContract {

    interface View {
        //error
        void showErrorOnEmail();
        void clearErrors();
        void showSnackbarError();
        void hideSnackbar();


        //dialogs
        void showDialog();
        void dismissDialog();

        //flow
        void openLoginPage();
    }

    interface Presenter {
        //click events
        void resetClicked(String email);
        void loginClicked();

        //input modification
        void inputModified(String email);
    }
}