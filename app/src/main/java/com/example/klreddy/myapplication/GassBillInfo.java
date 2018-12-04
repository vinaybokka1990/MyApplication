package com.example.klreddy.myapplication;

import android.content.Intent;
import android.net.LinkAddress;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GassBillInfo extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout gasBillManualLayout,gasBillImageLayout,gasBillEmailLayout;
    private Button gasBillManualButton,gasBillImageButton,gasBillEmailButton;
    private TextView tvGasBillSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gass_bill_info);

        gasBillManualLayout=(LinearLayout)findViewById(R.id.gasBillManualLayout);
        gasBillImageLayout=(LinearLayout)findViewById(R.id.gasBillImageLayout);
        gasBillEmailLayout=(LinearLayout)findViewById(R.id.gasBillEmailLayout);

        gasBillManualButton=(Button)findViewById(R.id.gasBillManualButton);
        gasBillImageButton=(Button)findViewById(R.id.gasBillImageButton);
        gasBillEmailButton=(Button)findViewById(R.id.gasBillEmailButton);

        tvGasBillSave=(TextView)findViewById(R.id.tvGasBillSave);

        gasBillManualButton.setOnClickListener(this);
        gasBillImageButton.setOnClickListener(this);
        gasBillEmailButton.setOnClickListener(this);
        tvGasBillSave.setOnClickListener(this);


    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.gasBillManualButton:
                 gasBillManualButton.setSelected(true);
                 gasBillImageButton.setSelected(false);
                 gasBillEmailButton.setSelected(false);
                 gasBillImageLayout.setVisibility(View.GONE);
                 gasBillEmailLayout.setVisibility(View.GONE);
                 gasBillManualLayout.setVisibility(View.VISIBLE);
                 break;
            case R.id.gasBillImageButton:
                gasBillManualButton.setSelected(false);
                gasBillImageButton.setSelected(true);
                gasBillEmailButton.setSelected(false);
                gasBillEmailLayout.setVisibility(View.GONE);
                gasBillManualLayout.setVisibility(View.GONE);
                gasBillImageLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.gasBillEmailButton:
                gasBillManualButton.setSelected(false);
                gasBillImageButton.setSelected(false);
                gasBillEmailButton.setSelected(true);
                gasBillImageLayout.setVisibility(View.GONE);
                gasBillManualLayout.setVisibility(View.GONE);
                gasBillEmailLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.tvGasBillSave:
                super.onBackPressed();
                //startActivity(new Intent(GassBillInfo.this,Electricity_Gas.class));
        }
    }
}
