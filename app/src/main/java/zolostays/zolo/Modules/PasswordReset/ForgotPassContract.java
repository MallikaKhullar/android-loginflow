package zolostays.zolo.Modules.PasswordReset;

import zolostays.zolo.BasePresenter;
import zolostays.zolo.BaseView;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface ForgotPassContract {

    interface View extends BaseView<Presenter> {
        //error
        void showErrorOnEmail();

        //dialogs
        void showDialog();
        void dismissDialog();

        //flow
        void openLoginPage();
    }

    public interface Presenter extends BasePresenter {
        //click events
        void resetClicked(String email);
        void loginClicked();

        //input modification
        void inputModified(String email);
    }
}