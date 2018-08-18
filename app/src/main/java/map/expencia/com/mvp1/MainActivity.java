package map.expencia.com.mvp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import map.expencia.com.mvp1.presenter.ILoginPresenter;
import map.expencia.com.mvp1.presenter.LoginPresenter;
import map.expencia.com.mvp1.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {

    private EditText email,password;
    private Button btn;
    TextView result;

    ILoginPresenter iLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        result = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

        iLoginPresenter =new LoginPresenter(this);

    }

    @Override
    public void LoginSuccess(String message) {
        result.setText(message);
        Toasty.success(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void LoginError(String error) {
        result.setText(error);
        Toasty.error(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

          iLoginPresenter.onLogin(email.getText().toString(),password.getText().toString());
    }
}
