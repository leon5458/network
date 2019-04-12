package com.hly.network.retrofit_okhttp;
import java.util.Map;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 眼神 on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface HttpApi {
    @POST("customer/login/")
    Observable<ResponseBody> getWeatherDataForQuery(@Query("account") String phone, @Query("pwd") String pwd,@Query("android")String type);

    @POST("customer/login/")
    Observable<ResponseBody> getWeatherDataForMap(@QueryMap Map<String, String> map);

    //天气预报接口测试  @GET 不支持@Body类型
//    @POST("api")
//    Observable<ResponseBody> getWeatherDataForBody(@Body BaseRequestBean<WeatherRequestBean> requestBean);

    /**
     * 文件下载
     */
    @GET()
    @Streaming//使用Streaming 方式 Retrofit 不会一次性将ResponseBody 读取进入内存，否则文件很多容易OOM
    Call<ResponseBody> downloadFile(@Url String fileUrl);//返回值使用 ResponseBody 之后会对ResponseBody 进行读取
}
