package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
//    String  [] LibraryNames = {"Badan Perpustakaan dan Arsip Daerah Provinsi DKI Jakarta","Perpustakaan Japan Foundation", "Perpustakaan Goethe-Institut","Perpustakaan Nasional Republik Indonesia","Perpustakaan Freedom","Perpustakaan Umum Provinsi DKI Jakarta","Perpustakaan Rujak Center for Urban Studies (RCUS)","Perpustakaan Sekolah Tinggi Ilmu Ekonomi PERBANAS Jakarta"};
//    String [] LibraryAddresss = {"Jalan Cikini Raya No. 73, Komplek TIM, Jakarta Pusat 10330","Gedung Summitmas 1 3rd Floor, Jl. Jend. Sudirman Kavling 61-62, Senayan, Kebayoran Baru, RT.5/RW.3, Senayan, Kby. Baru, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12190","Jl. Dr. GSSJ Ratulangi No.9-15, RT.2/RW.3, Gondangdia, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10350","Jl. Medan Merdeka Sel. No.11, RT.11/RW.2, Gambir, Senen, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110","Wisma Bakrie, Jl. H. R. Rasuna Said No.Kav, B-1, RT.11/RW.2, Kuningan, Karet Kuningan, Menteng, South Jakarta City, Jakarta 12920","Gedung Nyi Ageng Serang Lantai 7-8, I.H.R. Rasuna Said Kav. C-22, Setiabudi, RT.2/RW.5, Karet Kuningan, Setia Budi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12940","Gedung Ranuza lantai 2, Jalan Timor No. 10, Menteng, Jakarta Pusat","JL Ciputat Raya, No. 77A, Ciputat, RT.6/RW.8, Pd. Pinang, Kby. Lama, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 15412"};

    Button BLogout;
    Button BReview;
    Button bFetch;
//    classLibrary libraries = classLibrar

//    Librarysingleton librarysingleton = Librarysingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);
        bFetch = findViewById(R.id.bFetch);
        final ListView listview= findViewById(R.id.listview);
        final CustomAdapter customAdapter = new CustomAdapter();


//        bFetch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listview.setAdapter(customAdapter);
//            }
//        });
        bFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview.setAdapter(customAdapter);
                Intent intent = new Intent(getApplicationContext(),libraryDB.class);
                startActivity(intent);
            }
        });



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),LibraryLocation.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });

         BLogout = findViewById(R.id.BLogout);
         BReview = findViewById(R.id.bReview);
        BLogout.setOnClickListener(this);
        BReview.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BLogout:
               startActivity(new Intent(this,MainActivity.class));

                break;

            case R.id.bReview:
                startActivity(new Intent(this,Reviews.class));

                DB db = new DB(this);

                int insertReview = db.countAll(DB.tabelreview);
                //generate ID
//             String memberid = "MB" + String.format("%03d", last);
                db.insertReview("","",);
        }

    }

    public class CustomAdapter extends BaseAdapter{




        @Override
        public int getCount() {

            return librarysingleton.get().size();
        }

        @Override
        public Object getItem(int position) {
            return LibraryAddresss;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =getLayoutInflater().inflate(R.layout.librarylayout,null);
            TextView textviewlibraryname = (TextView) view.findViewById(R.id.textviewlibraryname);
            TextView textviewlibraryaddress = (TextView) view.findViewById(R.id.textviewlibraryaddress);

            textviewlibraryname.setText(libraryName.get().get(position).getLibraryName());
            textviewlibraryaddress.setText(librarysingleton.get().get(position).getLibraryAddress());

            return view;

        }
    }
}
