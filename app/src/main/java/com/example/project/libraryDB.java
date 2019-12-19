package com.example.project;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class libraryDB extends AppCompatActivity {
    ArrayList<classLibrary> libraries = new ArrayList<>();
    public static String url = "https://api.myjson.com/bins/pobqg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_db);
        fetchData();

    }

    public  void fetchData(){
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //  Log.d("test", response.length() + "");
                        for(int i = 0; i <response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int libraryId = jsonObject.getInt("libraryId");
                                String libraryName = jsonObject.getString("libraryName");
                                String libraryAddress = jsonObject.getString("libraryAddress");
                                String libraryPhone = jsonObject.getString("libraryPhone");
                                double latitude = jsonObject.getDouble("latitude");
                                double longitude = jsonObject.getLong("longitude");

                                classLibrary library = new classLibrary(libraryId,libraryName,libraryAddress,libraryPhone,latitude,longitude);
                                Log.d("data dari library", library.getLibraryId() + " " + library.getLibraryName() + "" + library.getLibraryAddress() + " "
                                + library.getLibraryPhone() + "" + library.getLatitude() + "" + library.getLongitude() + "");
                                libraries.add(library);
                            }catch (JSONException e){
                                e.printStackTrace();
                                Log.d("data dari library", "error");

                            }

                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR", error.toString());

                    }
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }
}
