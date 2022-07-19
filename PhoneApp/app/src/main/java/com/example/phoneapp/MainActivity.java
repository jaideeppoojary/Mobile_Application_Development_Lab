package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndel,btnstar,btnhash,btncall,btnsave;
    EditText txtPhonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn0=(Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4=(Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5=(Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6=(Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7=(Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8=(Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9=(Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btnhash=(Button) findViewById(R.id.btnHash);
        btnhash.setOnClickListener(this);

        btnstar=(Button) findViewById(R.id.btnStar);
        btnstar.setOnClickListener(this);

        btnsave=(Button) findViewById(R.id.btnSave);
        btnsave.setOnClickListener(this);

        btncall=(Button) findViewById(R.id.btnCall);
        btncall.setOnClickListener(this);

        btndel=(Button) findViewById(R.id.btnDelete);
        btndel.setOnClickListener(this);

        txtPhonenumber = (EditText) findViewById(R.id.editText);
        txtPhonenumber.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btn1)){
            txtPhonenumber.append("1");
        }
        else if(v.equals(btn2))txtPhonenumber.append("2");
        else if(v.equals(btn3))txtPhonenumber.append("3");
        else if(v.equals(btn4))txtPhonenumber.append("4");
        else if(v.equals(btn5))txtPhonenumber.append("5");
        else if(v.equals(btn6))txtPhonenumber.append("6");
        else if(v.equals(btn7))txtPhonenumber.append("7");
        else if(v.equals(btn8))txtPhonenumber.append("8");
        else if(v.equals(btn9))txtPhonenumber.append("9");
        else if(v.equals(btn0))txtPhonenumber.append("0");
        else if(v.equals(btnstar))txtPhonenumber.append("*");
        else if(v.equals(btnhash))txtPhonenumber.append("#");
        else if(v.equals(btnsave)){
            Intent contactIntent=new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,txtPhonenumber.getText().toString());
            startActivity(contactIntent);
        }
        else if(v.equals(btndel)){
            String data=txtPhonenumber.getText().toString();
            if(data.length()>0)
                txtPhonenumber.setText(data.substring(0,data.length()-1));
            else
                txtPhonenumber.setText("");
        }
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=txtPhonenumber.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });
    }
}