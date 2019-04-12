package com.hly.network.retrofit_okhttp;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * ~~~~~~文件描述:3种方式~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/4/12~~~~~~
 * ~~~~~~更改时间:2019/4/12~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class LoginApi {

    /**
     * 获取登陆数据@Query
     */
    public static void getLoginDataForQuery(String phone, String pw,String type, DisposableObserver<ResponseBody> subscriber) {
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForQuery(phone,pw,type);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    /**
     * 获取登陆数据@QueryMap
     */
    public static void getLoginDataForMap(Map<String,String> map,DisposableObserver<ResponseBody> subscriber) {
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForMap(map);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

//    /**
//     * 获取天气数据@Body
//     */
//    public static void getLoginDataForBody(String cityName,DisposableObserver<ResponseBody> subscriber) {
//        LoginBean bean = new LoginBean();
//        bean.getData().getAccount();
//        BaseRequestBean<WeatherRequestBean> requestBean = new BaseRequestBean<>();
//        requestBean.setObj(bean);
//        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForBody(requestBean);
//        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
//    }


}
