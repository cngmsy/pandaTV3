package com.jiyun.qcloud.dashixummoban.ui.China;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/20.
 */

public class Gridadapter extends BaseAdapter{
    ArrayList<String> arrayListtuo;
    Context context;

    public Gridadapter(ArrayList<String> arrayListtuo, Context context) {
        this.arrayListtuo = arrayListtuo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListtuo.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListtuo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder der;
        if(convertView==null){
            der=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.weidow_tet, null);
            der.te = (TextView) convertView.findViewById(R.id.ein_tetet);
            convertView.setTag(der);
        }else {
           der= (ViewHolder) convertView.getTag();
        }
        String s = arrayListtuo.get(position);
        der.te.setText(s);

        return convertView;
    }
    class ViewHolder{
        TextView te;
    }
}
