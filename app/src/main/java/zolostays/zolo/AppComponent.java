package zolostays.zolo;

import dagger.Component;
import zolostays.zolo.Modules.Login.LoginModule;
import zolostays.zolo.Modules.Login.LoginPresenter;
import zolostays.zolo.Modules.PasswordReset.ForgotPassModule;
import zolostays.zolo.Modules.PasswordReset.ForgotPasswordActivity;
import zolostays.zolo.Modules.Login.LoginActivity;
import zolostays.zolo.Modules.Profile.ProfileActivity;
import zolostays.zolo.Modules.Profile.ProfileModule;
import zolostays.zolo.Modules.Profile.ProfilePresenter;
import zolostays.zolo.Modules.Registration.RegistrationActivity;
import zolostays.zolo.Data.PersistenceModule;
import zolostays.zolo.Modules.PasswordReset.ForgotPasswordPresenter;
import zolostays.zolo.Modules.Registration.RegistrationModule;
import zolostays.zolo.Modules.Registration.RegistrationPresenter;


import javax.inject.Singleton;
/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Singleton
@Component(modules = {AppModule.class, PersistenceModule.class})

public interface AppComponent {
    void inject(App app);
}
