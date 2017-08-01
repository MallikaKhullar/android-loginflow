package zolostays.zolo.Modules.Login;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Utils.ActivityScope;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */

@Module
public class LoginModule {
    private final Context mContext;
    private final LoginContract.View mView;
    public LoginModule(Context context, LoginContract.View view) {
        mContext = context;
        mView = view;
    }

    @Provides LoginContract.View provideView() {
        return mView;
    }

    @ActivityScope @Provides LoginPresenter providePresenter(SharedPreferences sprefs, UserRepo repo, LoginContract.View view) {
        return new LoginPresenter(repo, sprefs, view);
    }
}