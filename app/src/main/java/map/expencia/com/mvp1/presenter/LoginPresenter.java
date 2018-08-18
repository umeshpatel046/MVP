package map.expencia.com.mvp1.presenter;

import map.expencia.com.mvp1.model.User;
import map.expencia.com.mvp1.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {


   private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String emailId, String password) {

        User user = new User(emailId,password);
        int isLoginSuccessfull = user.isValidation();

        if(isLoginSuccessfull==0)
        {
            loginView.LoginError("You have enter email Id");
        }
        else if(isLoginSuccessfull == 1)
        {
            loginView.LoginError("You have enter valid email Id");
        }
        else if(isLoginSuccessfull == 2)
        {
            loginView.LoginError("Password must have enter grater then 6 digit");
        }
        else
        {
           loginView.LoginSuccess("Login Success");
        }

    }
}
