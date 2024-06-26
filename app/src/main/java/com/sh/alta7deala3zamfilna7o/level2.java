package com.sh.alta7deala3zamfilna7o;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class level2  extends AppCompatActivity {
    int age;
    TextView tvquestion,reponse1,reponse2,reponse3,reponse4,dialog_title,dialog_description;
    ArrayList<questionform>Questions;
    int LOW = 1;
    Animation an1,an2;
    int i;
    int onbackpressed;
    int random_integer;
    int random_integer1;
    int HIGH;
    int MARKS;
    int high;
    int low=1;
    int qnum;
    TextView title ;
    questionform q1;
    Random rand1;
    ArrayList<String>responses;
    Dialog dialog;
    Button close_dialog;
    TextView QUESTION_NUMBER,MARK;
    Mydatabase mydatabase;
    TextView clock;
    ImageView exit;
    TextView replace_question;
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS=240000;
    private long TIME_LEFT_IN_MILLIS=START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        MARKS=getIntent().getIntExtra("MARKS",0);
        MARK=findViewById(R.id.MARK);
        MARK.setText("عدد الدرجات : "+MARKS);
        exit=findViewById(R.id.exit);
        QUESTION_NUMBER=findViewById(R.id.qnum);
        reponse1=findViewById(R.id.reponse1);
        reponse2=findViewById(R.id.reponse2);
        reponse3=findViewById(R.id.reponse3);
        reponse4=findViewById(R.id.reponse4);
        tvquestion=findViewById(R.id.question);
        an1= AnimationUtils.loadAnimation(this,R.anim.logoanim);
        an1.setDuration(1500);
        reponse1.setAnimation(an1);
        reponse2.setAnimation(an1);
        reponse3.setAnimation(an1);
        reponse4.setAnimation(an1);
        an2=AnimationUtils.loadAnimation(this,R.anim.animation);
        an2.setDuration(1500);
        tvquestion.setAnimation(an2);
        title=findViewById(R.id.titlelevel);
        title.setText(" المرحلة الثّانية  ");

        //timer
        clock=findViewById(R.id.clock);
        Thread thread=new Thread(){

            @Override
            public void run() {
                countDownTimer=new CountDownTimer(TIME_LEFT_IN_MILLIS,1000) {
                    @Override
                    public void onTick(long l) {
                        TIME_LEFT_IN_MILLIS=l;
                        int minutes=(int)(TIME_LEFT_IN_MILLIS/1000)/60;
                        int secondes=(int)(TIME_LEFT_IN_MILLIS/1000)%60;
                        String time_left=String.format(Locale.getDefault(),"%02d:%02d",minutes,secondes);
                        clock.setText(time_left);
                    }

                    @Override
                    public void onFinish() {
                        Intent intent =new Intent(level2.this,loserorwinner.class);
                        intent.putExtra("check","timeout");
                        intent.putExtra("year",age);
                        startActivity(intent);
                        finish();
                    }
                }.start();
                super.run();
            }
        }; thread.run();


        replace_question=findViewById(R.id.remove);
        replace_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MARKS--;
                MARK.setText("عدد الدرجات : "+MARKS);
                qnum--;
                getquestion();
                replace_question.setVisibility(View.INVISIBLE);
            }
        });


        age=getIntent().getIntExtra("year",0);
        Questions=new ArrayList<>();
        mydatabase=new Mydatabase(level2.this);

        if (age >=11&&age <=19){

            Questions= mydatabase.getquestionwhereageequalto(age);
            switch (age){
                case 11:

                    break;

                case 12:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(11));
                    break;
                case 13:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(11));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(12));
                    break;
                case 14:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    break;
                case 15:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                    break;
                case 16:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                    break;
                case 17:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                    break;
                case 18:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(17));
                    break;
                case 19:
                    Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(17));
                    Questions.addAll(mydatabase.getquestionwhereageequalto(18));
                    break;

            }

            mydatabase.delete();

            if((Questions.size())>0) {

                getquestion();

            }

        }


        reponse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse1.getText().toString()).equals(q1.getCorrectresponse())){
                    MARKS++;
                     MARK.setText("عدد الدرجات : "+MARKS);
                    Toast.makeText(level2.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level2.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                dialog=new Dialog(level2.this);
                dialog.setContentView(R.layout.customdialog);
                close_dialog=dialog.findViewById(R.id.canceldialog);close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                            reponse1.setVisibility(View.VISIBLE);
                            reponse2.setVisibility(View.VISIBLE);
                            reponse3.setVisibility(View.VISIBLE);
                        }else if (MARKS>=17){
                            Intent intent=new Intent(level2.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("tolevel","three");
                            countDownTimer.cancel();
                            intent.putExtra("MARKS",MARKS);
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                        }


                        else{ Intent intent=new Intent(level2.this, homeActivity.class);
                            intent.putExtra("year",age);
                            Toast.makeText(level2.this, "لقد خسرت علامتك أقل 8 على 10 حاول مرة أخرى", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                dialog_title=dialog.findViewById(R.id.titled);
                dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });


        reponse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse2.getText().toString()).equals(q1.getCorrectresponse())){
                    MARKS++;
                    Toast.makeText(level2.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                     MARK.setText("عدد الدرجات : "+MARKS);
                }else{
                    Toast.makeText(level2.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                dialog=new Dialog(level2.this);
                dialog.setContentView(R.layout.customdialog);
                close_dialog=dialog.findViewById(R.id.canceldialog);close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                            reponse1.setVisibility(View.VISIBLE);
                            reponse2.setVisibility(View.VISIBLE);
                            reponse3.setVisibility(View.VISIBLE);
                        }else if (MARKS>=17){
                            Intent intent=new Intent(level2.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","three");
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }


                        else{ Intent intent=new Intent(level2.this, homeActivity.class);
                            intent.putExtra("year",age);
                            Toast.makeText(level2.this, "لقد خسرت علامتك أقل 8 على 10 حاول مرة أخرى", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                dialog_title=dialog.findViewById(R.id.titled);
                dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });


        reponse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse3.getText().toString()).equals(q1.getCorrectresponse())){
                    MARKS++;
                    Toast.makeText(level2.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                     MARK.setText("عدد الدرجات : "+MARKS);
                }else{
                    Toast.makeText(level2.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                dialog=new Dialog(level2.this);
                dialog.setContentView(R.layout.customdialog);
                close_dialog=dialog.findViewById(R.id.canceldialog);close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                            reponse1.setVisibility(View.VISIBLE);
                            reponse2.setVisibility(View.VISIBLE);
                            reponse3.setVisibility(View.VISIBLE);
                        }else if (MARKS>=17){
                            Intent intent=new Intent(level2.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","three");
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }


                        else{ Intent intent=new Intent(level2.this, homeActivity.class);
                            intent.putExtra("year",age);
                            Toast.makeText(level2.this, "لقد خسرت علامتك أقل 8 على 10 حاول مرة أخرى", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                dialog_title=dialog.findViewById(R.id.titled);
                dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });


        reponse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse4.getText().toString()).equals(q1.getCorrectresponse())){
                    MARKS++;
                     MARK.setText("عدد الدرجات : "+MARKS);
                    Toast.makeText(level2.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level2.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                dialog=new Dialog(level2.this);
                dialog.setContentView(R.layout.customdialog);
                close_dialog=dialog.findViewById(R.id.canceldialog);
                dialog_title=dialog.findViewById(R.id.titled);
                dialog_description=dialog.findViewById(R.id.description);
                close_dialog=dialog.findViewById(R.id.canceldialog);close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                            reponse1.setVisibility(View.VISIBLE);
                            reponse2.setVisibility(View.VISIBLE);
                            reponse3.setVisibility(View.VISIBLE);
                        }else if (MARKS>=17){
                            Intent intent=new Intent(level2.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","three");
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }


                        else{
                            countDownTimer.cancel();
                            Intent intent=new Intent(level2.this, homeActivity.class);
                            intent.putExtra("year",age);
                            dialog.dismiss();
                            Toast.makeText(level2.this, "لقد خسرت علامتك أقل 8 على 10 حاول مرة أخرى", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(level2.this,quizinfo.class);
                intent.putExtra("year",age);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getquestion(){
        HIGH = Questions.size() ;

        Random rand = new Random();
        random_integer = rand.nextInt(HIGH - LOW) + LOW;
        q1=Questions.get(random_integer);
        Questions.remove(random_integer);
        // mydatabase.delete(q1.getQuestion());
        tvquestion.setText(q1.getQuestion());

        responses=new ArrayList<>();
        responses.add(q1.getFalse1());
        responses.add(q1.getFalse2());
        responses.add(q1.getFalse3());
        responses.add(q1.getCorrectresponse());
        do {
            high = responses.size();
            rand1 = new Random();
            random_integer1 = rand1.nextInt(high - low) + low;
            reponse1.setText(responses.get(random_integer1));
            responses.remove(random_integer1);
            high = responses.size();
            rand1 = new Random();
            random_integer1 = rand1.nextInt(high - low) + low;
            reponse2.setText(responses.get(random_integer1));
            responses.remove(random_integer1);
            high = responses.size();
            rand1 = new Random();
            random_integer1 = rand1.nextInt(high - low) + low;
            reponse3.setText(responses.get(random_integer1));
            responses.remove(random_integer1);
            high = responses.size();
            rand1 = new Random();
            // random_integer1 = rand1.nextInt(high - low) + low;
            reponse4.setText(responses.get(0));
            responses.remove(0);
        }while((responses.size())!=0);
        qnum++;
        QUESTION_NUMBER.setText(  "السؤال رقم : " + (10+qnum)  );
    }


    @Override
    public void onBackPressed() {
        if(onbackpressed>=1){
            Intent intent =new Intent(level2.this,quizinfo.class);
            intent.putExtra("year",age);
            startActivity(intent);
            finish();
        }else{ Toast.makeText(level2.this, " أنقر مرّة ثانية للخروج  ", Toast.LENGTH_SHORT).show();
            onbackpressed++;}

    }

}