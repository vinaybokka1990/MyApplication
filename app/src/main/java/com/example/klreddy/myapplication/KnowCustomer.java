package com.example.klreddy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class KnowCustomer extends AppCompatActivity {
Button next;
TextView tvname,tvMobileNum, tvEmailId, tvPostalAdd;
EditText etname, etMobileNum, etEmailId, etPostalAdd;
LinearLayout l1;
String name, email, address;
int phone;
int i=0;
    private static String url_create_product = "http://localhost/Ethical_Prospecting/new_customer.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_customer);

        l1=(LinearLayout)findViewById(R.id.layout1);


        next=(Button)findViewById(R.id.buttonNext);
        tvname=(TextView)findViewById(R.id.tvName);
        etname=(EditText)findViewById(R.id.etName);


        tvMobileNum=new TextView(this);
        tvMobileNum.setText("What is your Mobile Number");
        tvMobileNum.setGravity(Gravity.CENTER);
        tvMobileNum.setPadding(0,0,0,10);
        etMobileNum=new EditText(this);
        etMobileNum.setBackgroundResource(R.drawable.border_style);
        etMobileNum.setGravity(Gravity.CENTER);
        etMobileNum.setId(Integer.parseInt("etMobileNum"));


        tvEmailId=new TextView(this);
        tvEmailId.setText("What is your Email Id");
        tvEmailId.setGravity(Gravity.CENTER);
        tvEmailId.setPadding(0,0,0,10);
        etEmailId=new EditText(this);
        etEmailId.setGravity(Gravity.CENTER);
        etEmailId.setBackgroundResource(R.drawable.border_style);
        etEmailId.setId(Integer.parseInt("etEmailId"));

        tvPostalAdd=new TextView(this);
        tvPostalAdd.setText("What is your Postal Address");
        tvPostalAdd.setGravity(Gravity.CENTER);
        tvPostalAdd.setPadding(0,0,0,10);
        etPostalAdd=new EditText(this);
        etPostalAdd.setGravity(Gravity.CENTER);
        etPostalAdd.setBackgroundResource(R.drawable.border_style);
        etPostalAdd.setId(Integer.parseInt("etPostalAdd"));





        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(i==0)
               {
                   name=etname.getText().toString();
                   l1.removeAllViews();
                   l1.addView(tvMobileNum);
                   l1.addView(etMobileNum);
                   i++;
               }
               else if(i==1)
               {
                   phone=Integer.parseInt(etMobileNum.getText().toString());
                   l1.removeAllViews();
                   l1.addView(tvEmailId);
                   l1.addView(etEmailId);
                   i++;
               }
               else if(i==2)
               {
                   email=etEmailId.getText().toString();
                   l1.removeAllViews();
                   l1.addView(tvPostalAdd);
                   l1.addView(etPostalAdd);
                   i++;
               }
               else if(i==3)
               {
                   address=etPostalAdd.getText().toString();
                   // Building Parameters



               }
            }
        });


    }
}
