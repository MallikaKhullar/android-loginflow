package zolostays.zolo;


import android.app.Activity;
import android.os.Bundle;

import zolostays.zolo.App;
import zolostays.zolo.AppComponent;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public abstract class BaseActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.get(this).getApplicationComponent());
    }

    protected abstract void setupComponent(AppComponent appComponent);
}

