package zolostays.zolo.Modules.Registration;

import dagger.Component;
import zolostays.zolo.AppComponent;
import zolostays.zolo.Modules.Profile.ProfileActivity;
import zolostays.zolo.Modules.Profile.ProfileModule;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = RegistrationModule.class)
public interface RegistrationComponent {
    void inject(RegistrationActivity activity);
}
