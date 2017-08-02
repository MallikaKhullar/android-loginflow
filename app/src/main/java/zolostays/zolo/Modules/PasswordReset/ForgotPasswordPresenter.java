package zolostays.zolo.Modules.PasswordReset;

import android.content.SharedPreferences;

import java.util.Random;

import javax.inject.Inject;

import rsg.mailchimp.api.MailChimpApiException;
import rsg.mailchimp.api.lists.ListMethods;
import zolostays.zolo.Data.Repo.UserDataSource;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Utils.OnProcessFinishedCallback;
import zolostays.zolo.Utils.Services.EmailService;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class ForgotPasswordPresenter implements ForgotPassContract.Presenter, OnProcessFinishedCallback {

    ForgotPassContract.View mView;
    UserRepo mUserRepo;
    EmailService mEmailService;

    @Inject ForgotPasswordPresenter(EmailService mEmailService, UserRepo userRepo,  ForgotPassContract.View loginView) {
        this.mView = loginView;
        this.mUserRepo = userRepo;
        this.mEmailService = mEmailService;
    }

    /**
     * This is method injection (Dagger2 will call this by default)
     * Safe to use because method injection is the last type of injection called
     */


    @Override
    public void resetClicked(String email) {
        mView.hideSnackbar();
        mEmailService.sendEmail(email, this);
    }

    @Override
    public void inputModified(String email) {
        mView.hideSnackbar();
        mView.clearErrors();
    }

    @Override
    public void loginClicked() {
        mView.openLoginPage();
    }

    @Override
    public void onError() {
        //email didn't go properly
        mView.showSnackbarError();
    }

    @Override
    public void onSuccess() {
        //email went fine
        mView.openLoginPage();
    }

    private void updateUserDetails(String email, String pass){
        mUserRepo.updateUserDetails(email, pass);
    }



}
