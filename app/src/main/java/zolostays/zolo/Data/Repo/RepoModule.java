package zolostays.zolo.Data.Repo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Utils.Local;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

@Module
public class RepoModule {

    @Singleton
    @Provides
    @Local
    UserDataSource provideUsersLocalDataSource(Context context) {
        return new UserLocalDataSource(context);
    }
}

