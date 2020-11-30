package com.retrofit.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import butterknife.ButterKnife;

/**
 * activity基类
 * @param <P>
 */
public abstract class BaseActivity<P extends BasePresenter>  extends RxAppCompatActivity implements BaseView {
    public P presenter;
    private ProgressDialog progressDialog;
    private Toast toast;
    private boolean isFullScreen =true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isShowFullScreen();
        setContentView(getLayoutId());
        presenter = getPresenter();
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        doSomething();
    }
    /**
     * 实例化Presenter
     * @return
     */
    protected abstract P getPresenter();

    /**
     * 获取布局Id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 业务处理
     */
    protected abstract void doSomething();
    /**
     * 显示对话框
     */
    @Override
    public void showDialog() {
        progressDialog.show();
    }

    /**
     * 隐藏对话框
     */
    @Override
    public void dissDialog() {
        progressDialog.dismiss();
    }

    /**
     * 全屏显示，状态栏会消失
     */
    protected void hideToolBar(){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 状态栏透明
     */
    protected void makeStatusBarTransparent() {
        hideActionBar();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    /**
     * 隐藏actionBar
     */
    protected void hideActionBar(){
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }
    protected void T(Context context, String message){
        if(toast==null)
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        else
            toast.setText(message);
        toast.show();
    }

    /**
     * 是否全屏
     */
    private void isShowFullScreen(){
        if(isFullScreen)
            hideToolBar();
        else
            makeStatusBarTransparent();
    }

    /**
     * 是否是全屏
     * @return
     */
    public boolean isFullScreen() {
        return isFullScreen;
    }

    /**
     * 设置全屏
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
    }
}
