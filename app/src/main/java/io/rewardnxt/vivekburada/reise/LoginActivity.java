package io.rewardnxt.vivekburada.reise;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rewardnxt.vivekburada.reise.db.DBHelper;

public class LoginActivity extends AppCompatActivity  {

    @BindView(R.id.login) Button login;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password) EditText password;

    private Intent I;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        helper  = new DBHelper(this);



    }
    @OnClick(R.id.login)
    public void login(View view) {
        // TODO handle credentials

        I = new Intent(LoginActivity.this,MainActivity.class);
        I.putExtra("user", "student"); //Optional parameters
        LoginActivity.this.startActivity(I);
    }

}
