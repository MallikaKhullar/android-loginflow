package zolostays.zolo.Data.Repo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public class UserObject {
    String name;
    String email;
    String phone;
    String pass;
    Long id;

    public static String USER_ID = "id";
    public static String USER_NAME = "name";
    public static String USER_EMAIL = "email";
    public static String USER_PHONE = "phone";
    public static String USER_PASS = "pass";


    public UserObject() {
    }

    public UserObject(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public UserObject(String phone, String email, String name, String pass, Long id) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UserObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserObject setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserObject setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public UserObject setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserObject setId(Long id) {
        this.id = id;
        return this;
    }

    public JSONObject getJsonObject() {
        JSONObject user = new JSONObject();
        try {
            user.put(USER_NAME, this.name)
                    .put(USER_EMAIL, this.email)
                    .put(USER_ID, this.id)
                    .put(USER_PHONE, this.phone);
            return user;
        } catch (JSONException e) {
            return null;
        }
    }

    public static UserObject getFromJSON(JSONObject userJson) {
        try {
            UserObject user = new UserObject()
                    .setName(userJson.getString(USER_NAME))
                    .setPhone(userJson.getString(USER_PHONE))
                    .setId(userJson.getLong(USER_ID))
                    .setEmail(userJson.getString(USER_EMAIL));
            return user;
        } catch (JSONException e) {
            return null;
        }
    }
}
