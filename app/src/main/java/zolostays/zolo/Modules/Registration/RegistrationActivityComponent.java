package zolostays.zolo.Modules.Registration;

import dagger.Component;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = RegistrationModule.class)
public interface RegistrationActivityComponent {
    void inject(RegistrationActivity activity);
}
