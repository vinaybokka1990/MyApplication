package com.example.klreddy.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private  EditText userName, passWord;
    private Button bLogin;
    private ImageButton gLogin,fbLogin;
    private TextView registerLink, tvUpdate;
    private CallbackManager callbackManager;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private static  final int RC_SIGN_IN=1;
    private static final String TAG="Message";
    private GoogleSignInClient googleSignInClient;
    RequestQueue requestQueue;
    String loginurl="http://192.168.155.197/Ethical_Prospecting/checkCredentials.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        userName = (EditText) findViewById(R.id.etUsername);
        passWord = (EditText) findViewById(R.id.etPwd);
        bLogin = (Button) findViewById(R.id.loginButton);
        gLogin=(ImageButton)findViewById(R.id.googleButton);
        registerLink = (TextView) findViewById(R.id.tvCreateUser);
        fbLogin = (ImageButton)findViewById(R.id.fbButton);


        firebaseAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
        //fbLogin.setReadPermissions(Arrays.asList("email"));

        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);
        findViewById(R.id.googleButton).setOnClickListener(this);
        fbLogin.setOnClickListener(this);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    //facebook login

        private void fbLogin()
        {
            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            // App code
                            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                            handleFacebookToken(loginResult.getAccessToken());

                        }


                        @Override
                        public void onCancel() {
                            // App code

                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        }
        private void handleFacebookToken(AccessToken accessToken) {
            Toast.makeText(getApplicationContext(), "firebase", Toast.LENGTH_LONG).show();

            AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                updateUI(firebaseUser);
                                Toast.makeText(getApplicationContext(), "User successfully registered to firebase", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Could not register to firebase", Toast.LENGTH_LONG).show();
                            }
                        }

                    });
        }





    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.loginButton:

                    validateUserData();

                break;

            case R.id.tvCreateUser:

                startActivity(new Intent(this, RegisterActivity.class));

                break;
            case R.id.googleButton:

                googleSignIn();

               break;
            case R.id.fbButton:
               fbLogin();
        }
    }


//validating user data

    private void validateUserData()
    {

       final String mailid= userName.getText().toString().trim();
       final String password=passWord .getText().toString().trim();


        if(TextUtils.isEmpty(mailid))
        {
            userName.setError("Please enter your email");
            userName.requestFocus();
            Toast.makeText(this,"Please enter email id", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            passWord.setError("Please enter your password");
            passWord.requestFocus();
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_LONG).show();
            return;
        }
               //validating email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mailid).matches()) {
            userName.setError("Enter a valid email");
            userName.requestFocus();
            return;
        }

        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("sigining the user...");
        progressDialog.show();


     /*  firebaseAuth.signInWithEmailAndPassword(mailid, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               progressDialog.dismiss();
               if (task.isSuccessful())
               {

                Intent intent=new Intent(LoginActivity.this,UtilitiesHome.class );
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
               }
               else
               {
               Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
               }

           }
       });*/

            loginUser(mailid,password);

    }
    // user login
private void loginUser(final String mailid,final String password)
{

    StringRequest stringRequest=new StringRequest(Request.Method.POST, loginurl, new Response.Listener<String>() {
        @Override
        public void onResponse(String response)
        {
            progressDialog.dismiss();

            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("error"))
                {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int customerId = object.getInt("customerId");
                    Toast.makeText(getApplicationContext(), object.getString("message")+" "+customerId, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, UtilitiesHome.class));
                }

            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    },new Response.ErrorListener()
    {
        public void onErrorResponse(VolleyError error)
        {
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;
        }

    }){
        @Override
        protected Map<String,String> getParams() throws AuthFailureError
        {
            Map<String, String> params=new HashMap<>();
            params.put("userEmail",mailid);
            params.put("password",password);

            return params;
        }
    };
    requestQueue.add(stringRequest);
}
//Google login


    private void googleSignIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
        else
        {
            callbackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    private void updateUI(FirebaseUser user)
    {


    }

}
