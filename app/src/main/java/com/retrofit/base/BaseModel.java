package com.retrofit.base;




/**
 * model层的基类
 */
public class BaseModel<P extends BasePresenter> {
    protected P presneter;
    public BaseModel(P presneter){
        this.presneter = presneter;
    }
}
