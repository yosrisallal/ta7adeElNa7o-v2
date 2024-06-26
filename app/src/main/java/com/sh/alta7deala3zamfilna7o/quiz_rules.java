package com.sh.alta7deala3zamfilna7o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class quiz_rules extends AppCompatActivity {
    ImageView background;
    int age;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_rules);
        age=getIntent().getIntExtra("year",0);
        background=findViewById(R.id.Background);
        next=findViewById(R.id.next);
        int MARKS=getIntent().getIntExtra("MARKS",0);
        switch (getIntent().getStringExtra("tolevel")){
            case "one":
               background.setImageResource(R.drawable.editedlevel1);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level1.class);
                        intent.putExtra("year",age);
                        startActivity(intent);
                        finish();
                    }
                });
                break;
            case "two":
                background.setImageResource(R.drawable.editedlevel2);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level2.class);
                        intent.putExtra("MARKS",MARKS);
                        intent.putExtra("year",age);
                        startActivity(intent);
                        finish();
                    }
                });
                break;
            case "three":
                background.setImageResource(R.drawable.level3info);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level3.class);
                        intent.putExtra("year",age);
                        intent.putExtra("MARKS",MARKS);
                        startActivity(intent);
                        finish();
                    }
                });
                break;
        }
    }
}