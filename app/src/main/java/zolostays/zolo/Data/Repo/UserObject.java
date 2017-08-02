package zolostays.zolo.Data.Repo;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class UserObject {
    String name;
    String email;
    String phone;
    String pass;
    Long id;

    public UserObject() {
    }

    public UserObject(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public UserObject(String phone, String email, String name, String pass) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
