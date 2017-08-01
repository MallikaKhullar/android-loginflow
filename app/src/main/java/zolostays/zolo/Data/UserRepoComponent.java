package zolostays.zolo.Data;

import javax.inject.Singleton;

import dagger.Component;
import zolostays.zolo.ApplicationModule;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

@Singleton
@Component(modules = {RepoModule.class, ApplicationModule.class})
public interface UserRepoComponent {

    UserRepo getRepo();
}
