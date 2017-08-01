package zolostays.zolo.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import zolostays.zolo.Presenter.RegistrationPresenter;
import zolostays.zolo.R;
import zolostays.zolo.R2;
import zolostays.zolo.View.IRegistrationView;


public class RegistrationActivity extends Activity implements IRegistrationView {

    @BindView(R2.id.et_phone) EditText etPhone;
    @BindView(R2.id.et_password) EditText etPass;
    @BindView(R2.id.et_name) EditText etName;
    @BindView(R2.id.et_email) EditText etEmail;
    @BindView(R2.id.tv_login) TextView tvLogin;
    private ProgressDialog progressDialog;

    RegistrationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @OnClick(R.id.layout_register)
    public void registerClicked(View view){
        presenter.registerClicked(etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etName.getText().toString(),
                        etName.getText().toString());
    }

    @OnClick(R.id.tv_login) public void loginClicked(View view){
        presenter.loginClicked();
    }


    @OnTextChanged(value = {R.id.et_name, R.id.et_email, R.id.et_phone, R.id.et_password}, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput(EditText editText, Editable editable) {
        editText.setError(null);
        presenter.inputModified(etPhone.getText().toString(),
                etEmail.getText().toString(),
                etName.getText().toString(),
                etName.getText().toString());
    }


    @Override
    public void openLoginPage() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showErrorOnPhone() {
        etPhone.setError("Please enter a valid 10 digit phone number");
    }

    @Override
    public void showErrorOnPassword() {
        etPass.setError("Password should be between 6-10 chars long, atleast 1 number, atleast 1 uppercase, atleast 1 lowercase");
    }

    @Override
    public void showErrorOnName() {
        etName.setError("Please enter a longer name");
    }

    @Override
    public void dismissDialog() {
        if(progressDialog!=null && progressDialog.isShowing() && !RegistrationActivity.this.isFinishing()) progressDialog.dismiss();

    }

    @Override
    public void showDialog() {
        if(!RegistrationActivity.this.isFinishing()) progressDialog = ProgressDialog.show(this, "Registering user ...", null);
    }

    @Override
    public void showErrorOnEmail() {
        etEmail.setError("Please enter a valid email");
    }
}



