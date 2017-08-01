package zolostays.zolo.Modules.Registration;

import javax.inject.Inject;

import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter, OnLoginFinishedListener {

    private RegistrationContract.View view;

    @Inject RegistrationPresenter(RegistrationContract.View loginView) {
        this.view = loginView;
    }

    @Override
    public void onError() {
        view.dismissDialog();
    }

    @Override
    public void onSuccess() {
        view.dismissDialog();
        view.openLoginPage();
    }

    @Override
    public void inputModified(String phone, String email, String name, String pass) {
//        switch(interactor.validateInput(phone, email, name, pass)) {
//            case PASSWORD: view.showErrorOnPassword(); break;
//            case EMAIL: view.showErrorOnEmail(); break;
//            case NAME: view.showErrorOnName();break;
//            case PHONE: view.showErrorOnPhone();break;
//        }
    }

    @Override
    public void registerClicked(String phone, String email, String name, String pass) {
    }

    @Override
    public void loginClicked() {
        view.openLoginPage();
    }

}
