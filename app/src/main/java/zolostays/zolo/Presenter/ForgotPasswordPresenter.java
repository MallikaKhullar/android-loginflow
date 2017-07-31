package zolostays.zolo.Presenter;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface ForgotPasswordPresenter {

    void resetClicked(String phone); //triggers the OTP

    void phoneModified();
}
