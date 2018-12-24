package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoAccountActivity extends AppCompatActivity {

    private DatabaseReference mdb;
    private EditText txtTen, txtSDT, txtDC;
    private Button btnSave;
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_account);

        txtTen = (EditText)findViewById(R.id.txtHoten);
        txtSDT = (EditText)findViewById(R.id.txtSDT);
        txtDC = (EditText)findViewById(R.id.txtDC);
        btnSave = (Button) findViewById(R.id.btnSave);
        mdb = FirebaseDatabase.getInstance().getReference("Taikhoan");
        key = getIntent().getStringExtra("key");
        mdb.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("name").getValue();
                String phone = (String) dataSnapshot.child("phone").getValue();
                String add = (String) dataSnapshot.child("address").getValue();
                txtTen.setText(name);
                txtSDT.setText(""+phone);
                txtDC.setText(add);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        Toast.makeText(InfoAccountActivity.this, key, Toast.LENGTH_SHORT).show();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdb.child(key).child("name").setValue(txtTen.getText().toString());
                mdb.child(key).child("phone").setValue(txtSDT.getText().toString());
                mdb.child(key).child("address").setValue(txtDC.getText().toString());
                Toast.makeText(InfoAccountActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
