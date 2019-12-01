package com.example.atividade_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private ArrayList<JSONObject> Characters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.json_text_test);

        OkHttpClient client = new OkHttpClient();
        String url = "https://saint-seiya-api.herokuapp.com/api/characters";
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                //JSONObject mainObject = new JSONObject(myResponse);
                                Characters = new ArrayList<JSONObject>();
                                JSONArray jsonArray = new JSONArray(myResponse);
                                JSONObject obj1 = new JSONObject();
                                for(int i = 0; i < jsonArray.length(); i++){
                                    obj1 = jsonArray.getJSONObject(i);
                                    Characters.add(obj1);
                                }


                                for(JSONObject character : Characters) {
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
                                    if(attackArray.length() != 0){
                                        for (int i = 0; i < attackArray.length(); i++) {
                                            attack[i] = attackArray.getString(i);
                                        }
                                    }

                                    String image = character.getString("image");
                                        JSONArray cloth = character.getJSONArray("cloths");
                                    Log.i("Name: ",name);
                                    Log.i("age: ", age);
                                    Log.i("gender: ",gender);
                                    Log.i("nationality: ",nationality);

                                    textViewResult.setText(name);
                                }

                            } catch (JSONException e){
                                Log.e("CDZApp","unexpected JSON Exception", e);
                            }
                        }
                    });
                }
            }
        }

        );

    }
}
