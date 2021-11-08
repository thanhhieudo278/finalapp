package vn.edu.usth.moodlenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyCoursesFragment_MobileAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_app);

        //create RecyclerView.
        final RecyclerView rvApp = (RecyclerView) findViewById(R.id.rv_app);
        rvApp.setLayoutManager(new LinearLayoutManager(this));

        //create OkHttpClient to get data
        OkHttpClient client = new OkHttpClient();

        //create Moshi adapter to convert json to model java (User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, User.class);
        final JsonAdapter<List<User>> jsonAdapter = moshi.adapter(usersType);

        //request to server.
        Request request = new Request.Builder()
                .url("https://61878daa057b9b00177f99fc.mockapi.io/Courses")
                .build();
        //do the request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //get api from JSON
                String json = response.body().string();
                final List<User> users = jsonAdapter.fromJson(json);

                //display on RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvApp.setAdapter(new UserAdapter(users, MyCoursesFragment_MobileAppActivity.this));
                    }
                });
            }
        });
        //initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected


        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu:
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.search) {
            Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.setting) {
            Intent myIntent = new Intent(MyCoursesFragment_MobileAppActivity.this, SettingsActivity.class);
            MyCoursesFragment_MobileAppActivity.this.startActivity(myIntent);
            Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.notification) {
            Intent myIntent = new Intent(MyCoursesFragment_MobileAppActivity.this, NotificationActivity.class);
            MyCoursesFragment_MobileAppActivity.this.startActivity(myIntent);
            Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}