package com.example.androidapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView userName,age,fullNmae,occupation,descriptiontext;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userName=findViewById(R.id.loginText);
        age=findViewById(R.id.age);
        back=findViewById(R.id.button);
        fullNmae=findViewById(R.id.fullName);
        occupation=findViewById(R.id.setoccupation);
        descriptiontext=findViewById(R.id.description);

        String dUserName=getIntent().getStringExtra("usernames");
        int userAge=getIntent().getIntExtra("age",0);
        String userWork=getIntent().getStringExtra("work");
        String userdescription=getIntent().getStringExtra("description");
        String userFullname=getIntent().getStringExtra("fullname");

        userName.setText("Hello: "+dUserName);
        age.setText("age:"+userAge);
        fullNmae.setText("Name:"+userFullname);
        occupation.setText("work: " +userWork);
        descriptiontext.setText("des: " +userdescription);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}