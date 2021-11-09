package vn.edu.usth.moodlenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout loginn = (LinearLayout)findViewById(R.id.loginn);
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick","Onclick");
                // sign out with firebase//
                FirebaseAuth.getInstance().signOut();
                Intent myIntent = new Intent(MenuActivity.this, LoginPage.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                MenuActivity.this.startActivity(myIntent);

            }
        });

        LinearLayout inforr = (LinearLayout)findViewById(R.id.inforr);
        inforr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick","Onclick");

                Intent myIntent = new Intent(MenuActivity.this, InformationClientActivity.class);
                MenuActivity.this.startActivity(myIntent);

            }
        });


        //initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.menu);

        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(),CalendarActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu:

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
            Intent myIntent = new Intent(MenuActivity.this, SettingsActivity.class);
            MenuActivity.this.startActivity(myIntent);
            Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()== R.id.notification) {
            Intent myIntent = new Intent(MenuActivity.this, NotificationActivity.class);
            MenuActivity.this.startActivity(myIntent);
            Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }











}