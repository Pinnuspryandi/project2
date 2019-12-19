package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Array;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button bLogin;
    EditText userName, PassWord;
    TextView lRegisterHere;
    Singleton singleton = Singleton.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Singleton.getInstance();
        userName = findViewById(R.id.userName);
        PassWord =  findViewById(R.id.PassWord);
        lRegisterHere =  findViewById(R.id.lRegisterHere);
        bLogin =  findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        lRegisterHere.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bLogin:
                Validate();


//                Singleton.init();


            for (int i = 0; i< Singleton.getInstance().getUsers().size(); i++ ) {
                if (userName.getText().toString()== Singleton.getInstance().getUsers().get(i).getuserName() && PassWord.getText().toString() == Singleton.getInstance().getUsers().get(i).getPassWord()){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();

                }

            }
                break;

            case R.id.lRegisterHere:

                startActivity(new Intent(this,Register.class));
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
    public boolean ValidatePassWord (){
        if (PassWord.getText().toString().equals("")){
            Toast.makeText(this, "Password must be filled", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    public void Validate(){
        if (ValidateUsername()&&ValidatePassWord()){
            Toast.makeText(this, "Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Homepage.class);
            startActivity(intent);
        }
    }
//    public void MemberID(){
//        Singleton.getInstance();
//        Singleton.getInstance().getUser().add(new User("Admin","admin","admin@bookparadise.com","08123456789","admin","Jl. Kebon Jerok No. 21"));
//        Singleton.getInstance().getUser().add(new User("Deny Howgart","Deny_h0","Deny_h@ bookparadise.com","089863217865","Den0123","Jalan Panjang No. 12"));
//    }


}
