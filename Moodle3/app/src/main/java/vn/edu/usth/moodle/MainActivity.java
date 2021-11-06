package vn.edu.usth.moodle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a new Fragment to be placed in the activity layout


        // Create a new Fragment to be placed in the activity layout



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        Log.i(TAG, "onStart");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.id.refresh) {
            Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
            }else if(item.getItemId()== R.id.search) {
                Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();
            }else if(item.getItemId()== R.id.setting) {
                Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(myIntent);
                Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
            }else if(item.getItemId()== R.id.notification) {
                Intent myIntent = new Intent(MainActivity.this, NotificationActivity.class);
                MainActivity.this.startActivity(myIntent);

                Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
            }else if(item.getItemId()== R.id.calendaract) {
                Intent myIntent = new Intent(MainActivity.this, CalendarActivity.class);
                MainActivity.this.startActivity(myIntent);

                Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
            }
        return super.onOptionsItemSelected(item);

    }

}