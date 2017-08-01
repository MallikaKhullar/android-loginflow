package zolostays.zolo.Modules.Registration;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface RegistrationContract {

    interface View {
        //errors
        void showErrorOnPhone();
        void showErrorOnPassword();
        void showErrorOnName();
        void showErrorOnEmail();
        void clearErrors();

        //dialogs
        void showDialog();
        void dismissDialog();

        //flow
        void openLoginPage();
    }

    interface Presenter{
        //click events
        void registerClicked(String phone, String email, String name, String pass);
        void loginClicked();

        //input modification
        void inputModified(String phone, String email, String name, String pass);

    }
}