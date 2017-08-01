package zolostays.zolo.Modules.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import zolostays.zolo.ApplicationComponent;
import zolostays.zolo.BaseActivity;
import zolostays.zolo.Modules.Profile.ProfileActivity;
import zolostays.zolo.R;
import zolostays.zolo.R2;

import static dagger.internal.Preconditions.checkNotNull;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject LoginPresenter mPresenter;

    /*--------Views-------*/
    @BindView(R2.id.et_email) private EditText etEmail;
    @BindView(R2.id.et_password) private EditText etPass;
    @BindView(R2.id.tv_forgot) private TextView tvForgot;
    @BindView(R2.id.layout_register) private View layoutRegister;
    @BindView(R2.id.layout_login) private View layoutLogin;
    private Snackbar bar;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((TextView)layoutRegister.findViewById(R.id.text)).setText("Create Account");
        ((TextView)layoutLogin.findViewById(R.id.text)).setText("Log In");
    }

    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerLoginActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .loginModule(new LoginModule(LoginActivity.this, this))
                .build()
                .inject(this);
    }


    /*--------Events-------*/
    @OnClick(R.id.layout_register)
    public void registerClicked(View view){
        mPresenter.createAccountClicked();
    }

    @OnClick(R.id.layout_login)
    public void loginClicked(View view){
        mPresenter.loginClicked(etEmail.getText().toString(), etPass.getText().toString());
    }

    @OnClick(R.id.layout_login)
    public void forgotPassClicked(View view){
        mPresenter.forgotPasswordClicked();
    }

    @OnTextChanged(value = R.id.et_email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterEmailInput(Editable editable) {
        etEmail.setError(null);
        mPresenter.inputModified(etEmail.getText().toString(), etPass.getText().toString());
    }

    @OnTextChanged(value = R.id.et_password, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput(Editable editable) {
        etPass.setError(null);
        mPresenter.inputModified(etEmail.getText().toString(), etPass.getText().toString());
    }


    /*--------UI changes-------*/
    @Override
    public void showErrorOnEmail() {
        etEmail.setError("Please enter valid email");
    }

    @Override
    public void showErrorOnPassword() {
        etPass.setError("Please enter password");
    }

    @Override
    public void clearErrors() {
        etEmail.setError(null);
        etPass.setError(null);
    }

    @Override
    public void showSnackbarError() {
        bar = Snackbar.make(layoutLogin, "Error: Invalid credentials!", Snackbar.LENGTH_LONG);
        bar.show();
    }

    @Override
    public void hideSnackbar() {
        if(bar!=null) bar.dismiss();
    }



    /*--------Dialogs-------*/
    @Override
    public void dismissDialog() {
        if(mDialog!=null && mDialog.isShowing() && !LoginActivity.this.isFinishing()) mDialog.dismiss();
    }

    @Override
    public void showDialog() {
        if(!LoginActivity.this.isFinishing()) mDialog = ProgressDialog.show(this, "Logging in ..", null);
    }



    /*--------Flow-------*/
    @Override
    public void openRegistrationPage() {
        Intent i = new Intent(this, zolostays.zolo.Modules.Registration.RegistrationActivity.class);
        startActivity(i);
    }

    @Override
    public void openForgotPassPage() {
        Intent i = new Intent(this, zolostays.zolo.Modules.PasswordReset.ForgotPasswordActivity.class);
        i.putExtra("email", etEmail.getText().toString());
        startActivity(i);
    }

    @Override
    public void openProfilePage() {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}
