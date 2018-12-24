package com.example.dell.rentapp;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogictisActivity extends AppCompatActivity {
    DatabaseReference mData;
    TextView txtTotal, txtAvailable, txtNon;
    Button btnBack;
    long i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logictis);
        mData = FirebaseDatabase.getInstance().getReference();

        txtTotal = (TextView)findViewById(R.id.txtTotal);
        txtNon = (TextView)findViewById(R.id.txtNon);
        txtAvailable = (TextView)findViewById(R.id.txtAvailable);
        btnBack = (Button) findViewById(R.id.btnBack);

        mData.child("Chitietnha").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    long count = dataSnapshot.getChildrenCount();
                    txtTotal.setText(""+count);
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        if(ds.child("trangthai").getValue().toString().equals("true")){
                            i++;
                        }
                    }
                    txtNon.setText(""+i);
                    long j = count - i;
                    txtAvailable.setText(""+j);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
