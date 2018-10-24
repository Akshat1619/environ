package com.akshat.environ;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class QRCode extends AppCompatActivity {
    String account;
    private Button buttonScan;
    private TextView textViewName;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        buttonScan = (Button) findViewById(R.id.buttonScan);
        qrScan = new IntentIntegrator(this);
        textViewName = (TextView) findViewById(R.id.textViewName);
        }



        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        JSONObject obj = new JSONObject(result.getContents());
                        textViewName.setText(obj.getString("value"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }


    public void btnn(View view) {
        qrScan.initiateScan();
    }
}