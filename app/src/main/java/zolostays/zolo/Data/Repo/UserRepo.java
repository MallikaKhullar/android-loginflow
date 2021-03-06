package zolostays.zolo.Data.Repo;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import zolostays.zolo.Utils.Local;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

@Singleton
public class UserRepo implements UserDataSource {

    private final UserDataSource musersLocalDataSource;

    @Inject
    UserRepo(@Local UserDataSource usersLocalDataSource) {
        musersLocalDataSource = usersLocalDataSource;
    }

    @Override
    public long createUser(@NonNull UserObject user) {
        checkNotNull(user);
        return musersLocalDataSource.createUser(user);
    }

    @Override
    public void updateUserDetails(@NonNull String email, String newPassword) {
        checkNotNull(email);
        checkNotNull(newPassword);
        musersLocalDataSource.updateUserDetails(email, newPassword);
    }

    @Override
    public void updateUserDetails(@NonNull Long id, @NonNull String email, @NonNull String name, @NonNull String phone) {
        checkNotNull(id);
        checkNotNull(email);
        checkNotNull(name);
        checkNotNull(phone);
        musersLocalDataSource.updateUserDetails(id, email, name, phone);
    }

    @Override
    public UserObject getUserWithEmail(@NonNull String email) { //sync
        checkNotNull(email);
        return musersLocalDataSource.getUserWithEmail(email);
    }

    @Override
    public void getUserWithEmail(@NonNull String email, final GetUserCallback callback) { //async
        checkNotNull(email);
        checkNotNull(callback);

        musersLocalDataSource.getUserWithEmail(email, new GetUserCallback() {
            @Override public void onUserFound(UserObject user) {callback.onUserFound(user);}
            @Override public void onDataNotAvailable() {callback.onDataNotAvailable();}
        });
    }
}
