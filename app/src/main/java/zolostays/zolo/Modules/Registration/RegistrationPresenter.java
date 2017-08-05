package zolostays.zolo.Modules.Registration;

import android.content.SharedPreferences;

import java.util.UUID;

import javax.inject.Inject;

import zolostays.zolo.Data.Repo.UserDataSource;
import zolostays.zolo.Data.Repo.UserObject;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter, OnProcessFinishedCallback {

    private RegistrationContract.View mView;
    UserDataSource mUserRepo;
    SharedPreferences mSharedPreferences;

    @Inject RegistrationPresenter(UserRepo userRepo, SharedPreferences sPrefs, RegistrationContract.View loginView) {
        this.mView = loginView;
        this.mUserRepo = userRepo;
        this.mSharedPreferences = sPrefs;
    }

    @Override
    public void onError() {
        mView.dismissDialog();
    }

    @Override
    public void onSuccess() {
        mView.dismissDialog();
        mView.openLoginPage();
    }

    @Override
    public void inputModified(String phone, String email, String name, String pass) {
        mView.hideSnackbar();
//        switch(interactor.validateInput(phone, email, name, pass)) {
//            case PASSWORD: mView.showErrorOnPassword(); break;
//            case EMAIL: mView.showErrorOnEmail(); break;
//            case NAME: mView.showErrorOnName();break;
//            case PHONE: mView.showErrorOnPhone();break;
//        }
    }

    @Override
    public void registerClicked(String phone, String email, String name, String pass) {
        UserObject userObject = new UserObject(phone, email, name, pass, UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        if(mUserRepo.createUser(userObject) == -1) {
            mView.showSnackbarError();
        } else {
            mView.openLoginPage();
        }
    }

    @Override
    public void loginClicked() {
        mView.openLoginPage();
    }

}
