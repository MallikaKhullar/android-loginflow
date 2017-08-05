package zolostays.zolo.Modules.Profile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
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
    @BindView(R2.id.ll_container) View llContainer;


    @OnTextChanged(value = R.id.et_name, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterNameInput(Editable editable) {
        etName.setError(null);
        showUpdateButton();
        mProfilePresenter.inputModified(etName.getText().toString(), etPhone.getText().toString());
    }
    @OnTextChanged(value = R.id.et_phone, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPhoneInput(Editable editable) {
        etPhone.setError(null);
        showUpdateButton();
        mProfilePresenter.inputModified(etName.getText().toString(), etPhone.getText().toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ((TextView)layoutUpdate.findViewById(R.id.text)).setText("Update");
        ((TextView)layoutLogout.findViewById(R.id.text)).setText("Logout");
        inflateUsingCurrentUser();
        hideUpdateButton();
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
        etName.clearFocus();
        etPhone.clearFocus();
        etEmail.clearFocus();
        llContainer.requestFocus();
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
    public void showErrorOnName() {
        etName.setError("Please enter valid name");
    }

    @Override
    public void showErrorOnPhone() {
        etPhone.setError("Please enter valid phone");
    }


    @Override
    public void clearErrors() {
        etEmail.setError(null);
        etName.setError(null);
        etPhone.setError(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etPhone.getWindowToken(), 0);
    }
}




