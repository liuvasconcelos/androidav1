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

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.login);

        Button button =  (Button) findViewById(R.id.login_button);
        final EditText emailInfo = (EditText) findViewById(R.id.login_request_edit_text);
        final EditText passwordInfo = (EditText) findViewById(R.id.password_request_edit_text);

        String email = "ltenoriovasconcelos@gmail.com";
        String senha = "123456";
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(
                        this,     //Contexto da activity
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                System.out.print("sucesso");
                            }
                        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInfo.getText().toString();
                String password = passwordInfo.getText().toString();
//                if(email.equals("ltenoriovasconcelos@gmail.com") && password.equals("123456")) {
//                   goToMainScreen();
//                } else {
//                   showToast();
//                }
                firebaseAuth(email, password);
            }
        });

    }

    private void firebaseAuth(String emailPass, String passwordPass) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(emailPass, passwordPass).addOnCompleteListener(
                this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser usuario = FirebaseAuth.getInstance().getCurrentUser();
                            String email = usuario.getEmail();
                            System.out.println("usuario: "+email);
                            goToMainScreen();
                        } else {
                            showToast();
                        }
                    }
                }
        );
    }

    private void goToMainScreen() {
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), R.string.toast, Toast.LENGTH_SHORT).show();
    }
}
