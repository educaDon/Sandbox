package net.kvedalen.sandbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginScreenActivity extends AppCompatActivity {

    public void logIn(View view){
        EditText user = (EditText) findViewById(R.id.userId);
        EditText pass = (EditText) findViewById(R.id.passwdId);

        Log.i("Loging in:", user.getText().toString() + " with passwd: " + pass.getText().toString() + "(Yeah right)");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login_screen);
    }

}
