package zolostays.zolo;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Component;
import zolostays.zolo.Data.Repo.RepoModule;
import zolostays.zolo.Data.Repo.UserRepo;

import javax.inject.Singleton;
/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Singleton
@Component(modules = {RepoModule.class, ApplicationModule.class})

public interface ApplicationComponent {
    UserRepo getUserRepo();
    SharedPreferences sharedPreferences();
    Context context();
}
