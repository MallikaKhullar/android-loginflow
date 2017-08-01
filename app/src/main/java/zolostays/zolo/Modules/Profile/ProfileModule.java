package zolostays.zolo.Modules.Profile;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Modules.Registration.RegistrationContract;
import zolostays.zolo.Modules.Registration.RegistrationPresenter;

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

    @Provides
    public ProfilePresenter providePresenter(ProfileContract.View view) {
        return new ProfilePresenter(view);
    }
}