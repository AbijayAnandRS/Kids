package com.example.kids.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kids.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.text.TextUtils.isEmpty;

public class LoginActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText edUserName = findViewById(R.id.ed_user_name);
        final EditText edPassWord = findViewById(R.id.ed_password);
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(edUserName.getText().toString()) || isEmpty(edPassWord.getText().toString())){
                    Toast.makeText(getBaseContext(), "Please fill properly", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
