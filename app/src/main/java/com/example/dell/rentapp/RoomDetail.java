package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoomDetail extends AppCompatActivity {
    private TextView txtTen;
    private TextView txtDT;
    private TextView txtDC;
    private TextView txtGia;
    private TextView txtDesc;
    private Button btnEdit, btnDele, btnBack;
    private ImageView imgDetail;
    String key;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mData = FirebaseDatabase.getInstance().getReference();

        txtTen = (TextView) findViewById(R.id.txtDetail);
        txtDT = (TextView) findViewById(R.id.txtDT);
        txtDC = (TextView) findViewById(R.id.txtDC);
        txtGia = (TextView) findViewById(R.id.txtGia);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDele = (Button) findViewById(R.id.btnDelete);
        btnBack = (Button) findViewById(R.id.btnBack);
        txtDesc = (TextView) findViewById(R.id.txtDescription);

        imgDetail = (ImageView) findViewById(R.id.imageView);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chuyển trang liên hệ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                setContentView(R.layout.content_room_detail);
                Intent intent = new Intent(RoomDetail.this, Contact.class);
                startActivity(intent);
            }
        });
        if(getIntent().getStringExtra("check")!= null){
            btnDele.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.VISIBLE);
        }else{
            btnDele.setVisibility(View.INVISIBLE);
            btnEdit.setVisibility(View.INVISIBLE);
        }
        Intent i = getIntent();
        Room roomDetail = (Room)i.getSerializableExtra("data");
        txtTen.setText(roomDetail.getTen());
        txtGia.setText(roomDetail.getGia() + " /tháng");
        txtDC.setText(roomDetail.getDiachi());
        txtDesc.setText(roomDetail.toString());
        txtDT.setText(roomDetail.getDientich());
        imgDetail.setImageResource(R.drawable.draw);
        key = getIntent().getStringExtra("keynha");
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), EditPostActivity.class);
                in.putExtra("key",key);
                startActivity(in);

            }
        });

        btnDele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child("Chitietnha").child(key).removeValue();
                Toast.makeText(RoomDetail.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getBaseContext(), MainActivity.class);
                startActivity(in);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }

}
