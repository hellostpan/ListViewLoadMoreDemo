package com.example.stpan.listviewloadmoredemo;

import android.content.Context;
import android.print.PrintAttributes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by stpan on 2016/3/15.
 */
public class ListViewAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public ListViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview,null);
            myHolder = new MyHolder();
            myHolder.textView = (TextView) convertView.findViewById(R.id.tv_item_listview);
            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.textView.setText(list.get(position));
        return convertView;
    }

    private class MyHolder{
        private TextView textView;
    }
}
