package com.example.bhupendra.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class telphony extends AppCompatActivity {
   private final int REQUEST_PERMISION_SEND_SMS=1;

  //  EditText ed1,ed2,ed3;
    Button bt3;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telphony);

      //  ed3=(EditText)findViewById(R.id.bt3);
      //  ed1=(EditText)findViewById(R.id.bt);
       // ed2=(EditText)findViewById(R.id.bt1);

       bt3=(Button)findViewById(R.id.bt2);
       bt3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               managebtclick();


           }
       });
    }
    public void managebtclick()
    {
        intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:7579013416"));

       if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS )!= PackageManager.PERMISSION_GRANTED)
       {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},REQUEST_PERMISION_SEND_SMS);
       }
       else
     {
         startActivity(intent);
      }
   }

 /* public void email() {

        String message =ed1.getText().toString();
      String num1 =ed3.getText().toString();

     // String num2= ed2.getText().toString();

       SmsManager smsManager=SmsManager.getDefault();
    //  smsManager.sendTextMessage(message, null,num1, null,null);
       smsManager.sendTextMessage(message, null,num2, null,null);
      Toast.makeText(getApplicationContext(),"messege sent",Toast.LENGTH_LONG).show();
  }*/
}
