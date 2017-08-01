package zolostays.zolo.Presenter;

import zolostays.zolo.Interactor.IRegistrationInteractor;
import zolostays.zolo.Interactor.LoginInteractor;
import zolostays.zolo.Interactor.RegistrationInteractor;
import zolostays.zolo.Utils.OnLoginFinishedListener;
import zolostays.zolo.View.ILoginView;
import zolostays.zolo.View.IRegistrationView;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class RegistrationPresenter implements IRegistrationPresenter, OnLoginFinishedListener {

    private IRegistrationView view;
    private RegistrationInteractor interactor;

    public RegistrationPresenter(IRegistrationView loginView) {
        this.view = loginView;
        this.interactor = new RegistrationInteractor();
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
        switch(interactor.validateInput(phone, email, name, pass)) {
            case PASSWORD: view.showErrorOnPassword(); break;
            case EMAIL: view.showErrorOnEmail(); break;
            case NAME: view.showErrorOnName();break;
            case PHONE: view.showErrorOnPhone();break;
        }
    }

    @Override
    public void registerClicked(String phone, String email, String name, String pass) {
        interactor.enterCredsInDb(this, phone, email, name, pass);
    }

    @Override
    public void loginClicked() {
        view.openLoginPage();
    }
}
