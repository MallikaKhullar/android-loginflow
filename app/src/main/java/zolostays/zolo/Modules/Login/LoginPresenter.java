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

    public static String LOGIN_STATUS = "login_status";
    public static String STORED_USER = "stored_user";

    LoginContract.View mView;
    UserDataSource mUserRepo;
    SharedPreferences mSharedPreferences;

    @Inject LoginPresenter(UserRepo userRepo, SharedPreferences sPrefs, LoginContract.View loginView) {
        this.mView = loginView;
        this.mUserRepo = userRepo;
        this.mSharedPreferences = sPrefs;
    }

    @Override
    public void loginClicked(String email, final String pass) {
        switch(InputValidation.validateInputForLogin(email, pass)) {
            case PASSWORD: mView.showErrorOnPassword(); return;
            case EMAIL: mView.showErrorOnEmail(); return;
        }

        mView.showDialog();
        mUserRepo.getUserWithEmail(email, new UserDataSource.GetUserCallback() {
            @Override
            public void onUserFound(UserObject user) {
                if (!InputValidation.doPasswordsMatch(pass, user.getPass())) {
                    invalidLoginAttempt();
                } else {
                    validLoginAttempt(user);
                }
            }

            @Override
            public void onDataNotAvailable() {
                invalidLoginAttempt();
            }
        });
    }

    private void invalidLoginAttempt(){
        mView.dismissDialog();
        mView.showSnackbarError();
        mSharedPreferences.edit().putBoolean(LOGIN_STATUS, false).apply();
    }

    private void validLoginAttempt(UserObject user) {
        mSharedPreferences.edit().putBoolean(LOGIN_STATUS, true).apply();
        mSharedPreferences.edit().putString(STORED_USER, user.getJsonObject().toString()).apply();
        mView.dismissDialog();
        mView.openProfilePage();
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

    @Override
    public void checkForLogin() {
        if(mSharedPreferences.getBoolean(LOGIN_STATUS, false)) {
            mView.openProfilePage();
        }
    }
}
