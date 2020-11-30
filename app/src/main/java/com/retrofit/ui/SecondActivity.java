package com.retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.retrofit.R;
import com.retrofit.call.RunCall;
import com.retrofit.call.RunCallManager;

import java.lang.ref.WeakReference;

public class SecondActivity extends AppCompatActivity {
    private  RunCallManager runCallManager;
    private boolean flag;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.btn_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
        runCallManager = RunCallManager.getInstance(this);
        runCallManager.setRunCall(new RunCallListener(this));

    }
     static class RunCallListener implements RunCall{
        private WeakReference<Activity> weakReference;
        private Activity activity;
        public RunCallListener(Activity activity){
            weakReference = new WeakReference<Activity>(activity);
            this.activity = activity;
        }
        @Override
        public void runBackCall() {

        }
    }
}