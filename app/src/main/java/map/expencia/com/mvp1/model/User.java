package map.expencia.com.mvp1.model;

import android.text.TextUtils;
import android.util.Patterns;


public class User implements IUser {

  private   String emailId,password;

    public User(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public String getEmilId() {
        return emailId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidation() {

        if (!TextUtils.isEmpty(getEmilId())) {
            return 0;
        } else if (Patterns.EMAIL_ADDRESS.matcher(getEmilId()).matches()) {
            return 1;
        } else if (getPassword().length() <= 6) {
            return 2;
        }
        else
        {
            return -1;
        }
    }
}
