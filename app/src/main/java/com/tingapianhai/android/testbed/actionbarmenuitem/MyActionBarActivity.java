package com.tingapianhai.android.testbed.actionbarmenuitem;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tingapianhai.android.testbed.R;

import org.w3c.dom.Text;

public class MyActionBarActivity extends AppCompatActivity {

    Context con;//not a good way to do this
    private ImageView badgeImageView;
    private TextView badgeTextView;
    private int badgeNumber = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        con = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_actionbar_menu_itembadge, menu);
        View menu_badge = menu.findItem(R.id.myactionbar_menu_badge_item).getActionView();
        badgeTextView = (TextView) menu_badge.findViewById(R.id.actionbar_menu_badge_textview);
        badgeImageView = (ImageView) menu_badge.findViewById(R.id.action_menu_badge_image);
        badgeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++ badgeNumber;
                setBadgeNumber(badgeNumber);
            }
        });
        //badgeImageView.setOnClickListener(new MyBadgeItemClickListener());
        return true;
    }

    /**
     * set up a.badge-item background color; b.badge-text-number
     * @param badgeNumber
     */
    private void setBadgeNumber(int badgeNumber){
        if(badgeNumber>99){
            badgeTextView.setText("99+");//if the badge-number > 99, then use 99+ instead of 104,229,375 etc..
            badgeTextView.setBackgroundColor(Color.argb(255,255,0,0));//set badge-text view background to red-color
            badgeTextView.setBackgroundResource(R.drawable.action_menu_badge_roundedsquare);
        } else if(badgeNumber>0){
            badgeTextView.setText(""+badgeNumber);
            badgeTextView.setBackgroundColor(Color.argb(255,255,0,0));//set badge-text view background to red-color
            badgeTextView.setBackgroundResource(R.drawable.action_menu_badge_roundedsquare);
        } else{
            badgeTextView.setBackgroundColor(Color.argb(0,0,0,0));//set badge-text view background to transparent
        }
    }

    /**
     * can be removed !!!
     * Badge view OnClickListener
     */
    private class MyBadgeItemClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(con,"badge clicked",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.myactionbar_menu_badge_item) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
