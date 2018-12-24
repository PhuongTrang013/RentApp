package com.example.dell.rentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RoomListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Room> roomList;

    public RoomListAdapter(Context context, int layout, List<Room> roomList) {
        this.context = context;
        this.layout = layout;
        this.roomList = roomList;
    }

    @Override
    public int getCount() {
        return roomList.size();
    }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) convertView.findViewById(R.id.textViewTen);
            holder.txtDT = (TextView)convertView.findViewById(R.id.textViewDT);
            holder.txtGia = (TextView)convertView.findViewById(R.id.textViewGia);
            holder.imageView = (ImageView)convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Room room = roomList.get(position);

        holder.txtTen.setText(room.getTen());
        holder.txtDT.setText(room.getDientich());
        holder.txtGia.setText(room.getGia());
        holder.imageView.setImageResource(R.drawable.draw);

        return convertView;
    }
}
