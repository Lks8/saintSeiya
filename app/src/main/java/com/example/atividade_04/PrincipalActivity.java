package com.example.atividade_04;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        String URL = "https://vignette.wikia.nocookie.net/liberproeliis/images/c/c1/Saint_seiya_logo_by_poderheavy-d3gl8te.png/revision/latest?cb=20190528200057&path-prefix=pt-br";
        String URL_2 = "http://static.tumblr.com/af3311669171dd3b185bae885ac14133/wibig0n/72hmi1zeq/tumblr_static_nike-big.png";
        ImageView imagemCDZ = (ImageView) findViewById(R.id.imageCDZ);

        Picasso.get().load(URL).into(imagemCDZ);
        MediaPlayer ring = MediaPlayer.create(PrincipalActivity.this,R.raw.raw);
        ring.start();
    }
    public void changeView(View view){
        Intent intent = new Intent(this,preListView.class);
        startActivity(intent);

    }
}
