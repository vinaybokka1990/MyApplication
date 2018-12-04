package com.example.klreddy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UtilitiesHome extends AppCompatActivity  implements View.OnClickListener {
    private Button umElecBtn, umElecGasBtn;
private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilities_home);
        umElecBtn = (Button) findViewById(R.id.umElecButton);
        umElecGasBtn = (Button) findViewById(R.id.umElecGasButton);

        umElecBtn.setOnClickListener(this);
        b=new Bundle();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.umElecButton:
                    //Bundle b=new Bundle();
                    b.putString("class","Electricity");
                    Intent i=new Intent(UtilitiesHome.this,PostCode.class);
                    i.putExtras(b);
                    startActivity(i);
                    break;

            case R.id.umElecGasButton:
                //Bundle bundle=new Bundle();
                b.putString("class","ElectricityGas");
                Intent p=new Intent(UtilitiesHome.this,PostCode.class);
                p.putExtras(b);
                startActivity(p);
                break;



        }
    }
}
