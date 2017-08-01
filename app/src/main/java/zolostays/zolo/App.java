package zolostays.zolo;

import android.app.Application;
import android.content.Context;


/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getApplicationComponent() {
        return this.appComponent;
    }

}
