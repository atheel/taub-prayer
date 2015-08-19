package com.example.atheel.prayer;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;


import com.example.atheel.prayer.enums.Gender;

import static com.example.atheel.prayer.enums.Gender.*;
import static com.example.atheel.prayer.enums.PrayerName.Fajir;

public class UnEmpty extends ActionBarActivity {
    TextView  text_gender;
    TextView text_opened;
    TextView text_period;
    Switch switch_notify;
    enums.Gender currGender;
    enums.PrayerName currPrayer;
    double timePassed;

    public class Constants {
        public static final double FajirTIMEOUT= 3;
        public static final double ThuhurTIMEOUT= 3;
        public static final double AsirTIMEOUT= 1.5;
        public static final double MaghribTIMEOUT= 1.5;
        public static final double EishaTIMEOUT= 2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_gender= (TextView) findViewById(R.id.textView_gender);
        text_opened= (TextView) findViewById(R.id.textView_opened);
        text_period= (TextView) findViewById(R.id.textView_period);
        switch_notify= (Switch) findViewById(R.id.switch_notify);
        switch_notify.setChecked(false);
        timePassed=0;
    }

    @Override
    protected void onResume(){
        updateTextViewCur();
    }

    public  void updateTextViewCur(){
        switch (currGender){
            case BOYS:  text_gender.setText("BOYS");
                break;
            case GIRLS: text_gender.setText("GIRLS");
                break;
        }
        text_opened.setText("UNLOCK");
        text_period.setText("TIME PASSED: 0");
    }
    //updating the lock status, we have to update it when timePassed >= timeOutOfPrayer
    public void LockMe() {
        text_period.setText("Time Passed:" + String.valueOf(timePassed));
        switch (currPrayer) {
            case Fajir:
                if (timePassed < Constants.FajirTIMEOUT) {
                    break;
                }
            case Thuhur:
                if (timePassed < Constants.ThuhurTIMEOUT) {
                    break;
                }

            case Asir:
                if (timePassed < Constants.AsirTIMEOUT) {
                    break;
                }
            case Maghrib:
                if (timePassed < Constants.MaghribTIMEOUT) {
                    break;
                }
            case Eisha:
                if (timePassed < Constants.EishaTIMEOUT) {
                    break;
                }
                text_opened.setText("LOCK");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
