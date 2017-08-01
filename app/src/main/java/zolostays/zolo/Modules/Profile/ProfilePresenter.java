package zolostays.zolo.Modules.Profile;

import javax.inject.Inject;

import zolostays.zolo.Modules.Registration.RegistrationContract;
import zolostays.zolo.Modules.Registration.RegistrationInteractor;
import zolostays.zolo.Utils.OnLoginFinishedListener;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


public class ProfilePresenter implements ProfileContract.Presenter, OnLoginFinishedListener {

    @Inject
    ProfilePresenter(ProfileContract.View view) {
//        this.view = loginView;
//        this.interactor = new RegistrationInteractor();
    }
    @Override
    public void start() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {

    }
}