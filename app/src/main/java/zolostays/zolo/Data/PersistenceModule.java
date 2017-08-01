package zolostays.zolo.Data;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@Module
public class PersistenceModule {
    @Provides
    public RepoContract.Repository getUserRepo(Context context){
        return new SQLRepo();
    }

}
