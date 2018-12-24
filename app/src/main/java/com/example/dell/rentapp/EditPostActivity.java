package com.example.dell.rentapp;

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

public class EditPostActivity extends AppCompatActivity {
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
    Button button2, btnDong;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        mData = FirebaseDatabase.getInstance().getReference("Chitietnha");

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        btnDong = (Button) findViewById(R.id.btnDong);
        edittext1 = (EditText) findViewById(R.id.et1);
        edittext2 = (EditText) findViewById(R.id.et2);
        edittext3 = (EditText) findViewById(R.id.et3);
        edittext4 = (EditText) findViewById(R.id.et4);
        edittext5 = (EditText) findViewById(R.id.et5);
        edittext6 = (EditText) findViewById(R.id.et6);
        edittext7 = (EditText) findViewById(R.id.et7);
        edittext8 = (EditText) findViewById(R.id.et8);

        key = getIntent().getStringExtra("key");
        mData.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ten = (String) dataSnapshot.child("tennha").getValue();
                String diachi = (String) dataSnapshot.child("diachi").getValue();
                String dt = (String) dataSnapshot.child("dienthoai").getValue();
                String dientich = (String) dataSnapshot.child("dientich").getValue();
                String ghichu = (String) dataSnapshot.child("ghichu").getValue();
                String gia = (String) dataSnapshot.child("gia").getValue();
                String tienich = (String) dataSnapshot.child("tienich").getValue();
                String hinhanh = (String) dataSnapshot.child("hinhanh").getValue();
                edittext1.setText(ten);
                edittext2.setText(diachi);
                edittext3.setText(dientich);
                edittext4.setText(tienich);
                edittext5.setText(hinhanh);
                edittext6.setText(gia);
                edittext7.setText(ghichu);
                edittext8.setText(dt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child(key).child("tennha").setValue(edittext1.getText().toString());
                mData.child(key).child("diachi").setValue(edittext2.getText().toString());
                mData.child(key).child("dienthoai").setValue(edittext8.getText().toString());
                mData.child(key).child("dientich").setValue(edittext3.getText().toString());
                mData.child(key).child("ghichu").setValue(edittext7.getText().toString());
                mData.child(key).child("gia").setValue(edittext6.getText().toString());
                mData.child(key).child("tienich").setValue(edittext4.getText().toString());
                mData.child(key).child("hinhanh").setValue(edittext5.getText().toString());
                Toast.makeText(EditPostActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child(key).child("trangthai").setValue(true);
            }
        });
    }


}
