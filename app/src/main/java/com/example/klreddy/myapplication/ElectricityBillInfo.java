package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ElectricityBillInfo extends AppCompatActivity implements View.OnClickListener{

    private Button elecBillImageButton,elecBillEmailButton,elecBillPeakButton,elecBillNoPeakButton,
     elecBillSaveButton,elecBillManualButton;
    LinearLayout elecBillManualLayout,elecBillPeakLayout,elecBillImageLayout,elecBillEmailLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill_info);
        elecBillManualButton=(Button)findViewById(R.id.elecBillManualButton);
        elecBillImageButton=(Button)findViewById(R.id.elecBillImageButton);
        elecBillEmailButton=(Button)findViewById(R.id.elecBillEmailButton);
        elecBillSaveButton=(Button)findViewById(R.id.elecBillSaveButton);

        elecBillManualLayout=(LinearLayout)findViewById(R.id.elecBillManuaLayout);
        elecBillImageLayout=(LinearLayout)findViewById(R.id.elecBillImageLayout);
        elecBillEmailLayout=(LinearLayout)findViewById(R.id.elecBillEmailLayout);
        elecBillPeakLayout=(LinearLayout)findViewById(R.id.elecBillPeakLayout);

        elecBillPeakButton=(Button)findViewById(R.id.elecBillPeakButton);
        elecBillNoPeakButton=(Button)findViewById(R.id.elecBillNoPeakButton);

        elecBillManualButton.setOnClickListener(this);
        elecBillImageButton.setOnClickListener(this);
        elecBillEmailButton.setOnClickListener(this);
        elecBillSaveButton.setOnClickListener(this);
        elecBillPeakButton.setOnClickListener(this);
        elecBillNoPeakButton.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.elecBillManualButton:
                elecBillEmailLayout.setVisibility(View.GONE);
                elecBillEmailButton.setSelected(false);
                elecBillImageLayout.setVisibility(View.GONE);
                elecBillImageButton.setSelected(false);
                elecBillManualLayout.setVisibility(View.VISIBLE);
                elecBillManualButton.setSelected(true);
                break;
            case R.id.elecBillImageButton:
                elecBillManualLayout.setVisibility(View.GONE);
                elecBillManualButton.setSelected(false);
                elecBillEmailLayout.setVisibility(View.GONE);
                elecBillEmailButton.setSelected(false);
                elecBillImageLayout.setVisibility(View.VISIBLE);
                elecBillImageButton.setSelected(true);
                break;
            case R.id.elecBillEmailButton:
                elecBillManualLayout.setVisibility(View.GONE);
                elecBillManualButton.setSelected(false);
                elecBillImageLayout.setVisibility(View.GONE);
                elecBillImageButton.setSelected(false);
                elecBillEmailLayout.setVisibility(View.VISIBLE);
                elecBillEmailButton.setSelected(true);

               break;

            case R.id.elecBillPeakButton:
                elecBillPeakLayout.setVisibility(View.VISIBLE);
                elecBillPeakButton.setSelected(true);
                elecBillNoPeakButton.setSelected(false);
                break;
            case R.id.elecBillNoPeakButton:
                elecBillPeakLayout.setVisibility(View.GONE);
                elecBillNoPeakButton.setSelected(true);
                elecBillPeakButton.setSelected(false);

                break;
            case R.id.elecBillSaveButton:
                saveBillInfo();
                break;
        }
    }

    private void saveBillInfo()
    {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String billInfo=bundle.getString("bill");
        if(billInfo.equals("ElecBill"));
        {
            super.onBackPressed();
            //startActivity(new Intent(ElectricityBillInfo.this,Electricity.class));
        }
        if(billInfo.equals("ElecGasBill"))
        {
            super.onBackPressed();
            //startActivity(new Intent(ElectricityBillInfo.this,Electricity_Gas.class));
        }
    }
}
