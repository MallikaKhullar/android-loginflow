package zolostays.zolo.Modules.Login;

import android.content.SharedPreferences;

import javax.inject.Inject;

import zolostays.zolo.Data.Repo.UserDataSource;
import zolostays.zolo.Data.Repo.UserObject;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Utils.InputValidation;
import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class LoginPresenter implements LoginContract.Presenter, OnProcessFinishedCallback {

    LoginContract.View mView;
    UserDataSource mUserRepo;
    SharedPreferences mSharedPreferences;

    @Inject LoginPresenter(UserRepo userRepo, SharedPreferences sPrefs, LoginContract.View loginView) {
        this.mView = loginView;
        this.mUserRepo = userRepo;
        this.mSharedPreferences = sPrefs;
    }

    /**
     * This is method injection (Dagger2 will call this by default)
     * Safe to use because method injection is the last type of injection called
     */


    @Override
    public void loginClicked(String email, String pass) {

        switch(InputValidation.validateInputForLogin(email, pass)) {
            case PASSWORD: mView.showErrorOnPassword(); return;
            case EMAIL: mView.showErrorOnEmail(); return;
        }

        mUserRepo.getUserWithEmail(email, new UserDataSource.GetUserCallback() {
            @Override
            public void onUserFound(UserObject user) {
                mSharedPreferences.edit().putBoolean("logged-in", true).apply();
                mView.openProfilePage();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showSnackbarError();
                mSharedPreferences.edit().putBoolean("logged-in", false).apply();
            }
        });
    }

    @Override
    public void createAccountClicked() {
        mView.openRegistrationPage();
    }

    @Override
    public void forgotPasswordClicked() {
        mView.openForgotPassPage();
    }

    @Override
    public void onError() {
        mView.showSnackbarError();
    }

    @Override
    public void onSuccess() {
        mView.openProfilePage();
    }

    @Override
    public void inputModified(String email, String pass) {
        mView.hideSnackbar();
        mView.clearErrors();
    }
}
