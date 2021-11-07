package vn.edu.usth.moodlenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //click method



        //initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

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
                        return true;

                    case R.id.menu:
                        startActivity(new Intent(getApplicationContext()
                                ,MenuActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.header);
        tabLayout.setupWithViewPager(pager);


    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 2;
        private String titles[] = new String[] { "Home", "My courses",  };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override

        public Fragment getItem(int page) {
// returns an instance of Fragment corresponding to the specified page
            switch (page) {
                case 0: return new HomeFragment();
                case 1: return new MyCoursesFragment();

            }
            return new Fragment(); // failsafe
        }
        @Override
        public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
            return titles[page];
        }
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
            Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(myIntent);
            Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()== R.id.notification) {
            Intent myIntent = new Intent(MainActivity.this, NotificationActivity.class);
            MainActivity.this.startActivity(myIntent);
            Toast.makeText(this, " Notification selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }




}