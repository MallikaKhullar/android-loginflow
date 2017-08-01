package zolostays.zolo.Modules.PasswordReset;

import javax.inject.Inject;

import zolostays.zolo.ZoloLoginMainApplication;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class ForgotPasswordPresenter implements ForgotPassContract.Presenter {

    private ForgotPassContract.View view;

    @Inject ForgotPasswordPresenter(ForgotPassContract.View loginView) {
        this.view = loginView;
        ZoloLoginMainApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void resetClicked(String email) {}

    @Override
    public void inputModified(String email) {}

    @Override
    public void loginClicked() {
        view.openLoginPage();
    }

    @Override
    public void start() {}
}
