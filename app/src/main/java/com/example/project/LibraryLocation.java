package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryLocation extends AppCompatActivity {

    private TextView lblName;
    private TextView lblAddress;
    private TextView lblPhone;
    private TextView lblLongitude;
    private TextView lblLatitude;
    private Librarysingleton librarysingleton = Librarysingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_location);

        lblName = findViewById(R.id.lblLibraryName);
        lblAddress = findViewById(R.id.lblLibraryAddress);
        lblPhone = findViewById(R.id.lblLibraryPhone);
        lblLongitude = findViewById(R.id.lblLongitude);
        lblLatitude = findViewById(R.id.lblLatitude);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        lblName.setText(librarysingleton.get().get(index).getLibraryName());
        lblAddress.setText(librarysingleton.get().get(index).getLibraryAddress());
        lblPhone.setText(librarysingleton.get().get(index).getLibraryPhone());
        lblLongitude.setText(librarysingleton.get().get(index).getLongitude());
        lblLatitude.setText(librarysingleton.get().get(index).getLatitude());

    }
}
