package zolostays.zolo;
import dagger.Module;
import dagger.Provides;


/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }


}
