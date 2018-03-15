package interview.handimaps.thuanvoapp;

// import libraries for the project
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/*
 * Main class that handles all fragments
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // instance variable
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // default code generated by Android Studio
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer layout
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Set HomeFragment as default display
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new HomeFragment();
        ft.replace(R.id.content, fragment);
        ft.commit();

        // Navigation Action
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // call fragment menu if they are chosen from navigation viewer
                selectFragment(item);
                return false;
            }
        });

        BottomNavigationView mBottomNav = findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // call fragment menu if they are chosen from bottom navigation
                selectFragment(item);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        selectFragment(item);
        return true;
    }

    /*
     *  A class that handles all fragment selected
     */
    private void selectFragment(MenuItem item) {
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();

        // fragment will be replaced every time user choose another one
        if (id == R.id.home) {
            fragment = new HomeFragment(); //home
        } else if (id == R.id.resume) {
            fragment = new ResumeFragment(); //resume
        }  else if (id == R.id.link) {
            fragment = new LinkedInFragment(); //linkedIn profile
        }
        else if (id == R.id.git) {
            fragment = new GitFragment(); //GitHub profile
        }
        else if (id == R.id.feedback) {
            fragment = new FeedbackFragment(); // User Feedback
        }
        else if (id == R.id.cover) {
            fragment = new CoverLetterFragment();  //Cover Letter display
        }
        else if (id == R.id.project) {
            fragment = new OverviewFragment();  // Project Overview
        }

        // set up for all fragments
        if (fragment!= null) {
            fm.popBackStack(fragment.getClass().getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.addToBackStack(fragment.getClass().getSimpleName());
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

}