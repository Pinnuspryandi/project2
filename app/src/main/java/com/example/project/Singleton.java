package com.example.project;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Singleton {
        private static Singleton single_instance;
        private ArrayList<User> users =  new ArrayList<>();


        public static Singleton getInstance() {
            if(single_instance == null)
                single_instance = new Singleton();
                Log.d("Singleton", "Created");
            return  single_instance;
        }

        public void add (User user) {
            this.users.add(user);
        }


        public void generateId() {
            int last = users.size();
            String fixed = "MB" + String.format("%03d", last);
            users.get(last-1).setMemberid(fixed);

        }

//        public void returngeneratedId(){
//            int last = users.size()+1;
//            String fixed = "MB" + String.format("%03d", last);
//            users.get(last-1).setMemberid(fixed);
//        }


    public ArrayList<User> getUsers() {
        return users;
    }

    public void init(){

            users.add(new User("Admin","admin","admin@bookparadise.com","08123456789","admin","Jl. Kebon Jerok No. 21"));
            generateId();
            Singleton.getInstance().add(new User("Deny Howgart","Deny_h0","Deny_h@ bookparadise.com","089863217865","Den0123","Jalan Panjang No. 12"));
            generateId();
            Log.d("test", users.get(1).getmemberid());
    }


}

