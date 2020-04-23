package com.example.weather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;

import static io.realm.Realm.getDefaultInstance;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView main;
    private TextView humidity;
    private TextView tempi;
    private TextView speed;
    private Button start;
    private EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_TextView);
        main = findViewById(R.id.main_clear_TextView);
        humidity = findViewById(R.id.humidity_TextView);
        tempi = findViewById(R.id.temp_TextView);
        speed = findViewById(R.id.speed_TextView);
        search = findViewById(R.id.search_EditText);
        start = findViewById(R.id.start_Button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final ProgressDialog progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Loading....");
                progressDoalog.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<Response> call = service.getAllResponses(search.getText().toString());
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, final retrofit2.Response<Response> response) {
                        progressDoalog.dismiss();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Response body = response.body();
                                name.setText(String.valueOf(body.getName()));
                                main.setText(String.valueOf(body.getWeather().get(0).getMain()));
                                humidity.setText(String.valueOf(body.getMain().getHumidity()));
                                tempi.setText(String.valueOf(body.getMain().getTemp()));
                                speed.setText(String.valueOf(body.getWind().getSpeed()));

                                Realm realm = getDefaultInstance();


                                realm.beginTransaction();
                                realm.insertOrUpdate(body);
                                realm.commitTransaction();


                            }
                        });


                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });


            }

        });

    }

}
