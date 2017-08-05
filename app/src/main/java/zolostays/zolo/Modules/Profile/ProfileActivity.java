package zolostays.zolo.Modules.Profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.BaseActivity;
import zolostays.zolo.Data.Repo.UserObject;
import zolostays.zolo.Modules.Login.LoginActivity;
import zolostays.zolo.Modules.Registration.DaggerRegistrationActivityComponent;
import zolostays.zolo.Modules.Registration.RegistrationActivity;
import zolostays.zolo.Modules.Registration.RegistrationModule;
import zolostays.zolo.Modules.Registration.RegistrationPresenter;
import zolostays.zolo.R;
import zolostays.zolo.R2;


public class ProfileActivity  extends BaseActivity implements ProfileContract.View{

    @Inject ProfilePresenter mProfilePresenter;

    @BindView(R2.id.et_phone) EditText etPhone;
    @BindView(R2.id.et_name) EditText etName;
    @BindView(R2.id.et_email) EditText etEmail;
    @BindView(R2.id.layout_update) View layoutUpdate;
    @BindView(R2.id.layout_logout) View layoutLogout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ((TextView)layoutUpdate.findViewById(R.id.text)).setText("Update");
        ((TextView)layoutLogout.findViewById(R.id.text)).setText("Logout");
        hideUpdateButton();
        inflateUsingCurrentUser();
    }


    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerProfileActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .profileModule(new ProfileModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void hideUpdateButton() {
        layoutUpdate.setVisibility(View.GONE);
    }

    @Override
    public void showUpdateButton() {
        layoutUpdate.setVisibility(View.VISIBLE);
    }

    public void inflateUsingCurrentUser() {
        UserObject user = mProfilePresenter.getCurrentUser();
        etEmail.setText(user.getEmail());
        etName.setText(user.getName());
        etPhone.setText(user.getPhone());
    }


    @OnClick(R.id.layout_update)
    public void updateClicked(View view){
        hideUpdateButton();
        mProfilePresenter.updateUserInfo(
                new UserObject()
                .setPhone(etPhone.getText().toString())
                .setEmail(etEmail.getText().toString())
                .setName(etName.getText().toString())
        );
    }

    @OnClick(R.id.layout_logout)
    public void logoutClicked(View view){
        mProfilePresenter.logOut();
        openLoginPage();
    }


    @Override
    public void openLoginPage() {
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }


    @Override
    public void clearErrors() {
        etEmail.setError(null);
        etName.setError(null);
        etPhone.setError(null);
    }
}




