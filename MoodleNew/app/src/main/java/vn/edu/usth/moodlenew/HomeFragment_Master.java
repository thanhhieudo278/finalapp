package vn.edu.usth.moodlenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment_Master extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment_master);
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
            Intent myIntent = new Intent(HomeFragment_Master.this, SettingsActivity.class);
            HomeFragment_Master.this.startActivity(myIntent);
            Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.notification) {
            Intent myIntent = new Intent(HomeFragment_Master.this, NotificationActivity.class);
            HomeFragment_Master.this.startActivity(myIntent);
            Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}