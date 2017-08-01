package zolostays.zolo;

import android.app.Application;


/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class ZoloLoginMainApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
