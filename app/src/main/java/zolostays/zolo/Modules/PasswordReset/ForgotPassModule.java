package zolostays.zolo.Modules.PasswordReset;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import zolostays.zolo.Data.Repo.UserRepo;
import zolostays.zolo.Modules.Login.LoginContract;
import zolostays.zolo.Modules.Login.LoginPresenter;
import zolostays.zolo.Modules.Profile.ProfileContract;
import zolostays.zolo.Modules.Profile.ProfilePresenter;
import zolostays.zolo.Utils.ActivityScope;
import zolostays.zolo.Utils.Services.EmailService;

/**
 * Created by mallikapriyakhullar on 01/08/17.
 */


@Module
public class ForgotPassModule {

    private final Context mContext;
    private final ForgotPassContract.View mView;

    public ForgotPassModule(Context context, ForgotPassContract.View view) {
        mContext = context;
        mView = view;
    }

    @Provides ForgotPassContract.View provideView() {
        return mView;
    }

    @ActivityScope @Provides public Context context() {
        return mContext;
    }

    @Provides @ActivityScope public ForgotPasswordPresenter providePresenter(EmailService emailService, UserRepo repo, ForgotPassContract.View view) {
        return new ForgotPasswordPresenter(emailService, repo, view);
    }
}