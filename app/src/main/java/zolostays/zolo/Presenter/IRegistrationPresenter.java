package zolostays.zolo.Presenter;

/**
 * Created by mallikapriyakhullar on 31/07/17.
 */

public interface IRegistrationPresenter {

    void phoneModified();

    void emailModified();

    void nameModified();

    void passwordModified();

    void registerClicked(String phone, String email, String name, String pass);
}

