package com.example.testingapp.sqlite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MyUtil {

    //yes no 알림창
    public static void showConfirmDialog(Context context, String title , String message, final Handler handler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(handler!=null){
                            handler.sendEmptyMessage(1);
                        }
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(handler!=null){
                            handler.sendEmptyMessage(1);
                        }
                        dialog.cancel();
                    }
                });

        AlertDialog dalog = builder.create();
        dalog.show();

    }

    //닫기 창
    public static void showMessageDialog(Context context, String title, String message, final Handler handler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title).setMessage(message).setCancelable(false).setPositiveButton("Close",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //키패드 내리기
    public static void hideKeypad(Context context, View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}
