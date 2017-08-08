package com.example.admin.databasehw;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    public static final int CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE = 1777;
    private static final String TAG = "Main";
    private WebView webView;
    Button btn1,btn2, btn3, btn4, btn5;
    EditText et1,et2, et3, et4 , et5;
    TextView tv1,tv2, tv3, tv4, tv5;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView= (WebView) findViewById(R.id.webview);

        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://developer.android.com");

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);


        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);



        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);



        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);



        databaseHelper = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
                ContactInfo contact = new ContactInfo(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(),
                et4.getText().toString(), et5.getText().toString());
                Log.d(TAG, "onClick: "+contact.getName() + " " + contact.getPhone() + " " + contact.getEmail()
                + " " + contact.getJobTitle() + " " + contact.getAddress());
                databaseHelper.saveNewContact(contact);
                break;
            case R.id.btn2:
                ArrayList<ContactInfo> contacts = databaseHelper.getContacts();
                String tv1S = "", tv2S="", tv3S = "", tv4S= "", tv5S= "";
                for(int i=0;i<contacts.size();i++){
                    tv1S += contacts.get(i).getName() + "\n";
                    tv2S += contacts.get(i).getPhone() + "\n";
                    tv3S += contacts.get(i).getEmail() + "\n";
                    tv4S += contacts.get(i).getAddress() + "\n";
                    tv5S += contacts.get(i).getJobTitle() + "\n";


                }
                tv1.setText(tv1S);
                tv2.setText(tv2S);
                tv3.setText(tv3S);
                tv4.setText(tv4S);
                tv5.setText(tv5S);

                break;
            case R.id.btn5:
                databaseHelper.Delete();
                break;

        }


    }


}

