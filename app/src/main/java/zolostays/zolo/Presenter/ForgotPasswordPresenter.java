package zolostays.zolo.Presenter;

import android.content.Intent;

import zolostays.zolo.Activities.ForgotPasswordActivity;
import zolostays.zolo.Activities.LoginActivity;
import zolostays.zolo.Interactor.LoginInteractor;
import zolostays.zolo.View.IForgotPasswordView;
import zolostays.zolo.View.ILoginView;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class ForgotPasswordPresenter implements IForgotPasswordPresenter {

    private IForgotPasswordView view;

    public ForgotPasswordPresenter(IForgotPasswordView loginView) {
        this.view = loginView;
    }

    @Override
    public void resetClicked(String email) {

    }

    @Override
    public void inputModified(String email) {

    }

    @Override
    public void loginClicked() {
        view.openLoginPage();
    }
}
