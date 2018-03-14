package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeLogin);
        setContentView(R.layout.login);

        Button button =  (Button) findViewById(R.id.login_button);
        final EditText emailInfo = (EditText) findViewById(R.id.login_request_edit_text);
        final EditText passwordInfo = (EditText) findViewById(R.id.password_request_edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInfo.getText().toString();
                String password = passwordInfo.getText().toString();
//                if(email.equals("ltenoriovasconcelos@gmail.com") && password.equals("123456")) {
                if(email.equals("1") && password.equals("1")) {
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
