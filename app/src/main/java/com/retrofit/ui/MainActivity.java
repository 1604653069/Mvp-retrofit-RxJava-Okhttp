package com.retrofit.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.retrofit.R;
import com.retrofit.base.BaseActivity;
import com.retrofit.model.request.QuestUser;
import com.retrofit.model.response.User;
import com.retrofit.mvp.main.MainPresenter;
import com.retrofit.mvp.main.MainView;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test)
    Button btnTest;
    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void doSomething() {
        presenter.login(new QuestUser("333","123456zxA"));
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }

    @OnClick({R.id.btn_test})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_test:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onLoginSuccessListener(User user) {
        tvTest.setText(user.toString());
    }

    @Override
    public void onLoginFailListener(String errorMessage) {
        T(this,errorMessage);
    }
}