package com.example.klreddy.myapplication;


import com.android.volley.RequestQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.lang.*;



public class AndroidPhpDemo extends AppCompatActivity {

    String url = "http://192.168.155.197/Ethical_Prospecting/insert.php";
    private static final String TAG="Testing";

    RequestQueue requestQueue;
    EditText firstname, lastname, age;
    Button submit;
    //String fname, lname, sage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_php_demo);
        firstname = (EditText) findViewById(R.id.etdemo1);
        lastname = (EditText) findViewById(R.id.etdemo2);
        age = (EditText) findViewById(R.id.etdemo3);

        submit = (Button) findViewById(R.id.buttonDemo);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(AndroidPhpDemo.this, "values are inserted into database", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AndroidPhpDemo.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                        params.put("firstname", firstname.getText().toString());
                        params.put("lastname", lastname.getText().toString());
                        params.put("age", age.getText().toString());

                        return params;
                    }
                };
                requestQueue.add(request);
            }
        });

    }

    }


