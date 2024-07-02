package com.name.alnaho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
public class loserorwinner extends AppCompatActivity {
    TextView titlestatus,message;
    LottieAnimationView lottiestatus;
    Button returnhome;
    String checking;
    Intent ichecking;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loserorwinner);
        ichecking=getIntent();
        checking=ichecking.getStringExtra("check");
        age=getIntent().getIntExtra("year",0);
        titlestatus=findViewById(R.id.titlestatus);
        lottiestatus=findViewById(R.id.lottiestatus);
        message=findViewById(R.id.message);
        switch (checking){
            case "checked":
                titlestatus.setText("أنتَ عبقريٌّ في النَّحو ");
                lottiestatus.setAnimation(R.raw.success);
                message.setText("المسابقة انتهت .. لكنَّ التَّحدِّي مستمرٌّ");
                break;
            case"unchecked":
                titlestatus.setVisibility(View.GONE);
                lottiestatus.setVisibility(View.GONE);
                message.setVisibility(View.GONE);
                ConstraintLayout mainconstraint=findViewById(R.id.principal);
                mainconstraint.setBackgroundResource(R.drawable.loserconstraint);
                break;
            case "timeout":
                titlestatus.setText("للأسف .. انتهى الوقت!! ");
                lottiestatus.setAnimation(R.raw.timeout);
                message.setText("اهزم الوقت .. ولا تدع الوقت يهزمك في المرَّة القادمة");
                break;
        }



        returnhome=findViewById(R.id.returnhome);
        returnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(loserorwinner.this,quizinfo.class);
                intent.putExtra("year",age);
               startActivity(intent);
               finish();
            }
        });
    }
}