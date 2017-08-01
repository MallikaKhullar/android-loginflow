package zolostays.zolo.Modules.Registration;

import dagger.Module;
import dagger.Provides;

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

    @Provides
    public RegistrationPresenter providePresenter(RegistrationContract.View view) {
        return new RegistrationPresenter(view);
    }
}