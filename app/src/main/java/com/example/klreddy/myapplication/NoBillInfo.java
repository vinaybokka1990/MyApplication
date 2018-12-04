package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NoBillInfo extends AppCompatActivity implements View.OnClickListener{
    private TextView tvNoBillSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_bill_info);
        tvNoBillSave=(TextView)findViewById(R.id.tvNoBillSave);
        tvNoBillSave.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tvNoBillSave:
                startActivity(new Intent(NoBillInfo.this,Electricity_Gas.class));
        }
    }
}
