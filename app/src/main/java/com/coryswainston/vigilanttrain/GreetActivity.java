package com.coryswainston.vigilanttrain;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;

public class GreetActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText emailInput;
    private EditText schoolInput;
    private EditText craftInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        String userName = getIntent().getStringExtra("userName");
        String email = getIntent().getStringExtra("email");
        String profilePic = "not working dangit"; //Uri.parse(getIntent().getStringExtra("profilePic"));

        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        schoolInput = findViewById(R.id.school_input);
        craftInput = findViewById(R.id.craft_input);

        nameInput.setText(userName);
        emailInput.setText(email);
    }

    public void onSubmit(View v) {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String school = schoolInput.getText().toString();
        String craft = craftInput.getText().toString();

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference newUser = db.push();
        newUser.child("name").setValue(name);
        newUser.child("email").setValue(email);
        newUser.child("school").setValue(school);
        newUser.child("craft").setValue(craft);
    }

    public void logOut(View v) {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}
