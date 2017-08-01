package zolostays.zolo.Data;

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
        this.email = name;
        this.pass = pass;
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
