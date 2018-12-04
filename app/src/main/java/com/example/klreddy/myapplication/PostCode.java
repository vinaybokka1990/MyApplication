package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostCode extends AppCompatActivity implements View.OnClickListener{
private Button pcStartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_code);
        pcStartBtn=(Button)findViewById(R.id.pcStartBtn);
        pcStartBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
     Intent in=getIntent();
        Bundle b=in.getExtras();
        String utility=b.getString("class");

        if(utility.equals("Electricity"));
        {
            startActivity(new Intent(PostCode.this,Electricity.class));
        }
        if(utility.equals("ElectricityGas"))
        {
            startActivity(new Intent(PostCode.this,Electricity_Gas.class));
        }

    }
}
