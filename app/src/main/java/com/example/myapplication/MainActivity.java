package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    GridView g1,g2;
    String api1,api2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        g1 = findViewById(R.id.g1);
        api1 = "https://futursity.com/course/api/top_courses";
        api2 = " https://futursity.com/course/api/categories";

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,api1,api2,null.new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("myapp", "the response is" + response.getString("title"));
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error){
                Log.e( "myapp", "somethingwrong");
            }
        });
        requestQueue.add(JSONObjectRequest);

    }
}

