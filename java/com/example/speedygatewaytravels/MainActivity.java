package com.example.speedygatewaytravels;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

//    EditText email,password;
//    Button Register;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button notifybtn;

        notifybtn= findViewById(R.id.notify);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("My Title");
                builder.setContentTitle("Hello,Please do share our app");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat= NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());

            }
        });

        toolbar = findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView= findViewById(R.id.nav);

//        setSupportActionBar(toolbar);
//
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_comment:
                        fragmentR(new CommentFragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this,"Comment",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_explore:
                        fragmentR(new ExploreFragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this,"Explore",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_feedback:
                        fragmentR(new FeedbackFragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this,"Feedback",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }


    public void btnNext(View view) {
        Intent intent = new Intent(this,secpage.class);
        startActivity(intent);
    }

    private void fragmentR(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId();

        if(id==R.id.nav_comment){
            Intent intent= new Intent(MainActivity.this,Comment.class);
            startActivity(intent);
            return true;
        }
        else
        if(id==R.id.nav_explore){
            Intent intent= new Intent(MainActivity.this,Explore.class);
            startActivity(intent);
            return true;
        }
        else
        if(id==R.id.nav_feedback){
            Intent intent= new Intent(MainActivity.this,Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}