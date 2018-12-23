package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class LogInActivity extends AppCompatActivity {
    private DatabaseReference mdbase;
    private EditText txtUser;
    private EditText txtPass;
    private Button btnLog;
    private TextView txtMess;
    private Button btnRegis;
    private String us = "";
    private String pw = "";
    private Boolean stt;
    private ArrayList<Account> listAcc = new ArrayList<Account>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        txtUser =   (EditText) findViewById(R.id.txtUser);
        txtPass =   (EditText) findViewById(R.id.txtPass);
        btnLog = (Button) findViewById(R.id.btnLogin);
        txtMess =   (TextView) findViewById(R.id.txtMess);
        btnRegis = (Button) findViewById(R.id.btnRegis);
        final Intent intent = new Intent(getBaseContext(), RegisterActivity.class);

        mdbase = FirebaseDatabase.getInstance().getReference();

        mdbase.child("Taikhoan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                listAcc.add( new Account(dataSnapshot.child("username").getValue().toString(),dataSnapshot.child("password").getValue().toString(),Boolean.parseBoolean(dataSnapshot.child("status").getValue().toString())));

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean flag = false;
                for(Account acc: listAcc){
                    us = acc.getUsername();
                    pw = acc.getPassword();
                    stt = acc.isStatus();
                    if(txtUser.getText().toString().equals(us)){
                        if(txtPass.getText().toString().equals(pw)){
                            if(stt == true){
                                Toast.makeText(LogInActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(getBaseContext(), MainActivity.class);
                                in.putExtra("user", us);
                                startActivity(in);
                                flag = true;
                                break;
                            }else{
                                Toast.makeText(LogInActivity.this, "Tài khoản chưa kích hoạt", Toast.LENGTH_SHORT).show();
                                flag = true;
                                break;
                            }

                        }else{
                            Toast.makeText(LogInActivity.this, "Nhập sai Pass", Toast.LENGTH_SHORT).show();
                            flag =true;
                            break;
                        }
                    }
                }
                if(flag == false){
                    Toast.makeText(LogInActivity.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent.putExtra("userid", Userid);
                startActivity(intent);

            }
        });
    }

}
