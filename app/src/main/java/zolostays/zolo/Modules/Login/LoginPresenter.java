package zolostays.zolo.Modules.Login;

import javax.inject.Inject;

import zolostays.zolo.App;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginPresenter implements LoginContract.Presenter, OnLoginFinishedListener {

    private LoginContract.View mLoginView;
    private LoginInteractor interactor;

    @Inject LoginPresenter(LoginContract.View loginView) {
        this.mLoginView = loginView;
        App.getInstance().getAppComponent().inject(this);
        this.interactor = new LoginInteractor();
    }

    @Override
    public void loginClicked(String phone, String pass) {
        interactor.matchLoginPassword(this, phone, pass);
    }

    @Override
    public void createAccountClicked() {
        mLoginView.openRegistrationPage();
    }

    @Override
    public void forgotPasswordClicked() {
        mLoginView.openForgotPassPage();
    }

    @Override
    public void onError() {
        mLoginView.showSnackbarError();
    }

    @Override
    public void onSuccess() {
        mLoginView.openProfilePage();
    }

    @Override
    public void inputModified(String phone, String pass) {
        mLoginView.hideSnackbar();
        switch(interactor.validateInput(phone, pass)) {
            case PASSWORD: mLoginView.showErrorOnPassword(); break;
            case EMAIL: mLoginView.showErrorOnEmail(); break;
        }
    }

    @Override
    public void start() {

    }
}
