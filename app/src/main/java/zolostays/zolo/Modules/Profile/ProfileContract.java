package zolostays.zolo.Modules.Profile;

import zolostays.zolo.Data.Repo.UserObject;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface ProfileContract {

    interface View{
        void clearErrors();
        void hideUpdateButton();
        void showUpdateButton();
        void openLoginPage();
        void showErrorOnName();
        void showErrorOnPhone();
    }

    interface Presenter {
        void updateUserInfo(UserObject user);
        void logOut();
        UserObject getCurrentUser();
        void inputModified(String name, String phone);
    }
}