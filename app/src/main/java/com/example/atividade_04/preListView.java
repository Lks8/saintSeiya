package com.example.atividade_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class preListView extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_list_view);

        String URL = "https://images.alphacoders.com/675/thumb-1920-675142.png";
        ImageView imagemCDZ = (ImageView) findViewById(R.id.someImage);
        Picasso.get().load(URL).into(imagemCDZ);
    }

    public void filterSaints(View view){
        Intent intent = new Intent(this, ViewList.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
