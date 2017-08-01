package zolostays.zolo.Modules.PasswordReset;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface ForgotPassContract {

    interface View{
        //error
        void showErrorOnEmail();

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