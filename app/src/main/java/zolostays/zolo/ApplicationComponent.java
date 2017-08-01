package zolostays.zolo;

import dagger.Component;
import zolostays.zolo.Data.RepoModule;
import zolostays.zolo.Data.UserRepo;


import javax.inject.Singleton;
/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Singleton
@Component(modules = {RepoModule.class, ApplicationModule.class})

public interface ApplicationComponent {
    UserRepo getUserRepo();
}
