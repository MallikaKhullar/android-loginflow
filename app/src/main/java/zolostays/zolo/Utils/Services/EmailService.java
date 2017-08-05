package zolostays.zolo.Utils.Services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import javax.inject.Inject;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import zolostays.zolo.Data.Repo.Mail;
import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

public class EmailService {

    Context mContext;

    @Inject EmailService(Context context) {
        mContext = context;
    }

    class SendEmailAsyncTask extends AsyncTask<String, Object, Boolean> {
        Mail m = new Mail();
        private OnProcessFinishedCallback listener;

        public SendEmailAsyncTask(OnProcessFinishedCallback listener){
            this.listener=listener;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String[] to = {params[0]};
            m.set_to(to);
            m.setBody(String.format("Your new password is %s", params[1]));
            try {
                if (m.send()) {
                    listener.onSuccess();
                    return true;
                }

            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                listener.onError();
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                listener.onError();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                listener.onError();
                return false;
            }
            return false;
        }
    }


    public void sendEmail(final String email, String randPassword, final OnProcessFinishedCallback callback) {
        SendEmailAsyncTask emailAsyncTask = new SendEmailAsyncTask(callback);
        emailAsyncTask.execute(email, randPassword);
    }
}
