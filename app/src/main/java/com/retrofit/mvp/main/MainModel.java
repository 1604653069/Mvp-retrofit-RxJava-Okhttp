package com.retrofit.mvp.main;

import android.content.Context;
import android.widget.Toast;

import com.retrofit.api.APIServer;
import com.retrofit.base.BaseModel;
import com.retrofit.http.RetrofitManager;
import com.retrofit.model.request.QuestUser;
import com.retrofit.model.response.User;
import com.retrofit.rxjava.BaseObserver;
import com.retrofit.rxjava.RxHelper;

public class MainModel extends BaseModel {
    public void login(Context context,QuestUser questUser,OnLoginDataBackListener onLoginDataBackListener){
        RetrofitManager.getRetrofit().create(APIServer.class)
                .login(questUser)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(new BaseObserver<User>(context) {
                    @Override
                    public void onSuccess(User user) {
                        if(onLoginDataBackListener!=null)
                            onLoginDataBackListener.onLoginSuccessListener(user);
                    }
                    @Override
                    public void onFailure(Throwable t, String errorMessage) {
                        if(onLoginDataBackListener!=null)
                            onLoginDataBackListener.onLoginFailListener(errorMessage);
                    }
                });
    }
    public interface OnLoginDataBackListener{
        void onLoginSuccessListener(User user);
        void onLoginFailListener(String errorMessage);
    }
}
