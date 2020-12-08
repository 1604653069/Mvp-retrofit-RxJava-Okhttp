package com.retrofit.ui;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.retrofit.R;
import com.retrofit.base.BaseActivity;
import com.retrofit.model.Address;
import com.retrofit.model.Person;
import com.retrofit.model.request.QueryUser;
import com.retrofit.model.response.User;
import com.retrofit.mvp.main.MainPresenter;
import com.retrofit.mvp.main.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.edit)
    EditText edit;

    @Override
    protected void onResume() {
        super.onResume();
        if(!presenter.isBindView())
            presenter.bindView(this);
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void doSomething() {
        presenter.login(new QueryUser("333", "123456zxA"));
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onLoginSuccessListener(User user) {
        tvTest.setText(user.toString());
    }

    @Override
    public void onLoginFailListener(String errorMessage) {
        T(this, errorMessage);
    }
}