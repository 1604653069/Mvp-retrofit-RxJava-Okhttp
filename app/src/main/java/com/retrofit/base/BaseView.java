package com.retrofit.base;

/**
 * 基础数据返回接口
 */
public interface BaseView {
    /**
     * 显示等待对话框
     */
    void showDialog();

    /**
     * 隐藏对话框
     */
    void dissDialog();

    /**
     * 成功
     */
    void onSuccess();

    /**
     * 失败
     */
    void onFail();
}
