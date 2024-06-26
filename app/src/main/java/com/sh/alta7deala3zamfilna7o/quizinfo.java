package com.sh.alta7deala3zamfilna7o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class quizinfo extends AppCompatActivity {

    Button start;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizinfo);
        age=getIntent().getIntExtra("year",0);
        start=findViewById(R.id.play);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send age to the next activity
                Intent intent=new Intent(quizinfo.this, quiz_rules.class);
                intent.putExtra("year",age);
                intent.putExtra("tolevel","one");
                startActivity(intent);

            }
        });
    }

}