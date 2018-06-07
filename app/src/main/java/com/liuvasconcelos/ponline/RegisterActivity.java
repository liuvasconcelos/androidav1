package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.register);

        Button button =  (Button) findViewById(R.id.register_button_on_register);
        final EditText emailInfo = (EditText) findViewById(R.id.enter_login);
        final EditText passwordInfo = (EditText) findViewById(R.id.enter_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInfo.getText().toString();
                String password = passwordInfo.getText().toString();
                firebaseRegister(email, password);
            }
        });

    }

    private void firebaseRegister(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    goToMainScreen();
                                } else {
                                    showToast();
                                }
                            }
                        });
    }

    private void goToMainScreen() {
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), R.string.toast, Toast.LENGTH_SHORT).show();
    }
}
