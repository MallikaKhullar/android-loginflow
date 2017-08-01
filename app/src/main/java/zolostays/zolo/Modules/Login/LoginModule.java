package zolostays.zolo.Modules.Login;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Modules.Profile.ProfileContract;
import zolostays.zolo.Modules.Profile.ProfilePresenter;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@Module
public class LoginModule {

    private final LoginContract.View mView;

    public LoginModule(LoginContract.View view) {
        mView = view;
    }

    @Provides LoginContract.View getView() {
        return mView;
    }

    @Provides public LoginPresenter providePresenter(LoginContract.View view) {
        return new LoginPresenter(view);
    }
}