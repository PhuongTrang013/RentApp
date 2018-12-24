package com.example.dell.rentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AccountListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Account> accountList;

    public AccountListAdapter(Context context, int layout, List<Account> accountList) {
        this.context = context;
        this.layout = layout;
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AccountHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            holder = new AccountHolder();
            holder.txtUsername = (TextView) convertView.findViewById(R.id.txtUsername);
            holder.txtName = (TextView)convertView.findViewById(R.id.txtName);
            holder.txtPhone = (TextView)convertView.findViewById(R.id.txtP);
            convertView.setTag(holder);
        } else {
            holder = (AccountHolder) convertView.getTag();
        }

        Account acc = accountList.get(position);

        holder.txtUsername.setText(acc.getUsername());
        holder.txtName.setText(acc.getName());
        holder.txtPhone.setText(acc.getPhone());

        return convertView;
    }
}
