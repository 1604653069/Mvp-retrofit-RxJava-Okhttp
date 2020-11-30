package com.retrofit.mvp.main;

import android.content.Context;

import com.retrofit.base.BasePresenter;
import com.retrofit.model.request.QuestUser;
import com.retrofit.model.response.User;

public class MainPresenter extends BasePresenter<MainView,MainModel> implements MainModel.OnLoginDataBackListener {
    private Context mContext;
    public MainPresenter(Context context, MainView view) {
        super(context, view);
        this.mContext = context;
    }
    public void login(QuestUser questUser){
        this.model.login(mContext,questUser,this);
    }
    @Override
    protected MainModel getModel() {
        return new MainModel();
    }

    @Override
    public void onLoginSuccessListener(User user) {
        this.view.onLoginSuccessListener(user);
    }

    @Override
    public void onLoginFailListener(String errorMessage) {
        this.view.onLoginFailListener(errorMessage);
    }
}
