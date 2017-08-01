package zolostays.zolo.Presenter;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface IRegistrationPresenter {

    void inputModified(String phone, String email, String name, String pass);

    void registerClicked(String phone, String email, String name, String pass);

    void loginClicked();
}

