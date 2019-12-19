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

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button bRegister;
    EditText fname,Email,PassWord,userName,addRess,phoneNUMBER,cpassword;
    TextView lLogin;
    Singleton singleton = Singleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fname = findViewById(R.id.fname);
        Email = findViewById(R.id.Email);
        PassWord = findViewById(R.id.PassWord);
        cpassword = findViewById(R.id.cpassword);
        addRess = findViewById(R.id.addRess);
        phoneNUMBER = findViewById(R.id.phoneNUMBER);
        userName = findViewById(R.id.userName);
        lLogin =  findViewById(R.id.lLogin);
        bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
        lLogin.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
            Validate();
//            Singleton.getInstance().generateId();
            startActivity(new Intent(this,SMSApp.class));




            break;
            case R.id.lLogin:
                startActivity(new Intent(this,MainActivity.class));
                break;
         }
        }


        public boolean ValidateUsername() {
            if (userName.getText().toString().length() < 3) {
                Toast.makeText(this,"Username must be 3 character or Longer",Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }

    public boolean ValidateFullname(){
        if (fname.getText().toString().equals("")){
            Toast.makeText(this,"Fullname must be filled",Toast.LENGTH_SHORT).show();
            return false;
        } else if (checkNumeric(fname.getText().toString())){
            Toast.makeText(this, "full name character only", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


        public boolean Validatepassword (){
            if (PassWord.getText().toString().length() < 6){
                Toast.makeText(this, "Password must be 6 char or longer", Toast.LENGTH_SHORT).show();
                return false;
            } else if(!checkAlphabet(PassWord.getText().toString()) && !checkNumeric(PassWord.getText().toString())) {
                Toast.makeText(this, "Password must contains alphabetic and numeric", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
        public boolean Validateconfrimpassword(){
        if (!cpassword.getText().toString().equals(PassWord.getText().toString())){
            Toast.makeText(this, "Password must the same", Toast.LENGTH_SHORT).show();
            return false;
        }
            return true;
        }

        public boolean Validateaddress(){
        if (addRess.getText().toString().equals("")){
            Toast.makeText(this, "Address must be fiiled", Toast.LENGTH_SHORT).show();
            return false;
        }
            return true;
        }
        public boolean Validateemail(){
            if(!contains(Email.getText().toString(), '@')) {
                Toast.makeText(this, "@ Must be 1", Toast.LENGTH_LONG).show();
                return false;
            } else if(!contains(Email.getText().toString(),'.')) {
                Toast.makeText(this, ". Must be 1", Toast.LENGTH_LONG).show();
                return false;
            } else if(!Email.getText().toString().endsWith("@bookparadise.com")) {
                Toast.makeText(this, "Must Ends With @bookparadise.com", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }
        public boolean Validatephonenumber() {
            if (phoneNUMBER.getText().toString().length() < 9 || phoneNUMBER.getText().toString().length() > 15) {
                Toast.makeText(this, "Phone Number between 9 and 15 digit", Toast.LENGTH_LONG).show();
                return false;
            } else if (checkAlphabet(phoneNUMBER.getText().toString())) {
                Toast.makeText(this, "Phone number must be numeric", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }

        private boolean checkNumeric(String strinng) {
        for(int i=0; i < strinng.length(); i++){
               if(Character.isDigit(strinng.charAt(i))) {
                   return true;
               }
            }
            return false;
        }

        public void Validate(){
        if (ValidateUsername()&&ValidateFullname()&&Validateemail()&&Validatepassword()&&Validateconfrimpassword()&&Validateaddress()&&Validatephonenumber()){
            Toast.makeText(this, "Success",Toast.LENGTH_LONG).show();
//            User users = new User(fname.getText().toString(),userName.getText().toString(),Email.getText().toString(),phoneNUMBER.getText().toString(),PassWord.getText().toString(),addRess.getText().toString());
//            Log.d("Check User",users.getEmail());
//            singleton.add(users);
//            Log.d("MemberID",singleton.getUsers().size()+"");
//            singleton.generateId();
//            Log.d("generate id",singleton.getUsers().get(0).getmemberid());

            DB db = new DB(this);

            int last = db.countAll(DB.tabeluser)+1;
            //generate ID
            String memberid = "MB" + String.format("%03d", last);
            db.insertUser(memberid,fname.getText().toString(),PassWord.getText().toString(),addRess.getText().toString(),Email.getText().toString(),phoneNUMBER.getText().toString());

        }
        }

        private boolean checkAlphabet(String string) {
            for(int i=0; i < string.length(); i++){
                if(Character.isAlphabetic(string.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        private boolean contains(String string, char a) {
            int count = 0;
            for(int i = 0; i < string.length();i++){
                if(string.charAt(i) == a) {
                    count++;
                }
                if(count > 1) {
                    return false;
                }
            }
            return true;
        }


    }

