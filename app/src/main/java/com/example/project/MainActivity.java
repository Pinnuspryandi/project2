package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogin;
    EditText userName, PassWord;
    TextView lRegisterHere;

    Singleton singleton = Singleton.getInstance();
    Librarysingleton librarysingleton = Librarysingleton.getInstance();
    ReviewSingleton reviewSingleton = ReviewSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        singleton.init();
        librarysingleton.init();
        reviewSingleton.init();
        userName =(EditText) findViewById(R.id.userName);
        PassWord = (EditText) findViewById(R.id.PassWord);
        lRegisterHere = (TextView) findViewById(R.id.lRegisterHere);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        lRegisterHere.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                Validate();
//                startActivity(new Intent(getApplicationContext(),Homepage.class));


        break;

            case R.id.lRegisterHere:
                startActivity(new Intent(getApplicationContext(),Register.class));
                break;
        }
    }
    public boolean ValidateUsername() {
        if (userName.getText().toString().equals("")) {
            Toast.makeText(this,"Username must be filled",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public boolean Validatepassword (){
        if (PassWord.getText().toString().equals("")){
            Toast.makeText(this, "Password must be filled", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    public void Validate(){
        if (ValidateUsername()&&Validatepassword()){
            Toast.makeText(this, "Success",Toast.LENGTH_LONG).show();
            for (int i = 0; i< singleton.getUsers().size(); i++ ) {
                Log.d("TEST",userName.getText().toString());
                Log.d("TSD",singleton.getUsers().get(i).getuserName());
                if (userName.getText().toString().equals(singleton.getUsers().get(i).getuserName())  && PassWord.getText().toString().equals(singleton.getUsers().get(i).getPassWord()) ){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Homepage.class);
                    startActivity(intent);
                }

            }
        }

    }
//    public void MemberID(){
//        Singleton.getInstance();
//        Singleton.getInstance().getUser().add(new User("MB001","Admin","admin","admin@bookparadise.com","08123456789","admin","Jl. Kebon Jerok No. 21"));
//        Singleton.getInstance().getUser().add(new User("MB002","Deny Howgart","Deny_h0","Deny_h@ bookparadise.com","089863217865","Den0123","Jalan Panjang No. 12"));
//    }
}

