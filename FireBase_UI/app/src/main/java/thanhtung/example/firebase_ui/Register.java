package thanhtung.example.firebase_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private TextView banner, registerUser;
    private EditText etFullName, etAge, etEmail, etPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        etFullName = (EditText) findViewById(R.id.fullName);
        etAge = (EditText) findViewById(R.id.age);
        etEmail = (EditText) findViewById(R.id.email);
        etPassword =(EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.register:
                registerUser();
                break;

        }
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String age = etAge.getText().toString().trim();

        if (fullName.isEmpty()){
            etFullName.setError("Full name is required!");
            etFullName.requestFocus();
            return;
        }

        if (age.isEmpty()){
            etAge.setError("Age is required!");
            etAge.requestFocus();
            return;
        }

        if (email.isEmpty()){
            etEmail.setError("Email is required!");
            etEmail.requestFocus();
            return;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please provide valid email!");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            etPassword.setError("Password is required!");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6 ){
            etPassword.setError("Min password length should be 6 charactersl");
            etPassword.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCanceledListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task){

                }
        })
    }
}