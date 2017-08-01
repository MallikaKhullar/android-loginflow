package zolostays.zolo.Modules.Profile;

import javax.inject.Inject;

import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


public class ProfilePresenter implements ProfileContract.Presenter, OnProcessFinishedCallback {

    @Inject
    ProfilePresenter(ProfileContract.View view) {
//        this.view = loginView;
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