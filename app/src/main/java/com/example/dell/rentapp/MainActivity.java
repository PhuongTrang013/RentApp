package com.example.dell.rentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private DatabaseReference mdbase;
    private TextView txtres;
    private ArrayList<Room> listRoom;
    private ListView listView;
    private RoomListAdapter roomListAdapter;
    private Room numbertoDetail;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private MenuItem item4;
    private MenuItem item5;
//    private Button btn4;
    protected Room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listRoom = new ArrayList<>();
        txtres = (TextView)findViewById(R.id.txtRes);
        listView = (ListView)findViewById(R.id.listView);

        mdb = FirebaseDatabase.getInstance().getReference();
//        final String keyID = mdb.push().getKey();
        txtres.setText("Danh sách nhà cho thuê");
        roomListAdapter = new RoomListAdapter(this, R.layout.room_list, listRoom);
        listView.setAdapter(roomListAdapter);
        addDatatoListView();
//        btn4 = (Button)findViewById(R.id.button4);
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mdb.child(keyID).removeValue();
//            }
//        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              setContentView(R.layout.content_room_detail);
                Intent intent = new Intent(MainActivity.this, RoomDetail.class);
                numbertoDetail = (Room) listRoom.get(position);
                intent.putExtra("data", numbertoDetail);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return  true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if(getIntent().getStringExtra("user") != null){
            MenuItem registrar = menu.findItem(R.id.item1);
            registrar.setVisible(false);
            MenuItem registrar1 = menu.findItem(R.id.item2);
            registrar1.setVisible(true);
            MenuItem registrar2 = menu.findItem(R.id.item3);
            registrar2.setVisible(true);
            MenuItem registrar3 = menu.findItem(R.id.item4);
            registrar3.setVisible(true);
            MenuItem registrar4 = menu.findItem(R.id.item5);
            registrar4.setVisible(true);
        }else {
            MenuItem registrar = menu.findItem(R.id.item1);
            registrar.setVisible(true);
            MenuItem registrar1 = menu.findItem(R.id.item2);
            registrar1.setVisible(false);
            MenuItem registrar2 = menu.findItem(R.id.item3);
            registrar2.setVisible(false);
            MenuItem registrar3 = menu.findItem(R.id.item4);
            registrar3.setVisible(false);
            MenuItem registrar4 = menu.findItem(R.id.item5);
            registrar4.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
