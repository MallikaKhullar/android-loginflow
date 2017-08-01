package zolostays.zolo.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import zolostays.zolo.Presenter.ForgotPasswordPresenter;
import zolostays.zolo.R;
import zolostays.zolo.R2;
import zolostays.zolo.View.IForgotPasswordView;


public class ForgotPasswordActivity extends Activity implements IForgotPasswordView {

    @BindView(R2.id.et_email) EditText etEmail;
    private Dialog progressDialog;

    ForgotPasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        presenter = new ForgotPasswordPresenter(this);
    }

    @OnClick(R.id.layout_reset) public void resetClicked(View view){
        presenter.loginClicked();
    }


    @OnTextChanged(value = R.id.et_email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput(Editable editable) {
        etEmail.setError(null);
        presenter.inputModified(etEmail.getText().toString());
    }


    @Override
    public void showErrorOnEmail() {
        etEmail.setError("Please enter a valid email ID");
    }


    @Override
    public void openLoginPage() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void dismissDialog() {
        if(progressDialog!=null && progressDialog.isShowing() && !ForgotPasswordActivity.this.isFinishing()) progressDialog.dismiss();

    }

    @Override
    public void showDialog() {
        if(!ForgotPasswordActivity.this.isFinishing()) progressDialog = ProgressDialog.show(this, "Sending you your new password ..", null);
    }
}
