package com.retrofit.call;

import android.content.Context;

public class RunCallManager {
    private RunCall runCall;
    private static RunCallManager runCallManager;
    private Context context;
    public static RunCallManager getInstance(Context context){
         if(runCallManager==null)
             runCallManager = new RunCallManager(context);
         return runCallManager;
    }
    public void setRunCall(RunCall runCall){
        this.runCall = runCall;
    }
    private RunCallManager(Context context){
        this.context = context.getApplicationContext();
    }
    public void runCallBcak(){
        if(runCall!=null)
            runCall.runBackCall();
    }
}
