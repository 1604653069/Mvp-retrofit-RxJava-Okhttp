package com.retrofit.mvp.main;

import android.content.Context;

import com.retrofit.base.BasePresenter;
import com.retrofit.model.request.QueryUser;
import com.retrofit.model.response.User;

public class MainPresenter extends BasePresenter<MainView,MainModel>{
    public MainPresenter(Context context, MainView view) {
        super(context, view);
    }
    public void login(QueryUser queryUser){
        this.model.login(getContext(), queryUser);
    }

    @Override
    protected MainModel getModel() {
        return new MainModel(this);
    }

    public void loginSuccess(User user){
        this.view.onLoginSuccessListener(user);
    }
    public void loginiFail(String hint){
        this.view.onLoginFailListener(hint);
    }
}
