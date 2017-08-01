package zolostays.zolo.Modules.Login;

import javax.inject.Inject;

import zolostays.zolo.Data.UserDataSource;
import zolostays.zolo.Data.UserObject;
import zolostays.zolo.Data.UserRepo;
import zolostays.zolo.Utils.InputValidation;
import zolostays.zolo.ZoloLoginMainApplication;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginPresenter implements LoginContract.Presenter, OnLoginFinishedListener {

    private LoginContract.View mLoginView;
    private UserRepo mUserRepo;

    @Inject LoginPresenter(UserRepo userRepo, LoginContract.View loginView) {
        this.mLoginView = loginView;
        this.mUserRepo = userRepo;
    }

    /**
     * This is method injection (Dagger2 will call this by default)
     * Safe to use because method injection is the last type of injection called
     */
    @Inject
    void setupListeners() {
        mLoginView.setPresenter(this);
    }

    @Override
    public void loginClicked(String email, String pass) {
        mUserRepo.getUserWithEmail(email, new UserDataSource.GetUserCallback() {
            @Override
            public void onUserFound(UserObject user) {
                mLoginView.openProfilePage();
            }

            @Override
            public void onDataNotAvailable() {
                mLoginView.showSnackbarError();
            }
        });
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
    public void inputModified(String email, String pass) {
        mLoginView.hideSnackbar();
        switch(InputValidation.validateInput(email, pass)) {
            case PASSWORD: mLoginView.showErrorOnPassword(); break;
            case EMAIL: mLoginView.showErrorOnEmail(); break;
        }
    }
}
