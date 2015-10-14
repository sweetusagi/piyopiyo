package com.example.roromiyakaruta.count;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by roromiyakaruta on 2015/06/03.
 */
public class shopcount  extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            Log.d("", "list(" + i + ") = " + list.get(i));
        }
        // シャッフル
        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            Log.d("", "list(" + i + ") = " + list.get(i));
        }
    }

    public void hiyoko(View v){


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // アラートダイアログのタイトルを設定します
        alertDialogBuilder.setTitle("１０円　たまご");
        // アラートダイアログのメッセージを設定します
        alertDialogBuilder.setMessage("購入しますか？");
        // アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setPositiveButton("はい",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        // アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setNegativeButton("キャンセル",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}