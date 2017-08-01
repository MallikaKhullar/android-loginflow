package zolostays.zolo.Utils.Services;

import android.content.Context;

import java.util.Random;

import javax.inject.Inject;

import rsg.mailchimp.api.MailChimpApiException;
import rsg.mailchimp.api.lists.ListMethods;
import zolostays.zolo.Data.Repo.UserDataSource;
import zolostays.zolo.Utils.Local;
import zolostays.zolo.Utils.OnProcessFinishedCallback;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

public class EmailService {

    Context mContext;

    @Inject EmailService(Context context) {
        mContext = context;
    }

    public void sendEmail(String email, OnProcessFinishedCallback callback) {

        ListMethods listMethods = new ListMethods(mContext);
        String message = "Signup successful!";

        try {
            listMethods.listSubscribe(String.format("Your new password is {}", getRandomPassword()), email);
            callback.onSuccess();
        } catch (MailChimpApiException e) {
            callback.onError();
        }
    }

    class PasswordGenerator {

        private final char[] symbols;
        {
            StringBuilder tmp = new StringBuilder();
            for (char ch = '0'; ch <= '9'; ch++) {
                tmp.append(ch);
            }
            for (char ch = 'a'; ch <= 'z'; ch++) {
                tmp.append(ch);
            }
            symbols = tmp.toString().toCharArray();
        }

        private final Random random = new Random();

        private final char[] buf;

        public PasswordGenerator(int length) {
            if (length < 1) {
                throw new IllegalArgumentException("length < 1: " + length);
            }
            buf = new char[length];
        }

        public String nextString() {
            for (int i = 0; i < buf.length; i++) {
                buf[i] = symbols[random.nextInt(symbols.length)];
            }
            return new String(buf);
        }
    }

    private String getRandomPassword(){
        return new PasswordGenerator(8).nextString();
    }
}
