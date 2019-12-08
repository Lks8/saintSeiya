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
        View view = context.getLayoutInflater().inflate(R.layout.activity_list_view_layout,parent,false);
        Character character = characters.get(position);

        TextView name = (TextView) view.findViewById(R.id.text_name);
        TextView gender = (TextView) view.findViewById(R.id.text_gender);
        TextView age = (TextView) view.findViewById(R.id.text_age);
        TextView nationality = (TextView) view.findViewById(R.id.text_nationality);
        TextView birth = (TextView) view.findViewById(R.id.text_birth);

        ImageView imagem = (ImageView) view.findViewById(R.id.image_view);

        name.setText(" Name: " + character.getName().toString());
        gender.setText(" gender: "+ character.getGender().toString());
        name.setText(" Name: "+ character.getName().toString());
        age.setText("Age: " + character.getAge().toString());
        nationality.setText("Nationality: " + character.getNationality().toString());
        birth.setText("Birth: " + character.getBirth().toString());
        try {

            nationality.setText("Cloth: " + character.getCloth().get(0).getCloth().toString());
        } catch (IndexOutOfBoundsException e){
            nationality.setText("Cloth: NONE");
        }
        URL = URL + character.getImage().toString();
        Picasso.get().load(URL).into(imagem);
        return view;
    }
}

