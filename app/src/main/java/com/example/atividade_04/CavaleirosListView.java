package com.example.atividade_04;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CavaleirosListView extends BaseAdapter {

private final ArrayList<Character> characters;
private final Activity context;
//private String URL = "https://raw.githubusercontent.com/diegochagas/saint-seiya-api/master/frontend/src/";

public CavaleirosListView(ArrayList<Character> characters, Activity context){
    this.context = context;
    this.characters = characters;
}
    @Override public int getCount() { return characters.size(); }

    @Override public Object getItem(int position) { return characters. get(position); }

    @Override public long getItemId(int position) { return 0; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String URL = "https://raw.githubusercontent.com/diegochagas/saint-seiya-api/master/frontend/src/";
        View view = context.getLayoutInflater().inflate(R.layout.listview_layout,parent,false);
        Character character = characters.get(position);

        //pegando as referências das Views
        TextView name = (TextView) view.findViewById(R.id.textView2);
        //TextView id = (TextView) view.findViewById(R.id.textView);
        ImageView imagem = (ImageView) view.findViewById(R.id.imageView2);

        //populando as Views
        try {
            name.setText(" ID: " + String.valueOf(character.getId()) + "\nName: " + character.getName().toString() + "\nCloth: " + character.getCloth().get(0).getCloth());
        } catch (IndexOutOfBoundsException e){
            name.setText(" ID: " + String.valueOf(character.getId()) + "\nName: " + character.getName().toString() + "\nCloth: " + "NONE");
        }
        //id.setText("\n");
        URL = URL + character.getImage().toString();
        //Log.i("URL: ", URL);
        Picasso.get().load(URL).into(imagem);
        //imagem.setImageResource(R.drawable.java);

        return view;
    }
}

