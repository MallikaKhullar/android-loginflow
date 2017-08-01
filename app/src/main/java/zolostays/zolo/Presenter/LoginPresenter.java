package zolostays.zolo.Presenter;

import zolostays.zolo.Interactor.LoginInteractor;
import zolostays.zolo.Utils.OnLoginFinishedListener;
import zolostays.zolo.View.ILoginView;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginPresenter implements ILoginPresenter, OnLoginFinishedListener {

    private ILoginView view;
    private LoginInteractor interactor;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
        this.interactor = new LoginInteractor();
    }

    @Override
    public void loginClicked(String phone, String pass) {
        interactor.matchLoginPassword(this, phone, pass);
    }

    @Override
    public void createAccountClicked() {
        view.openRegistrationPage();
    }

    @Override
    public void forgotPasswordClicked() {
        view.openForgotPassPage();
    }

    @Override
    public void onError() {
        view.showSnackbarError();
    }

    @Override
    public void onSuccess() {
        view.openProfilePage();
    }

    @Override
    public void inputModified(String phone, String pass) {
        view.hideSnackbar();
        switch(interactor.validateInput(phone, pass)) {
            case PASSWORD: view.showErrorOnPassword(); break;
            case EMAIL: view.showErrorOnEmail(); break;
        }
    }
}
