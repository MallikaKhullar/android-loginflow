package zolostays.zolo.Presenter;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface IForgotPasswordPresenter {

    void resetClicked(String email); //triggers the OTP

    void inputModified(String email);

    void loginClicked();
}
