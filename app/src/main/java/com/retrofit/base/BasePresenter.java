package com.retrofit.base;

import android.content.Context;
import android.util.Log;
import android.view.View;


/**
 * p层基类
 * @param <V>
 * @param <M>
 */
public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V view;
    protected M model;
    private Context mContext;
    public BasePresenter(Context context, V view){
        this.mContext = context;
        this.view = view;
        this.model = getModel();
    }
    public void bindView(V view){
        this.view = view;
    }
    public void unBindView(){
        this.view =null;
    }
    public boolean isBindView(){
        return this.view!=null;
    }
    public Context getContext(){
        return this.mContext;
    }
    protected abstract M getModel();
}
