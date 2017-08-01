package zolostays.zolo.Modules.Profile;

import dagger.Component;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ProfileModule.class)
public interface ProfileActivityComponent {
    void inject(ProfileActivity activity);
}
