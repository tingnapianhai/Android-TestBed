package com.tingapianhai.android.testbed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tingapianhai.android.testbed.actionbarmenuitem.MyActionBarActivity;
import com.tingapianhai.android.testbed.myitemrecyclerview.DummyContent;
import com.tingapianhai.android.testbed.myitemrecyclerview.MyItemRecyclerViewFragment;
import com.tingapianhai.android.testbed.myswiperefreshlayout.MySwipeRefreshLayoutFragment;
import com.tingapianhai.android.testbed.picasso.PicassoActivity;
import com.tingapianhai.android.testbed.regex.RegexActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MyItemRecyclerViewFragment.OnMyItemRecyclerViewListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // ********************** //
        //startMyItemRecyclerViewListFragment();

        //startMySwipeRefreshLayoutFragment();
        // ********************** //
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_openactivity: {
                //start MyActionBarActivity
                this.startActivity(new Intent(this, MyActionBarActivity.class));
                return true;
            }
            case R.id.action_open_regexactivity: {
                //start RegexActivity
                this.startActivity(new Intent(this, RegexActivity.class));
                return true;
            }
            case R.id.action_open_picassoactivity: {
                this.startActivity(new Intent(this, PicassoActivity.class));
                return true;
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // ***** ***** ***** //

    /**
     * interface-method definition for MyItemRecyclerViewFragment, for Fragment Communication
     *
     * @param item
     */
    @Override
    public void onMyItemRecyclerViewListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, "" + item.id + " is clicked", Toast.LENGTH_SHORT).show();
    }

    public void startMyItemRecyclerViewListFragment() {
        Fragment fragment = new MyItemRecyclerViewFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_fragment, fragment).commit();
    }

    // ***** ***** ***** //
    public void startMySwipeRefreshLayoutFragment() {
        Fragment fragment = new MySwipeRefreshLayoutFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_fragment, fragment).commit();
    }
}
