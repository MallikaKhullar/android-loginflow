package zolostays.zolo.Modules.PasswordReset;

import android.content.Context;

import dagger.Component;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ForgotPassModule.class)
public interface ForgotPassActivityComponent {
    void inject(ForgotPasswordActivity activity);
}
