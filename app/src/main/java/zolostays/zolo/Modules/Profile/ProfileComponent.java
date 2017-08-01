package zolostays.zolo.Modules.Profile;

import dagger.Component;
import zolostays.zolo.AppComponent;
import zolostays.zolo.Modules.PasswordReset.ForgotPassModule;
import zolostays.zolo.Modules.PasswordReset.ForgotPasswordActivity;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ProfileModule.class)
public interface ProfileComponent {
    void inject(ProfileActivity activity);
}
