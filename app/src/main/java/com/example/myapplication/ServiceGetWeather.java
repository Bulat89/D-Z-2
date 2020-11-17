package com.example.myapplication;


import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;


public class ServiceGetWeather extends IntentService {
    ClassFragment classFragment = new ClassFragment();


    HandlerThread handlerThread = new HandlerThread("handlerTher");
    Handler handler = new Handler(handlerThread.getLooper());



    public ServiceGetWeather() {
        super("ServiceGetWeather");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
       handler.post(new Runnable() {
           @Override
           public void run() {

               AlertDialog.Builder builder = new AlertDialog.Builder(classFragment.getContext());
               builder.setTitle("Погода").setMessage(getWeather()).show();

           }
       });

       onDestroy();
    }


    int getWeather(){// метод для получения температуры
        return R.string.GetWeather;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
