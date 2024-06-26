package com.sh.alta7deala3zamfilna7o;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

public class homeActivity extends AppCompatActivity {
    TextView years19,years11,years12,years13,years14,years15,years16,years17,years18;
    LinearLayout l1,l2,l3;
    Animation an,an1;
    Dialog dialog;
    Button close;
    LottieAnimationView lottie;
    LottieAnimationView lottie1,lottie2;

    TextView website,facebook,youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dialog=new Dialog(this);
        dialog.setContentView(R.layout.homeactivtydialog);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
        dialog.show();
        close=dialog.findViewById(R.id.canceldialog);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              
                dialog.dismiss();

            }
        });
        youtube=findViewById(R.id.youtube);
        facebook=findViewById(R.id.facebook);
        website=findViewById(R.id.website);
        lottie=findViewById(R.id.lottie);
        lottie1=findViewById(R.id.lottie1);
        lottie2=findViewById(R.id.lottie2);
        years19=findViewById(R.id.years10);
        years11=findViewById(R.id.years11);
        years12=findViewById(R.id.years12);
        years13=findViewById(R.id.years13);
        years14=findViewById(R.id.years14);
        years15=findViewById(R.id.years15);
        years16=findViewById(R.id.years16);
        years17=findViewById(R.id.years17);
        years18=findViewById(R.id.years18);
        l1=findViewById(R.id.linearLayout1);
        l2=findViewById(R.id.linearLayout2);
        l3=findViewById(R.id.linearlayout3);

       Intent intent=getIntent();
        lottie2.setAnimation(R.raw.refresh);
        lottie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydatabase mydatabase=new Mydatabase(homeActivity.this);
                mydatabase.deleteallquestions();
                finish();
            }
        });
       String check=intent.getStringExtra("internet connection");
       switch (check){
           case "no":
            lottie.setAnimation(R.raw.noconnection);
            lottie1.setAnimation(R.raw.offline);
            break;
           case "yes":
               lottie.setAnimation(R.raw.brain);
               lottie1.setAnimation(R.raw.online);
               break;

       }
      an= AnimationUtils.loadAnimation(this,R.anim.animation);
      an.setDuration(2000);
        an1= AnimationUtils.loadAnimation(this,R.anim.animation2);
        an1.setDuration(2000);
      l1.startAnimation(an);
      l2.startAnimation(an);
      l3.startAnimation(an1);

        years19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",18);
                startActivity(intent);
            }
        });
        years11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",11);
                startActivity(intent);
            }
        });
        years12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",12);
                startActivity(intent);
            }
        });
        years13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",13);
                startActivity(intent);
            }
        });
        years14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",14);
                startActivity(intent);
            }
        });
        years15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",15);
                startActivity(intent);
            }
        });
        years16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",16);
                startActivity(intent);
            }
        });
        years17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",17);
                startActivity(intent);
            }
        });
        years18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,quizinfo.class);
                intent.putExtra("year",19);
                startActivity(intent);
            }
        });
        Animation an9=AnimationUtils.loadAnimation(this,R.anim.social_media);
        an9.setDuration(6000);
        youtube.setAnimation(an9);
                website.setAnimation(an9);
                facebook.setAnimation(an9);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCI6iERAueVFkEhrOKStFDNA"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nhwdotcom"));
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alnahw.com/"));
                startActivity(intent);
            }
        });

    }

}


