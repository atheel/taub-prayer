package com.example.atheel.prayer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class EmptyStatus extends ActionBarActivity {
    enums.PrayerName curPrayer;
    enums.PrayerName nextPrayer;
    TextView text_curPrayer;
    TextView text_nextPrayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_status);
        curPrayer=enums.PrayerName.Fajir;
        nextPrayer=enums.PrayerName.Thuhur;
        text_curPrayer = (TextView) findViewById(R.id.textView_curPrayerName);
        text_nextPrayer = (TextView) findViewById(R.id.textView_nextPrayer);
    }

    @Override
    protected void onResume() {
        updateCurPrayer(curPrayer);
        updateNextPrayer(nextPrayer);
        updateTextViewCur();
        updateTextViewNext();

    }

    protected void updateCurPrayer(enums.PrayerName prayer) {
        //TODO prayer(enum)= getPrayer from site...
    }
    protected void updateNextPrayer(enums.PrayerName prayer) {
        //TODO prayer(enum)= getPrayer from site...
    }
    protected void updateTextViewCur() {
        switch (curPrayer) {
            case Fajir:
                text_curPrayer.setText(R.string.Al_Fajir);
                break;
            case Thuhur:
                text_curPrayer.setText(R.string.Al_Thuhur);
                break;
            case Asir:
                text_curPrayer.setText(R.string.Al_Asir);
                break;
            case Maghrib:
                text_curPrayer.setText(R.string.Al_Magrib);
                break;
            case Eisha:
                text_curPrayer.setText(R.string.Al_Eishaa);
                break;
        }
    }
    protected void updateTextViewNext() {
        switch (nextPrayer) {
            case Fajir:
                text_nextPrayer.setText(R.string.Al_Fajir);
                break;
            case Thuhur:
                text_nextPrayer.setText(R.string.Al_Thuhur);
                break;
            case Asir:
                text_nextPrayer.setText(R.string.Al_Asir);
                break;
            case Maghrib:
                text_nextPrayer.setText(R.string.Al_Magrib);
                break;
            case Eisha:
                text_nextPrayer.setText(R.string.Al_Eishaa);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_empty_status, menu);
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
