package com.example.login_register_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username , password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.usernameL);
        password = findViewById(R.id.passwordL);
        login = findViewById(R.id.btnLogin);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("") ){
                    Toast.makeText(Login.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                }else{
                    Boolean checkuserpass = DB.chekcusernamepassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(Login.this, "Sign in successfull", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}