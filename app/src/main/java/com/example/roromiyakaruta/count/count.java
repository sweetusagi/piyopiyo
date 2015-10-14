package com.example.roromiyakaruta.count;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class count extends ActionBarActivity {
    TextView numberText;
    TextView text;
    int number = 0;
    ImageView eggandbird;
    int intnkun = 0;
    int daycount;
    int count = 0;
    private TextView counter_text;
    private Button push_btn;
    int date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        eggandbird = (ImageView) findViewById(R.id.imageView5);
        number = 0;
        numberText = (TextView) findViewById(R.id.textView3);
        numberText.setText(number + "");

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.monthDay;

        SharedPreferences dateload = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        if(date != dateload.getInt("dateSave", 0)){
            daycount = 0;
        }

        SharedPreferences date2 = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor dateeditor = date2.edit();
        dateeditor.putInt("dateSave", date);
        dateeditor.apply();


        SharedPreferences numberload = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        number = numberload.getInt("numberSave", 0);

        // 追加：画面のアイテムと紐付け
        counter_text = (TextView)findViewById(R.id.textView4);


        SharedPreferences daycount = getSharedPreferences("dataSave", Context.MODE_PRIVATE);
        number = daycount.getInt("daycountSave", 0);



        counter_text.setText(String.valueOf(count));

 SharedPreferences countload = getSharedPreferences("dateSave", Context.MODE_PRIVATE);
        number = countload.getInt("countSave", 0);

    }
    public void eggcount(View v){
        if(daycount<10) {            count++;
            daycount++;
            counter_text.setText(String.valueOf(count));

            if(count>=100){
                eggandbird.setImageResource(R.drawable.hiyoko2);
            }


            SharedPreferences daycount2 = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            SharedPreferences.Editor daycounteditor = daycount2.edit();
            daycounteditor.putInt("daycountSave", daycount);
            daycounteditor.apply();

            SharedPreferences count2 = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            SharedPreferences.Editor counteditor = count2.edit();
            counteditor.putInt("countSave", count);
            counteditor.apply();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_count, menu);
        return true;
    }

    public void shop(View v){
        Intent intent = new Intent(this, shopcount.class);
        startActivity(intent);
    }
    public void egg(View v){
        Intent intent = new Intent(this, shopcount.class);
        startActivity(intent);
    }

    public void sent(View v){

        if(intnkun == 2){
            number+=15;
            numberText.setText(number + "");
            eggandbird.setVisibility(View.INVISIBLE);

            SharedPreferences numbersave = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            SharedPreferences.Editor numbereditor = numbersave.edit();
            numbereditor.putInt("numberSave", number);
            numbereditor.apply();






        }

        intnkun = 0;

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
