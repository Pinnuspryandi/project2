package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class User {
    String  memberid, userName, fname, email, PassWord,phoneNUMBER, addRess;

    public String getAddRess(){
        return addRess;
    }


    public String getuserName(){
        return userName;
    }

    public User(String memberid) {
        this.memberid = memberid;
    }

    public User() {
    }

    public String getmemberid() {
        return memberid;
    }

    public void setMemberid(String memberid){
        this.memberid = memberid;
    }

    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassWord() {
        return PassWord;
    }

    public String getPhoneNUMBER() {
        return phoneNUMBER;
    }


    public User( String fname, String userName, String email, String phoneNUMBER, String PassWord,String addRess){
        this.fname = fname;
        this.email= email;
        this.userName = userName;
        this.addRess = addRess;
        this.phoneNUMBER = phoneNUMBER;
        this.PassWord = PassWord;

    }



}

