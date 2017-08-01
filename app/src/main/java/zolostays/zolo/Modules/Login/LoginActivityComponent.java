package zolostays.zolo.Modules.Login;

import android.content.Context;

import dagger.Component;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface LoginActivityComponent {
    void inject(LoginActivity activity);
}

