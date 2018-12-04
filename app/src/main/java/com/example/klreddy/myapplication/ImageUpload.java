package com.example.klreddy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.bitmap;


public class ImageUpload extends AppCompatActivity {
    Button upload;
    ImageView imageview;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int PICK_IMAGE_REQUEST= 99;
    Bitmap bitmap;
    String myurl = "http://192.168.155.197/Ethical_Prospecting/upload.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);

        upload = (Button) findViewById(R.id.upload);
        imageview = (ImageView) findViewById(R.id.imageview);
        imageview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                showFileChooser();
            }
        });

        upload.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                uploaduserimage();
            }
        });

        if (Build.VERSION.SDK_INT >= 24)
        {
            if (checkPermission()) {
                // Code for above or equal 23 API Oriented Device
                // Your Permission granted already .Do next code
            } else

                {
                requestPermission();
            }
        }

            }

    private void requestPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(ImageUpload.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(ImageUpload.this, " Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(ImageUpload.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    private boolean checkPermission()
    {
        int result = ContextCompat.checkSelfPermission(ImageUpload.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(ImageUpload.this, "Permission Granted Successfully! ", Toast.LENGTH_LONG).show();
                } else
                    {
                    Toast.makeText(ImageUpload.this, "Permission Denied 🙁 ", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void showFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                Toast.makeText(this, "" + bitmap, Toast.LENGTH_SHORT).show();
                //Setting the Bitmap to ImageView
                imageview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploaduserimage()
    {


        RequestQueue requestQueue = Volley.newRequestQueue(ImageUpload.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

                Log.i("Myresponse",""+response);
                Toast.makeText(ImageUpload.this, ""+response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i("Mysmart",""+error);
                Toast.makeText(ImageUpload.this, ""+error, Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> param = new HashMap<>();

                String images = getStringImage(bitmap);
                Log.i("imageupload",""+images);
                param.put("image",images);
                return param;
            }
        };

        requestQueue.add(stringRequest);


    }

    public String getStringImage(Bitmap bitmap)
    {
        Log.i("image upload",""+bitmap);
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);


        return temp;
    }
}
