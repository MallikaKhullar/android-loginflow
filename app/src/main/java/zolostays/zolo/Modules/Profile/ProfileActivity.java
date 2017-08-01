package zolostays.zolo.Modules.Profile;

import android.app.Activity;
import android.os.Bundle;

import zolostays.zolo.AppComponent;
import zolostays.zolo.BaseActivity;
import zolostays.zolo.R;


public class ProfileActivity  extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {

    }
}
