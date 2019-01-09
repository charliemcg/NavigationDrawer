package com.example.charl.navigationdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerlayout = findViewById(R.id.drawerLayout);

        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);

        //Setting the clickable navigation icon in the toolbar. This will open the navigation drawer
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //Detecting clicks on the navigation drawer items
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Intent intent;
                        //Open the activity relative to the clicked item
                        if(menuItem.getItemId() == R.id.miOne){
                            intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else if(menuItem.getItemId() == R.id.miTwo){
                            intent = new Intent(MainActivity.this, ActivityTwo.class);
                            startActivity(intent);
                        }else if(menuItem.getItemId() == R.id.miThree){
                            intent = new Intent(MainActivity.this, ActivityThree.class);
                            startActivity(intent);
                        }
                        //automatically close the drawer after user makes their selection
                        drawerlayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                }
        );

    }

    //Detecting click on the navigation icon
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            //open the navigation drawer
            drawerlayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
