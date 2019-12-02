package com.example.atividade_04;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CavaleirosListView extends ArrayAdapter<Character> {

    private String[] names;
    private Integer[] ids;
    private String[] imageUrl;
    private Activity context;

    public CavaleirosListView(Activity context, String[] names, Integer[] ids, String[] imageUrl) {
        super(context, R.layout.listview_layout);
        this.context = context;
        this.names = names;
        this.ids = ids;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null, true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) r.getTag();

        }
        //String URL = "https://raw.githubusercontent.com/diegochagas/saint-seiya-api/master/frontend/src/" + Characters.get(position).getImage();

        viewHolder.tvw1.setText(names[position]);
        viewHolder.tvw2.setText(ids[position]);
        //viewHolder.tvw2.setText(Characters.get(position).getCloth().get(0).getCloth());
        //Picasso.get().load(URL).into(viewHolder.ivw);
        return r;

    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1 = v.findViewById(R.id.textView);
            tvw2 = v.findViewById(R.id.textView2);
            ivw =  v.findViewById(R.id.imageView2);
        }
    }
}

