package com.example.atividade_04;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CavaleirosListView extends ArrayAdapter<String> {


    private String[] saints;
    private String[] desc;
    private String[] image;
    private Activity context;

    public CavaleirosListView(Activity context, String[] fruitname, String[] desc, String[] image) {
        super(context, R.layout.listview_layout,fruitname);

        this.context=context;
        this.saints = fruitname;
        this.desc = desc;
        this.image = image;

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
//        viewHolder.ivw.setImageResource();
        viewHolder.tvw1.setText(saints[position]);
        viewHolder.tvw2.setText(desc[position]);

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

