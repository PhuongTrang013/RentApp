package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    DatabaseReference mData;
    EditText edittext1;
    EditText edittext2;
    EditText edittext3;
    EditText edittext4;
    EditText edittext5;
    EditText edittext6;
    EditText edittext7;
    EditText edittext8;
    Button button1;
    Button button2;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mData = FirebaseDatabase.getInstance().getReference();

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        edittext1 = (EditText) findViewById(R.id.et1);
        edittext2 = (EditText) findViewById(R.id.et2);
        edittext3 = (EditText) findViewById(R.id.et3);
        edittext4 = (EditText) findViewById(R.id.et4);
        edittext5 = (EditText) findViewById(R.id.et5);
        edittext6 = (EditText) findViewById(R.id.et6);
        edittext7 = (EditText) findViewById(R.id.et7);
        edittext8 = (EditText) findViewById(R.id.et8);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangbai(edittext1.getText().toString(),edittext2.getText().toString(),edittext3.getText().toString(),edittext4.getText().toString(),
                        edittext5.getText().toString(),edittext6.getText().toString(),edittext7.getText().toString(),edittext8.getText().toString(),false);
                Toast.makeText(PostActivity.this, "Đăng thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void dangbai(String tennha, String diachi, String dientich, String tienich, String gia, String ghichu, String dienthoai,String hinhanh, boolean stt) {
        String key = mData.child("post").push().getKey();
        Post post = new Post(tennha,diachi,tienich,dientich,gia,ghichu,dienthoai,hinhanh,stt);
        mData = FirebaseDatabase.getInstance().getReference("Chitietnha");
        mData.child(key).setValue(post);
    }
}








