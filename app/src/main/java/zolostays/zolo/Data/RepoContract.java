package zolostays.zolo.Data;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

public interface RepoContract {
    public interface Repository {
        UserObject getUserByEmail(String email);
        UserObject getUserByPhone(String email);
    }
}
