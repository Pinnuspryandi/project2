package com.example.project;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DB extends SQLiteOpenHelper{

    public static String tabeluser = "user";
    public static String tabelreview = "review";
    public static String tablelibrary = "library";

    public static String memberid = "memberid";
    public static String username = "username";
    public static String fullname = "fullname";
    public static String password = "password";
    public static String address = "address";
    public static String email = "email";
    public static String phone= "phone";

    public static String reviewid = "reviewid";
    public  static String reviewtitle = "reviewtitle";
    public static String reviewdesc = "reviewdesc";

    public static String dbparadise = "bookworm.db";

    public DB(Context context) {
        super(context, dbparadise, null, 1);
    }

    String usertable = "create table if not exists " + tabeluser + "(" + memberid + "," + username + ","
            + fullname + "," + password + "," + address + "," + email + "," + phone + ")";

    String reviewtable = "create table if not exists " + tabelreview + "(" + reviewid + "," + reviewtitle + ","
            + reviewdesc  + ")";

    String insertusertable = "insert into  " + tabeluser  + "(" + memberid + "," + username + ","
            + fullname + "," + password + "," + address + "," + email + "," + phone + ")" + "values " +
            "('MB001' , 'admin' , 'Admin' , 'admin' , 'Jl. Kebon Jerok No. 21' , 'admin@bookparadise.com' , '08123456789') , " +
            "('MB002' , 'Deny_h0' , 'Deny Howgart' , 'Den0123' , 'Jalan Panjang No. 12', 'Deny_h@bookparadise.com' , '089863217865')";

    String insertreviewtable = "insert into " + tabelreview + "(" + reviewid + "," + reviewtitle + "," + reviewdesc + ")" + "values('1' , 'good' , 'This library have a complete series of books') , " +
            "('2', 'Best Library', 'Best' )";


    public void insertUser(String memberid , String fullname , String password , String address , String email , String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DB.memberid, memberid);
        cv.put(DB.fullname, fullname);
        cv.put(DB.password, password);
        cv.put(DB.address, address);
        cv.put(DB.email, email);
        cv.put(DB.phone, phone);

        db.insert(DB.tabeluser,null , cv);

    }
    public void insertReview(String reviewtitle , String reviewdesc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DB.reviewtitle, reviewtitle);
        cv.put(DB.reviewdesc, reviewdesc);

        db.insert(DB.tabelreview,null , cv);

    }

    public int countAll(String table_name){
        String query = "select * from " + table_name;
        Cursor cursor = getReadableDatabase().rawQuery(query,null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usertable);
        db.execSQL(reviewtable);
        db.execSQL(insertusertable);
        db.execSQL(insertreviewtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(usertable);
        db.execSQL(reviewtable);
        db.execSQL(insertusertable);
        db.execSQL(insertreviewtable);
    }

    public void DeleteButton(String reviewtitle , String reviewdesc){
        SQLiteDatabase db = getWritableDatabase();
        String selection ="";
        String [] args = {reviewtitle,reviewdesc};
        db.delete(tabelreview, selection,args );
    }
}
