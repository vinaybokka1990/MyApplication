package com.example.klreddy.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity   {
   private static int Timer=2000;
   private Handler mHandler=new Handler();
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, Timer);




      /*  AutoCompleteTextView editText = findViewById(R.id.actvPostSub);
        String[] suburbs = getResources().getStringArray(R.array.suburbs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, suburbs);
        editText.setAdapter(adapter);
        start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //Get the token
        FirebaseInstanceId.getInstance().getInstanceId();


        switch (v.getId()) {

            case R.id.buttonStart:
                startActivity(new Intent(this, ComparePlans.class));

        }*/
    }
}