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
import android.widget.SearchView;
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
    protected Room room;
    private SearchView btnSearch;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listRoom = new ArrayList<>();
        txtres = (TextView)findViewById(R.id.txtRes);
        listView = (ListView)findViewById(R.id.listView);
        btnSearch = (SearchView)findViewById(R.id.txtSearch);

        mdb = FirebaseDatabase.getInstance().getReference();
//        final String keyID = mdb.push().getKey();
        txtres.setText("Danh sách nhà cho thuê");
        roomListAdapter = new RoomListAdapter(this, R.layout.room_list, listRoom);
        listView.setAdapter(roomListAdapter);
        addDatatoListView();

        btnSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mdb.child("Chitietnha").orderByChild("tennha").equalTo(query).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        listRoom.clear();
                        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()){
                            listRoom.add(new Room(
                                    childSnapshot.child("diachi").getValue().toString(),
                                    childSnapshot.child("dienthoai").getValue().toString(),
                                    childSnapshot.child("dientich").getValue().toString(),
                                    childSnapshot.child("ghichu").getValue().toString(),
                                    childSnapshot.child("gia").getValue().toString(),
                                    childSnapshot.child("hinhanh").getValue().toString(),
                                    childSnapshot.child("tennha").getValue().toString(),
                                    childSnapshot.child("tienich").getValue().toString(),
                                    Boolean.parseBoolean(childSnapshot.child("tienich").getValue().toString())
                            ));
                            roomListAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              setContentView(R.layout.content_room_detail);
                intent = new Intent(MainActivity.this, RoomDetail.class);
                numbertoDetail = (Room) listRoom.get(position);
                intent.putExtra("data", numbertoDetail);
                intent.putExtra("check", getIntent().getStringExtra("user"));
                mdb.child("Chitietnha").orderByChild("tennha").equalTo(numbertoDetail.getTen()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                            String key = childSnapshot.getKey();
//                            Toast.makeText(MainActivity.this, key, Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getBaseContext(), InfoAccountActivity.class);
                            intent.putExtra("keynha", key);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
//                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if(getIntent().getStringExtra("user") != null){
            if(getIntent().getStringExtra("user").equals("Admin")){
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
                MenuItem registrar5 = menu.findItem(R.id.item6);
                registrar5.setVisible(false);
                MenuItem registrar6 = menu.findItem(R.id.item7);
                registrar6.setVisible(true);
            }else{
                MenuItem registrar = menu.findItem(R.id.item1);
                registrar.setVisible(false);
                MenuItem registrar1 = menu.findItem(R.id.item2);
                registrar1.setVisible(false);
                MenuItem registrar2 = menu.findItem(R.id.item3);
                registrar2.setVisible(true);
                MenuItem registrar3 = menu.findItem(R.id.item4);
                registrar3.setVisible(true);
                MenuItem registrar4 = menu.findItem(R.id.item5);
                registrar4.setVisible(true);
                MenuItem registrar5 = menu.findItem(R.id.item6);
                registrar5.setVisible(true);
                MenuItem registrar6 = menu.findItem(R.id.item7);
                registrar6.setVisible(false);
            }

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
            MenuItem registrar5 = menu.findItem(R.id.item6);
            registrar5.setVisible(false);
            MenuItem registrar6 = menu.findItem(R.id.item7);
            registrar6.setVisible(false);
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
                intent = new Intent(MainActivity.this, ActiveAccountActivity.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Email nhóm: izziteam2019@gmail.com \n SĐT: 0985875471", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                return true;
            case R.id.item5:

                mdb.child("Taikhoan").orderByChild("username").equalTo(getIntent().getStringExtra("user")).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                            String key = childSnapshot.getKey();
//                            Toast.makeText(MainActivity.this, key, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getBaseContext(), InfoAccountActivity.class);
                            intent.putExtra("key", key);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                return true;
            case R.id.item6:
                intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
                return true;
            case R.id.item7:
                intent = new Intent(MainActivity.this, LogictisActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addDatatoListView() {
        mdb.child("Chitietnha").orderByChild("trangthai").equalTo(false).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                listRoom.add(new Room(
                        dataSnapshot.child("diachi").getValue().toString(),
                        dataSnapshot.child("dienthoai").getValue().toString(),
                        dataSnapshot.child("dientich").getValue().toString(),
                        dataSnapshot.child("ghichu").getValue().toString(),
                        dataSnapshot.child("gia").getValue().toString(),
                        dataSnapshot.child("hinhanh").getValue().toString(),
                        dataSnapshot.child("tennha").getValue().toString(),
                        dataSnapshot.child("tienich").getValue().toString(),
                        Boolean.parseBoolean(dataSnapshot.child("tienich").getValue().toString())
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
