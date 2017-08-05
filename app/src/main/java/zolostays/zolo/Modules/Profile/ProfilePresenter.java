package zolostays.zolo.Modules.Profile;

import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import zolostays.zolo.Data.Repo.UserDataSource;
import zolostays.zolo.Data.Repo.UserObject;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginActivity;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Modules.Login.LoginPresenter;
import zolostays.zolo.Utils.InputValidation;
import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


public class ProfilePresenter implements ProfileContract.Presenter {

    public static String LOGIN_STATUS = "login_status";
    public static String STORED_USER = "stored_user";

    ProfileContract.View mView;
    UserDataSource mUserRepo;
    SharedPreferences mSharedPreferences;

    @Inject ProfilePresenter(UserRepo userRepo, SharedPreferences sPrefs, ProfileContract.View view) {
        this.mView = view;
        this.mUserRepo = userRepo;
        this.mSharedPreferences = sPrefs;
    }



    @Override
    public void updateUserInfo(UserObject user) {

        switch(InputValidation.validateUpdateForm(user.getName(), user.getPhone())) {
            case PHONE: mView.showErrorOnPhone(); return;
            case NAME: mView.showErrorOnName(); return;
        }

        user.setId(getCurrentUser().getId());

        mUserRepo.updateUserDetails(user.getId(), user.getEmail(), user.getName(), user.getPhone());
        mSharedPreferences.edit().putString(STORED_USER, user.getJsonObject().toString()).apply();
        mView.hideUpdateButton();
    }

    @Override
    public void logOut() {
        mSharedPreferences.edit().remove(LOGIN_STATUS).apply();
        mSharedPreferences.edit().remove(STORED_USER).apply();
    }

    @Override
    public UserObject getCurrentUser() {
        try {
            JSONObject userJson = new JSONObject(mSharedPreferences.getString(LoginPresenter.STORED_USER, "{}"));
            return UserObject.getFromJSON(userJson);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public void inputModified(String name, String phone) {
        mView.clearErrors();
    }

}