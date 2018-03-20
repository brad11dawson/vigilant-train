package com.coryswainston.vigilanttrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class GreetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        String userName = getIntent().getStringExtra("userName");
        TextView tv = findViewById(R.id.textView2);
        tv.setText("Hello, " + userName);
    }

    public void logOut(View v) {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}
