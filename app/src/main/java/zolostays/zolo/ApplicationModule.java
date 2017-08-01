package zolostays.zolo;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Module
public class ApplicationModule {
    private final Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides Context provideContext() {
        return mContext;
    }

    @Provides SharedPreferences provideSharedPrefs() {
        return mContext.getSharedPreferences("login-prefs", Context.MODE_PRIVATE);
    }


}
