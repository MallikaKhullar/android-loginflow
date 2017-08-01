package zolostays.zolo.Modules.PasswordReset;

import dagger.Component;
import zolostays.zolo.AppComponent;
import zolostays.zolo.Modules.Login.LoginActivity;
import zolostays.zolo.Modules.Login.LoginModule;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ForgotPassModule.class)
public interface ForgotPassComponent {
    void inject(ForgotPasswordActivity activity);
}
