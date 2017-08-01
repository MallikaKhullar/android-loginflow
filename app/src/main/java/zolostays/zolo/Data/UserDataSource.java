package zolostays.zolo.Data;

import android.support.annotation.NonNull;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */


public interface UserDataSource {

    interface GetUserCallback {
        void onUserFound(UserObject user);
        void onDataNotAvailable();
    }

    UserObject getUserWithEmail(@NonNull String email); //sync
    void getUserWithEmail(@NonNull String email, @NonNull GetUserCallback callback); //async
    void createUser(@NonNull UserObject user);
    void updateUserDetails(@NonNull String email, @NonNull String pass);
}