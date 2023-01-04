package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    static final int ALARM_REQ_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText=findViewById(R.id.set_time);
        btn=findViewById(R.id.btn);
        AlarmManager alarm=(AlarmManager) getSystemService(ALARM_SERVICE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        int time=Integer.parseInt(((EditText)(findViewById(R.id.set_time))).getText().toString());
        long triggerTime=System.currentTimeMillis()+(time*1000);

                Intent intent=new Intent(MainActivity.this,Receiver.class);
        PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_CODE,intent,0);
        alarm.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);


            }
        });
    }
}