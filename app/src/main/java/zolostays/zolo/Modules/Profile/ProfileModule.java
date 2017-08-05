package zolostays.zolo.Modules.Profile;

import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Modules.Login.LoginPresenter;
import zolostays.zolo.Modules.Registration.RegistrationContract;
import zolostays.zolo.Modules.Registration.RegistrationPresenter;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */
@Module
public class ProfileModule {

    private final ProfileContract.View mView;

    public ProfileModule(ProfileContract.View view) {
        mView = view;
    }

    @Provides ProfileContract.View getView() {
        return mView;
    }

    @ActivityScope
    @Provides
    ProfilePresenter providePresenter(SharedPreferences sprefs, UserRepo repo, ProfileContract.View view) {
        return new ProfilePresenter(repo, sprefs, view);
    }
}