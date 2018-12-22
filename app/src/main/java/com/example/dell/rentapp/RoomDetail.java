package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomDetail extends AppCompatActivity {
    private TextView txtTen;
    private TextView txtDT;
    private TextView txtDC;
    private TextView txtGia;
    private TextView txtDesc;
    private ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTen = (TextView) findViewById(R.id.txtDetail);
        txtDT = (TextView) findViewById(R.id.txtDT);
        txtDC = (TextView) findViewById(R.id.txtDC);
        txtGia = (TextView) findViewById(R.id.txtGia);
        txtDesc = (TextView) findViewById(R.id.txtDescription);
        imgDetail = (ImageView) findViewById(R.id.imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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

        Intent i = getIntent();
        Room roomDetail = (Room)i.getSerializableExtra("data");
        txtTen.setText(roomDetail.getTen());
        txtGia.setText(roomDetail.getGia() + " /tháng");
        txtDC.setText(roomDetail.getDiachi());
        txtDesc.setText(roomDetail.toString());
        txtDT.setText(roomDetail.getDientich());
        imgDetail.setImageResource(R.drawable.draw);

    }

}
