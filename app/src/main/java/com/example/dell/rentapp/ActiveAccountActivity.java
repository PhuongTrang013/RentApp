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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActiveAccountActivity extends AppCompatActivity {

    private ListView listView;
    private DatabaseReference mdb;
    private AccountListAdapter accountListAdapter;
    private ArrayList<Account> listAccount;
    private Account acCount;
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_account);
        listView = (ListView)findViewById(R.id.listView);
        mdb = FirebaseDatabase.getInstance().getReference();

        listAccount = new ArrayList<>();
        accountListAdapter = new AccountListAdapter(this, R.layout.account_list, listAccount);
            listView.setAdapter(accountListAdapter);
        addDatatoListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////              setContentView(R.layout.content_room_detail);
                acCount = (Account) listAccount.get(position);
                mdb.child("Taikhoan").orderByChild("username").equalTo(acCount.getUsername()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                             key = childSnapshot.getKey();
                             mdb.child("Taikhoan").child(key).child("status").setValue(true);
                            Toast.makeText(ActiveAccountActivity.this, "Kích hoạt tài khoản thành công", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(getIntent());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }

    private void addDatatoListView() {
        mdb.child("Taikhoan").orderByChild("status").equalTo(false).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                listAccount.add(new Account(
                        dataSnapshot.child("username").getValue().toString(),
                        dataSnapshot.child("password").getValue().toString(),
                        Boolean.parseBoolean(dataSnapshot.child("status").getValue().toString()),
                        dataSnapshot.child("name").getValue().toString(),
                        dataSnapshot.child("phone").getValue().toString(),
                        dataSnapshot.child("address").getValue().toString()
                ));
                accountListAdapter.notifyDataSetChanged();
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
