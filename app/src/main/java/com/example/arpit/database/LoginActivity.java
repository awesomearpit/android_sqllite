package com.example.arpit.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
  EditText et_username,et_password;
  Button btn_login;

   Shareddata shareddata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_password=findViewById(R.id.et_password);
        et_username=findViewById(R.id.et_username);
        btn_login=findViewById(R.id.btn_login);

        //to pass the area or context for shareddata class
        shareddata=new Shareddata(getApplicationContext());

    // To click on login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String susername,spassword;
                susername=et_username.getText().toString();
                spassword=et_password.getText().toString();
                // to check the username or password is correct or not

                if (susername.equals("pawan")&& spassword.equals("123456"))
                {
                    Intent login=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(login);

                    //To change the boolean value as true after login
                    shareddata.secondtime();
                }


            }
        });

    }
}
