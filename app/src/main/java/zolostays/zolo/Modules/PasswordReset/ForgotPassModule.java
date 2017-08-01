package zolostays.zolo.Modules.PasswordReset;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Modules.Profile.ProfileContract;
import zolostays.zolo.Modules.Profile.ProfilePresenter;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Module
public class ForgotPassModule {

    private final ForgotPassContract.View mView;

    public ForgotPassModule(ForgotPassContract.View view) {
        mView = view;
    }

    @Provides ForgotPassContract.View getView() {
        return mView;
    }

    @Provides public ForgotPasswordPresenter providePresenter(ForgotPassContract.View view) {
        return new ForgotPasswordPresenter(view);
    }
}