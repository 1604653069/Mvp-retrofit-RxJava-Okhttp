package com.retrofit.mvp.main;

import android.content.Context;

import com.retrofit.api.APIServer;
import com.retrofit.base.BaseModel;
import com.retrofit.http.RetrofitManager;
import com.retrofit.model.request.QueryUser;
import com.retrofit.model.response.User;
import com.retrofit.rxjava.BaseObserver;
import com.retrofit.rxjava.RxHelper;

public class MainModel extends BaseModel<MainPresenter> {

    public MainModel(MainPresenter presneter) {
        super(presneter);
    }

    public void login(Context context, QueryUser queryUser){
        if(!presneter.isBindView())//如果没有绑定view就不发送请求
            return;
        RetrofitManager.getRetrofit().create(APIServer.class)
                .login(queryUser)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(new BaseObserver<User>(context) {
                    @Override
                    public void onSuccess(User user) {
                        if(presneter!=null)
                            presneter.loginSuccess(user);
                    }
                    @Override
                    public void onFailure(Throwable t, String errorMessage) {
                       if(presneter!=null)
                           presneter.loginiFail(errorMessage);
                    }
                });
    }
}
