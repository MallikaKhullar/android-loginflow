package zolostays.zolo.Modules.Login;

import dagger.Component;
import zolostays.zolo.AppComponent;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}

