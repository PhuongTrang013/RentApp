package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mdb;
    private TextView txtres;
    private ArrayList<Room> listRoom;
    private ListView listView;
    private RoomListAdapter roomListAdapter;
    private Room numbertoDetail;
    protected Room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRoom = new ArrayList<>();
        txtres = (TextView)findViewById(R.id.txtRes);
        listView = (ListView)findViewById(R.id.listView);

        mdb = FirebaseDatabase.getInstance().getReference();
        txtres.setText("Danh sách nhà cho thuê");
        roomListAdapter = new RoomListAdapter(this, R.layout.room_list, listRoom);
        listView.setAdapter(roomListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                setContentView(R.layout.content_room_detail);
                Intent intent = new Intent(MainActivity.this, RoomDetail.class);
                numbertoDetail = (Room) listRoom.get(position);
                intent.putExtra("data", numbertoDetail);
                startActivity(intent);
            }
        });
        addDatatoListView();
    }

    private void addDatatoListView() {
        mdb.child("Chitietnha").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                listRoom.add(new Room(
                        dataSnapshot.child("Diachi").getValue().toString(),
                        dataSnapshot.child("Dienthoai").getValue().toString(),
                        dataSnapshot.child("Dientich").getValue().toString(),
                        dataSnapshot.child("Ghichu").getValue().toString(),
                        dataSnapshot.child("Gia").getValue().toString(),
                        dataSnapshot.child("Hinhanh").getValue().toString(),
                        dataSnapshot.child("Ten").getValue().toString(),
                        dataSnapshot.child("Tienich").getValue().toString()
                        ));
                roomListAdapter.notifyDataSetChanged();
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
    }

}
