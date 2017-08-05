package zolostays.zolo.Utils.Services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import javax.inject.Inject;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import zolostays.zolo.Data.Repo.Mail;
import zolostays.zolo.Utils.OnProcessFinishedErrorMsgCallback;
import zolostays.zolo.Utils.Services.GmailSender.GmailSender;

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
            try {
                GmailSender sender = new GmailSender("zolozolotrial@gmail.com", "12345zolo");
                sender.sendMail("Password Updated",
                        "Your password is now " + params[1],
                        "zolozolotrial@gmail.com",
                        params[0]);
                listener.onSuccess();
                return true;
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
                return false;
            }
        }
    }


    public void sendEmail(final String email, String randPassword, final OnProcessFinishedErrorMsgCallback callback) {
        SendEmailAsyncTask emailAsyncTask = new SendEmailAsyncTask(callback);
        emailAsyncTask.execute(email, randPassword);
    }
}
