package zolostays.zolo.Modules.Profile;

import android.os.Bundle;

import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.BaseActivity;
import zolostays.zolo.Modules.Registration.RegistrationModule;
import zolostays.zolo.R;


public class ProfileActivity  extends BaseActivity implements ProfileContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }


    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerProfileActivityComponent.builder()
                .appComponent(applicationComponent)
                .profileModule(new ProfileModule(this))
                .build()
                .inject(this);
    }

}
