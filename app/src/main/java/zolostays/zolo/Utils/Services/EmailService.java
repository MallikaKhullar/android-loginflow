package zolostays.zolo.Utils.Services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import javax.inject.Inject;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import zolostays.zolo.Data.Repo.Mail;
import zolostays.zolo.Utils.OnProcessFinishedCallback;
import zolostays.zolo.Utils.OnProcessFinishedErrorMsgCallback;

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
        private OnProcessFinishedErrorMsgCallback listener;

        public SendEmailAsyncTask(OnProcessFinishedErrorMsgCallback listener){
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
                } else {
                    return false;
                }

            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                listener.onError("Password reset to: " + params[1] + " but unable to send email");
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                listener.onError("Password reset to: " + params[1] + " but unable to send email");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                listener.onError("Password reset to: " + params[1] + " but unable to send email");
                return false;
            }
        }
    }


    public void sendEmail(final String email, String randPassword, final OnProcessFinishedErrorMsgCallback callback) {
        SendEmailAsyncTask emailAsyncTask = new SendEmailAsyncTask(callback);
        emailAsyncTask.execute(email, randPassword);
    }
}
