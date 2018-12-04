package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Electricity extends AppCompatActivity  implements View.OnClickListener{
    private Button elecYesButton,elecNoButton,elecHomeBtn,elecBnsButn,elecYesPropBtn,elecNoPropBtn,elecYesSolarBtn,
                   elecNoSolarBtn,elecYesDiscBtn,elecNoDiscBtn,elecImpBtn,elecNotImpBtn,elecLowButton,elecMediumButton,elecHighButton;
    private Bundle bundle;
    private LinearLayout noElecBillLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        elecYesButton=(Button)findViewById(R.id.elecYesButton);
        elecNoButton=(Button)findViewById(R.id.elecNoButton);

        elecHomeBtn=(Button)findViewById(R.id.elecHomeBtn);
        elecBnsButn=(Button)findViewById(R.id.elecBnsButn);
        elecYesPropBtn=(Button)findViewById(R.id.elecYesPropBtn);
        elecNoPropBtn=(Button)findViewById(R.id.elecNoPropBtn);
        elecYesSolarBtn=(Button)findViewById(R.id.elecYesSolarBtn);
        elecNoSolarBtn=(Button)findViewById(R.id.elecNoSolarBtn);
        elecYesDiscBtn=(Button)findViewById(R.id.elecYesDiscBtn);
        elecNoDiscBtn=(Button)findViewById(R.id.elecNoDiscBtn);
        elecImpBtn=(Button)findViewById(R.id.elecImpBtn);
        elecNotImpBtn=(Button)findViewById(R.id.elecNotImpBtn);
        elecLowButton=(Button)findViewById(R.id.elecLowButton);
        elecMediumButton=(Button)findViewById(R.id.elecMediumButton);
        elecHighButton=(Button)findViewById(R.id.elecHighButton);
        bundle=new Bundle();

        elecYesButton.setOnClickListener(this);
        elecNoButton.setOnClickListener(this);

        elecHomeBtn.setOnClickListener(this);
        elecBnsButn.setOnClickListener(this);
        elecYesPropBtn.setOnClickListener(this);
        elecNoPropBtn.setOnClickListener(this);
        elecYesSolarBtn.setOnClickListener(this);
        elecNoSolarBtn.setOnClickListener(this);
        elecYesDiscBtn.setOnClickListener(this);
        elecNoDiscBtn.setOnClickListener(this);
        elecImpBtn.setOnClickListener(this);
        elecNotImpBtn.setOnClickListener(this);

        elecLowButton.setOnClickListener(this);
        elecMediumButton.setOnClickListener(this);
        elecHighButton.setOnClickListener(this);


        noElecBillLayout=(LinearLayout)findViewById(R.id.noElecBillLayout);


        }
        @Override
    public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.elecYesButton:
                   noElecBillLayout.setVisibility(View.GONE);
                   bundle.putString("bill","ElecBill");
                    Intent j=new Intent(Electricity.this,ElectricityBillInfo.class);
                    j.putExtras(bundle);
                    startActivity(j);
                    elecYesButton.setSelected(true);
                    elecNoButton.setSelected(false);
                    break;
                case R.id.elecNoButton:
                    elecNoButton.setSelected(true);
                    elecYesButton.setSelected(false);
                      noElecBillLayout.setVisibility(View.VISIBLE);
                     break;
                case R.id.elecHomeBtn:
                    elecHomeBtn.setSelected(true);
                    elecBnsButn.setSelected(false);
                    break;
                case R.id.elecBnsButn:
                    elecBnsButn.setSelected(true);
                    elecHomeBtn.setSelected(false);
                    break;
                case R.id.elecYesPropBtn:
                    elecYesPropBtn.setSelected(true);
                    elecNoPropBtn.setSelected(false);
                    break;
                case R.id.elecNoPropBtn:
                    elecNoPropBtn.setSelected(true);
                    elecYesPropBtn.setSelected(false);
                    break;
                case R.id.elecYesSolarBtn:
                    elecYesSolarBtn.setSelected(true);
                    elecNoSolarBtn.setSelected(false);
                    break;
                case R.id.elecNoSolarBtn:
                    elecNoSolarBtn.setSelected(true);
                    elecYesSolarBtn.setSelected(false);
                    break;
                case R.id.elecYesDiscBtn:
                    elecYesDiscBtn.setSelected(true);
                    elecNoDiscBtn.setSelected(false);
                    break;
                case R.id.elecNoDiscBtn:
                    elecNoDiscBtn.setSelected(true);
                    elecYesDiscBtn.setSelected(false);
                    break;
                case R.id.elecImpBtn:
                    elecImpBtn.setSelected(true);
                    elecNotImpBtn.setSelected(false);
                    break;
                case R.id.elecNotImpBtn:
                    elecNotImpBtn.setSelected(true);
                    elecImpBtn.setSelected(false);
                    break;
                case R.id.elecLowButton:
                    elecLowButton.setSelected(true);
                    elecMediumButton.setSelected(false);
                    elecHighButton.setSelected(false);
                    break;
                case R.id.elecMediumButton:
                    elecMediumButton.setSelected(true);
                    elecLowButton.setSelected(false);
                    elecHighButton.setSelected(false);
                    break;
                case R.id.elecHighButton:
                    elecHighButton.setSelected(true);
                    elecLowButton.setSelected(false);
                    elecMediumButton.setSelected(false);
                    break;
            }

        }


}

