package com.retrofit.base;

import android.content.Context;


/**
 * p层基类
 * @param <V>
 * @param <M>
 */
public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V view;
    public M model;
    private Context mContext;
    public BasePresenter(Context context, V view){
        this.mContext = context;
        this.view = view;
        this.model = getModel();
    }
    public Context getmContext(){
        return this.mContext;
    }
    protected abstract M getModel();
}
