package com.example.atividade_04;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ViewList extends AppCompatActivity {

    ListView lst;
    String[] saints = {"Manga", "Banana", "Watermalon", "Kiwi", "Apple"};
    String[] desc = {"This is Mango", "This is Brazil", "This is Praia", "This is Passaro", "This is apple"};
    String[] image = {"This is Mango", "This is Brazil", "This is Praia", "This is Passaro", "This is apple"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        lst = (ListView) findViewById(R.id.liborio);
        CavaleirosListView cavaleirosListView = new CavaleirosListView(this,saints,desc,image);
        lst.setAdapter(cavaleirosListView);

    }
}
