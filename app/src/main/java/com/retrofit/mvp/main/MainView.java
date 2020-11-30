package com.retrofit.mvp.main;

import com.retrofit.base.BaseView;
import com.retrofit.model.response.User;

public interface MainView extends BaseView {
    void onLoginSuccessListener(User user);
    void onLoginFailListener(String errorMessage);
}
