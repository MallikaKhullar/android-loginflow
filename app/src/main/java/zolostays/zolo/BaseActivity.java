package zolostays.zolo;


import android.app.Activity;
import android.os.Bundle;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public abstract class BaseActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(ZoloLoginMainApplication.get(this).getApplicationComponent());
    }

    protected abstract void setupComponent(ApplicationComponent applicationComponent);
}

