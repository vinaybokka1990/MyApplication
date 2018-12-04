package com.example.klreddy.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvRegister;
    private EditText etFullname,etMobileNumber, etEmailid,etPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firebaseAuth=FirebaseAuth.getInstance();

        etFullname=(EditText)findViewById(R.id.etFullName);
        etEmailid=(EditText)findViewById(R.id.etEmailId);
        etMobileNumber=(EditText)findViewById(R.id.etMobileNumber);
        etPassword=(EditText)findViewById(R.id.etPwd);
        tvRegister=(TextView)findViewById(R.id.tvCreateUser);

        tvRegister.setOnClickListener(this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
       /* if(firebaseAuth.getCurrentUser()!=null)
        {

        }*/
    }

    @Override
    public void onClick(View v)
       {
        registerUser();

       }

       private void registerUser()
       {
         final String fname=etFullname.getText().toString().trim();
         final String mailid=etEmailid.getText().toString().trim();
         final String phonenum=etMobileNumber.getText().toString().trim();
         String password=etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(fname))
        {
            Toast.makeText(this,"Please enter full name", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(mailid))
        {
            Toast.makeText(this,"Please enter email id", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(phonenum))
        {
            Toast.makeText(this,"Please enter mobile number", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog=new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(mailid,password).addOnCompleteListener(
                this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            User user=new User(fname,mailid,phonenum);
                            FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressDialog.dismiss();
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(RegisterActivity.this, "values added into database",Toast.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(RegisterActivity.this, "error occured",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });

                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            updateUI(firebaseUser);
                            Toast.makeText(RegisterActivity.this, "Registered successfully",Toast.LENGTH_LONG).show();


                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Regisration Failed",Toast.LENGTH_LONG).show();
                        }

                    }

                });
    }

    private void updateUI(FirebaseUser user)
    {


    }


}
