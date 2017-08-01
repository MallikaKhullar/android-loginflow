package zolostays.zolo.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import zolostays.zolo.Presenter.LoginPresenter;
import zolostays.zolo.R;
import zolostays.zolo.R2;
import zolostays.zolo.View.ILoginView;

public class LoginActivity extends Activity implements ILoginView {

    @BindView(R2.id.et_email) EditText etEmail;
    @BindView(R2.id.et_password) EditText etPass;
    @BindView(R2.id.tv_forgot) TextView tvForgot;
    @BindView(R2.id.layout_register) View layoutRegister;
    @BindView(R2.id.layout_login) View layoutLogin;
    Snackbar bar;
    private ProgressDialog progressDialog;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.layout_register) public void registerClicked(View view){
        presenter.createAccountClicked();
    }

    @OnClick(R.id.layout_login) public void loginClicked(View view){
//        progressDialog = ProgressDialog.show(this, "Authenticating...", null);
        presenter.loginClicked(etEmail.getText().toString(), etPass.getText().toString());
    }

    @OnClick(R.id.layout_login) public void forgotPassClicked(View view){
        presenter.forgotPasswordClicked();
    }

    @OnTextChanged(value = R.id.et_email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterEmailInput(Editable editable) {
        etEmail.setError(null);
        presenter.inputModified(etEmail.getText().toString(), etPass.getText().toString());
    }

    @OnTextChanged(value = R.id.et_password, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput(Editable editable) {
        etPass.setError(null);
        presenter.inputModified(etEmail.getText().toString(), etPass.getText().toString());
    }

    @Override
    public void openRegistrationPage() {
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }

    @Override
    public void openForgotPassPage() {
        Intent i = new Intent(this, ForgotPasswordActivity.class);
        i.putExtra("email", etEmail.getText().toString());
        startActivity(i);
    }

    @Override
    public void openProfilePage() {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
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

    @Override
    public void showErrorOnEmail() {
        etEmail.setError("Please enter valid email");
    }

    @Override
    public void showErrorOnPassword() {
        etPass.setError("Please enter password");
    }

    @Override
    public void dismissDialog() {
        if(progressDialog!=null && progressDialog.isShowing() && !LoginActivity.this.isFinishing()) progressDialog.dismiss();

    }

    @Override
    public void showDialog() {
        if(!LoginActivity.this.isFinishing()) progressDialog = ProgressDialog.show(this, "Logging in ..", null);
    }
}
