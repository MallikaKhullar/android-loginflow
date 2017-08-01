package zolostays.zolo.Modules.PasswordReset;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Modules.Profile.ProfileModule;
import zolostays.zolo.R;
import zolostays.zolo.R2;

import static dagger.internal.Preconditions.checkNotNull;


public class ForgotPasswordActivity extends BaseActivity implements ForgotPassContract.View {

    @Inject ForgotPassContract.Presenter mPresenter;

    /*--------Views-------*/
    @BindView(R2.id.et_email) EditText etEmail;
    @BindView(R2.id.layout_reset) private View layoutReset;
    private Dialog progressDialog;
    private Snackbar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        ((TextView)layoutReset.findViewById(R.id.text)).setText("Reset Password");

    }

    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerForgotPassActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .forgotPassModule(new ForgotPassModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(ForgotPassContract.Presenter mPresenter) {
        this.mPresenter = checkNotNull(mPresenter);
    }



    /*--------Events-------*/
    @OnClick(R.id.layout_reset) public void resetClicked(View view){
        mPresenter.loginClicked();
    }

    @OnTextChanged(value = R.id.et_email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordInput(Editable editable) {
        etEmail.setError(null);
        mPresenter.inputModified(etEmail.getText().toString());
    }



    /*--------Dialogs-------*/
    @Override
    public void dismissDialog() {
        if(progressDialog!=null && progressDialog.isShowing() && !ForgotPasswordActivity.this.isFinishing()) progressDialog.dismiss();
    }

    @Override
    public void showDialog() {
        if(!ForgotPasswordActivity.this.isFinishing()) progressDialog = ProgressDialog.show(this, "Sending you your new password ..", null);
    }



    /*--------UI changes-------*/
    @Override
    public void showErrorOnEmail() {
        etEmail.setError("Please enter a valid email ID");
    }

    @Override
    public void clearErrors() {
        etEmail.setError(null);
    }

    @Override
    public void showSnackbarError() {
        bar = Snackbar.make(layoutReset, "Unable to send email, try again", Snackbar.LENGTH_LONG);
        bar.show();
    }

    @Override
    public void hideSnackbar() {
        if(bar!=null) bar.dismiss();
    }


    /*--------Flow-------*/
    @Override
    public void openLoginPage() {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }
}
