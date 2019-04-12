package com.hly.network.retrofit_okhttp;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessAndFaultListener {
    void onSuccess(String result);
    void onFault(String errorMsg);
}
