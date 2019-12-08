package com.example.atividade_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.atividade_04.MESSAGE";
    private TextView textName;
    private TextView textAge;
    private TextView textBirth;
    private TextView textGender;
    private TextView textNationality;
    private ImageView imageView;

    private ArrayList<JSONObject> Characters;
    private ArrayList<JSONObject> Cloths;

    private ArrayList<Character> characterArrayList;
    private ArrayList<Cloth> clothArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.text_name);
        textAge = findViewById(R.id.text_age);
        textGender = findViewById(R.id.text_gender);
        textBirth = findViewById(R.id.text_birth);
        textNationality = findViewById(R.id.text_nationality);
        imageView = findViewById(R.id.image_view);

        OkHttpClient client = new OkHttpClient();
        String url = "https://saint-seiya-api.herokuapp.com/api/characters/";
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onFailure(Call call, IOException e) {
                                                e.printStackTrace();
                                            }

                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                if (response.isSuccessful()) {
                                                    final String myResponse = response.body().string();

                                                    MainActivity.this.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            try {
                                                                //JSONObject mainObject = new JSONObject(myResponse);
                                                                Characters = new ArrayList<JSONObject>();
                                                                JSONArray jsonArray = new JSONArray(myResponse);
                                                                JSONObject obj1 = new JSONObject();
                                                                for (int i = 0; i < jsonArray.length(); i++) {
                                                                    obj1 = jsonArray.getJSONObject(i);
                                                                    Characters.add(obj1);
                                                                }

                                                                characterArrayList = new ArrayList<>();

                                                                for (JSONObject character : Characters) {
                                                                    int id = character.getInt("id");
                                                                    String name = character.getString("name");
                                                                    String age = character.getString("age");
                                                                    String gender = character.getString("gender");
                                                                    String birth = character.getString("birth");
                                                                    String weight = character.getString("weight");
                                                                    String nationality = character.getString("nationality");
                                                                    String training = character.getString("training");
                                                                    String height = character.getString("height");
                                                                    String blood = character.getString("blood");
                                                                    JSONArray masterArray = character.getJSONArray("master");
                                                                    String[] master = new String[masterArray.length()];
                                                                    for (int i = 0; i < masterArray.length(); i++) {
                                                                        master[i] = masterArray.getJSONObject(i).getString("name");
                                                                    }
                                                                    JSONArray apprenticeArray = character.getJSONArray("apprentice");
                                                                    String[] apprentice = new String[apprenticeArray.length()];
                                                                    for (int i = 0; i < apprenticeArray.length(); i++) {
                                                                        apprentice[i] = apprenticeArray.getJSONObject(i).getString("name");
                                                                    }
                                                                    JSONArray attackArray = character.getJSONArray("attacks");
                                                                    String[] attack = new String[attackArray.length()];
                                                                    if (attackArray.length() != 0) {
                                                                        for (int i = 0; i < attackArray.length(); i++) {
                                                                            attack[i] = attackArray.getString(i);
                                                                        }
                                                                    }
                                                                    String image = character.getString("image");

                                                                    JSONArray clothArray = character.getJSONArray("cloths");
                                                                    JSONObject objCloth = new JSONObject();
                                                                    Cloths = new ArrayList<>();
                                                                    for (int i = 0; i < clothArray.length(); i++) {
                                                                        objCloth = clothArray.getJSONObject(i);
                                                                        Cloths.add(objCloth);
                                                                    }

                                                                    clothArrayList = new ArrayList<>();

                                                                    for (JSONObject c : Cloths) {
                                                                        String rankCloth = c.getString("rank");

                                                                            int idCloth = c.getInt("id");
                                                                            String clothCloth = c.getString("cloth");
                                                                            String classCloth = c.getString("class");
                                                                            String affiliationCloth = c.getString("affiliation");
                                                                            String imageCloth = c.getString("image");
                                                                            String symbolCloth = c.getString("symbol");
                                                                            Cloth cloth = new Cloth(idCloth, classCloth, rankCloth, affiliationCloth, imageCloth, clothCloth, symbolCloth);
                                                                            clothArrayList.add(cloth);

                                                                    }
                                                                    Character character1 = new Character(id, name, age, gender, nationality, training, height, blood, master, apprentice, attack, image, clothArrayList, birth, weight);
                                                                    characterArrayList.add(character1);


//                                                                    Log.i("Name: ", name);
//                                                                    Log.i("age: ", age);
//                                                                    Log.i("gender: ", gender);
//                                                                    Log.i("nationality: ", nationality);

                                                                }
                                                                Character char1 = characterArrayList.get(10);

                                                                textAge.setText("Age: " + char1.getAge());
                                                                textName.setText("Name: " + char1.getName());
                                                                textGender.setText("Gender: " + char1.getGender());
                                                                textBirth.setText("Birth: " + char1.getBirth());
                                                                textNationality.setText("Nationality: " + char1.getNationality());
                                                                String URL = "https://raw.githubusercontent.com/diegochagas/saint-seiya-api/master/frontend/src/" + char1.getImage();
                                                                Log.i("URL: ", URL);
                                                                Picasso.get().load(URL).into(imageView);

                                                            } catch (JSONException e) {
                                                                Log.e("CDZApp", "unexpected JSON Exception", e);
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        }

        );

    }

    public void changeView(View view) {
        Intent intent = new Intent(this, ViewList.class);
        startActivity(intent);
    }
}