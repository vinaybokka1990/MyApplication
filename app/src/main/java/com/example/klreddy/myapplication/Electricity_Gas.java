package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Electricity_Gas extends AppCompatActivity implements View.OnClickListener {

    private Button egElecBillButton,egElecNoBillButton,egGasBillButton,egNoGasBillButton;
    private Button elecgasHomeBtn,elecgasBnsBtn,elecgasYesPropBtn,elecgasNoPropBtn,elecgasYesSolarBtn,elecgasNoSolarBtn,
                   elecgasYesDiscBtn,elecgasNoDiscBtn,elecgasImpBtn,elecgasNotImpBtn,noGasBillLowButton,noGasBillMediumButton,
                   noGasBillHighButton,elecgasLowButton,elecgasMediumButton,elecgasHighButton;
    private Bundle bundle;
    private LinearLayout noElecGasBillLayout,noGasBillLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity__gas);
        egElecBillButton=(Button)findViewById(R.id.egElecBillButton);
        egElecNoBillButton=(Button)findViewById(R.id.egElecNoBillButton);
        egGasBillButton=(Button)findViewById(R.id.egGasBillButton);
        egNoGasBillButton=(Button)findViewById(R.id.egNoGasBillButton);

        egElecBillButton.setOnClickListener(this);
        egElecNoBillButton.setOnClickListener(this);
        egGasBillButton.setOnClickListener(this);
        egNoGasBillButton.setOnClickListener(this);

        elecgasHomeBtn=(Button)findViewById(R.id.elecgasHomeBtn);
        elecgasBnsBtn=(Button)findViewById(R.id.elecgasBnsBtn);
        elecgasYesPropBtn=(Button)findViewById(R.id.elecgasYesPropBtn);
        elecgasNoPropBtn=(Button)findViewById(R.id.elecgasNoPropBtn);
        elecgasYesSolarBtn=(Button)findViewById(R.id.elecgasYesSolarBtn);
        elecgasNoSolarBtn=(Button)findViewById(R.id.elecgasNoSolarBtn);
        elecgasYesDiscBtn=(Button)findViewById(R.id.elecgasYesDiscBtn);
        elecgasNoDiscBtn=(Button)findViewById(R.id.elecgasNoDiscBtn);
        elecgasImpBtn=(Button)findViewById(R.id.elecgasImpBtn);
        elecgasNotImpBtn=(Button)findViewById(R.id.elecgasNotImpBtn);

        elecgasLowButton=(Button)findViewById(R.id.elecgasLowButton);
        elecgasMediumButton=(Button)findViewById(R.id.elecgasMediumButton);
        elecgasHighButton=(Button)findViewById(R.id.elecgasHighButton);

        noGasBillLowButton=(Button)findViewById(R.id.noGasBillLowButton);
        noGasBillMediumButton=(Button)findViewById(R.id.noGasBillMediumButton);
        noGasBillHighButton=(Button)findViewById(R.id.noGasBillHighButton);

        elecgasHomeBtn.setOnClickListener(this);
        elecgasBnsBtn.setOnClickListener(this);
        elecgasYesPropBtn.setOnClickListener(this);
        elecgasNoPropBtn.setOnClickListener(this);
        elecgasYesSolarBtn.setOnClickListener(this);
        elecgasNoSolarBtn.setOnClickListener(this);
        elecgasYesDiscBtn.setOnClickListener(this);
        elecgasNoDiscBtn.setOnClickListener(this);
        elecgasImpBtn.setOnClickListener(this);
        elecgasNotImpBtn.setOnClickListener(this);

        elecgasLowButton.setOnClickListener(this);
        elecgasMediumButton.setOnClickListener(this);
        elecgasHighButton.setOnClickListener(this);


        noGasBillLowButton.setOnClickListener(this);
        noGasBillMediumButton.setOnClickListener(this);
        noGasBillHighButton.setOnClickListener(this);

        noElecGasBillLayout=(LinearLayout)findViewById(R.id.noElecGasBillLayout);
        noGasBillLayout=(LinearLayout)findViewById(R.id.noGasBillLayout);


        bundle=new Bundle();


    }
   @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.egElecBillButton:
                egElecBillButton.setSelected(true);
                egElecBillButton.setSelected(false);
                bundle.putString("bill","ElecGasBill");
                 Intent k=new Intent(Electricity_Gas.this,ElectricityBillInfo.class);
                 k.putExtras(bundle);
                 startActivity(k);
                noElecGasBillLayout.setVisibility(View.GONE);
                 break;
            case R.id.egElecNoBillButton:
                 egElecNoBillButton.setSelected(true);
                 egElecBillButton.setSelected(false);
                noElecGasBillLayout.setVisibility(View.VISIBLE);
                 break;
            case R.id.egGasBillButton:
                egGasBillButton.setSelected(true);
                egNoGasBillButton.setSelected(false);
                noGasBillLayout.setVisibility(View.GONE);
                startActivity(new Intent(Electricity_Gas.this,GassBillInfo.class));
                break;
            case R.id.egNoGasBillButton:
                 egNoGasBillButton.setSelected(true);
                 egGasBillButton.setSelected(false);
                noGasBillLayout.setVisibility(View.VISIBLE);
                 break;

            case R.id.elecgasHomeBtn:
                elecgasHomeBtn.setSelected(true);
                elecgasBnsBtn.setSelected(false);
                break;
            case R.id.elecgasBnsBtn:
                elecgasBnsBtn.setSelected(true);
                elecgasHomeBtn.setSelected(false);
                break;
            case R.id.elecgasYesPropBtn:
                elecgasYesPropBtn.setSelected(true);
                elecgasNoPropBtn.setSelected(false);
                break;
            case R.id.elecgasNoPropBtn:
                elecgasNoPropBtn.setSelected(true);
                elecgasYesPropBtn.setSelected(false);
                break;
            case R.id.elecgasYesSolarBtn:
                elecgasYesSolarBtn.setSelected(true);
                elecgasNoSolarBtn.setSelected(false);
                break;
            case R.id.elecgasNoSolarBtn:
                elecgasNoSolarBtn.setSelected(true);
                elecgasYesSolarBtn.setSelected(false);
                break;
            case R.id.elecgasYesDiscBtn:
                elecgasYesDiscBtn.setSelected(true);
                elecgasNoDiscBtn.setSelected(false);
                break;
            case R.id.elecgasNoDiscBtn:
                elecgasNoDiscBtn.setSelected(true);
                elecgasYesDiscBtn.setSelected(false);
                break;
            case R.id.elecgasImpBtn:
                elecgasImpBtn.setSelected(true);
                elecgasNotImpBtn.setSelected(false);
                break;
            case R.id.elecgasNotImpBtn:
                elecgasNotImpBtn.setSelected(true);
                elecgasImpBtn.setSelected(false);
                break;

            case R.id.elecgasLowButton:
                elecgasLowButton.setSelected(true);
                elecgasMediumButton.setSelected(false);
                elecgasHighButton.setSelected(false);
                break;
            case R.id.elecgasMediumButton:
                elecgasMediumButton.setSelected(true);
                elecgasLowButton.setSelected(false);
                elecgasHighButton.setSelected(false);
                break;
            case R.id.elecgasHighButton:
                elecgasHighButton.setSelected(true);
                elecgasLowButton.setSelected(false);
                elecgasMediumButton.setSelected(false);
                break;
            case R.id.noGasBillLowButton:
                noGasBillLowButton.setSelected(true);
                noGasBillMediumButton.setSelected(false);
                noGasBillHighButton.setSelected(false);
                break;
            case R.id.noGasBillMediumButton:
                noGasBillMediumButton.setSelected(true);
                noGasBillLowButton.setSelected(false);
                noGasBillHighButton.setSelected(false);
                break;
            case R.id.noGasBillHighButton:
                noGasBillHighButton.setSelected(true);
                noGasBillLowButton.setSelected(false);
                noGasBillMediumButton.setSelected(false);
                break;

        }
    }



}
