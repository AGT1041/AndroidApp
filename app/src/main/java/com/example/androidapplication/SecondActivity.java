package com.example.androidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.google.android.material.bottomnavigation.BottomNavigationItemView;



public class SecondActivity extends AppCompatActivity {
    private TextView userName,age,fullNmae,occupation,descriptiontext;
    private Button back;
    private BottomNavigationView  bottomview;
    private String user;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bottomview= findViewById(R.id.bottom_navigation);

        bottomview.setOnNavigationItemSelectedListener(navListener);
        manager = getSupportFragmentManager();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            if (bundle.containsKey("usernames"));
            user=bundle.getString("usernames");
        }

        //userName=findViewById(R.id.loginText);
       // age=findViewById(R.id.age);
       // back=findViewById(R.id.button);
       // fullNmae=findViewById(R.id.fullName);
       // occupation=findViewById(R.id.setoccupation);
       // descriptiontext=findViewById(R.id.description);

        //if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
        //            new ProfileFragment()).commit();
       // }
        //String dUserName=getIntent().getStringExtra("usernames");
        //int userAge=getIntent().getIntExtra("age",0);
        //String userWork=getIntent().getStringExtra("work");
        //String userdescription=getIntent().getStringExtra("description");
        //String userFullname=getIntent().getStringExtra("fullname");

       /* userName.setText("username: "+dUserName);
        age.setText("age:"+userAge);
        fullNmae.setText("Name:"+userFullname);
        occupation.setText("work: " +userWork);
        descriptiontext.setText("des: " +userdescription);*/


        ProfileFragment fragment = new ProfileFragment();
        fragment.setData(new Data(user));

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, "profileFragment");
        transaction.commit();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_profile:
                            ProfileFragment fragment = new ProfileFragment();
                            fragment.setData(new Data(user));
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                            break;
                        case R.id.nav_matches:
                            SettingFragment seting = new SettingFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingFragment()).commit();
                    }

                    return true;
                }

            };

    public static class  Data {
        String user;

        Data(String user){
            this.user=user;

        }

    }
}