package zolostays.zolo.Modules.Registration;

import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Modules.Login.LoginPresenter;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@Module
public class RegistrationModule {

    private final RegistrationContract.View mView;

    public RegistrationModule(RegistrationContract.View view) {
        mView = view;
    }

    @Provides
    RegistrationContract.View provideView() {
        return mView;
    }

    @ActivityScope
    @Provides
    RegistrationPresenter providePresenter(SharedPreferences sprefs, UserRepo repo, RegistrationContract.View view) {
        return new RegistrationPresenter(repo, sprefs, view);
    }
}