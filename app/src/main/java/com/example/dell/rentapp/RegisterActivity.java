package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.security.auth.login.LoginException;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference mdb;
    private TextView txtMeesage;
    private EditText txtUser, txtPass;
    private Button btnRegis, btnCancel;
    public String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtMeesage = (TextView)findViewById(R.id.txtMeesage);
        txtUser = (EditText)findViewById(R.id.txtUser);
        txtPass = (EditText)findViewById(R.id.txtPass);
        btnRegis = (Button) findViewById(R.id.btnRegis);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        final Intent intent = new Intent(getBaseContext(), LogInActivity.class);
        mdb = FirebaseDatabase.getInstance().getReference("Taikhoan");

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userID = mdb.push().getKey();

                Account acc = new Account(txtUser.getText().toString(),txtPass.getText().toString(), false, "", "", "");
                mdb.child(userID).setValue(acc);
                txtMeesage.setText("Đăng ký thành công");
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
