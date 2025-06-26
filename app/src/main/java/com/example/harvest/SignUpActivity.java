package com.example.harvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText editTextFirstName, editTextLastName, editTextEmail, 
                             editTextPassword, editTextConfirmPassword;
    private Button buttonSignUp, buttonGoogleSignUp;
    private TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
        setClickListeners();
    }

    private void initViews() {
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonGoogleSignUp = findViewById(R.id.buttonGoogleSignUp);
        textViewSignIn = findViewById(R.id.textViewSignIn);
    }

    private void setClickListeners() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSignUp();
            }
        });

        buttonGoogleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performGoogleSignUp();
            }
        });

        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to login
            }
        });
    }

    private void performSignUp() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (firstName.isEmpty()) {
            editTextFirstName.setError("First name is required");
            return;
        }

        if (lastName.isEmpty()) {
            editTextLastName.setError("Last name is required");
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            return;
        }

        if (!password.equals(confirmPassword)) {
            editTextConfirmPassword.setError("Passwords do not match");
            return;
        }

        // TODO: Implement actual sign-up logic here
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();
        
        // Navigate back to login
        finish();
    }

    private void performGoogleSignUp() {
        // TODO: Implement Google Sign-Up
        Toast.makeText(this, "Google Sign-Up clicked", Toast.LENGTH_SHORT).show();
    }
}