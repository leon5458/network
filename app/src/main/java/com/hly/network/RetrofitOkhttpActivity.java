package com.hly.network;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hly.network.retrofit_okhttp.LoginApi;
import com.hly.network.retrofit_okhttp.OnSuccessAndFaultListener;
import com.hly.network.retrofit_okhttp.OnSuccessAndFaultSub;

import java.util.HashMap;
import java.util.Map;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/4/12~~~~~~
 * ~~~~~~更改时间:2019/4/12~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class RetrofitOkhttpActivity extends AppCompatActivity {

    private TextView login_phone_edt;
    private TextView login_pw_edt;
    private TextView login_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpurl_connection_layout);

        login_phone_edt =findViewById(R.id.login_phone_edt);
        login_pw_edt = findViewById(R.id.login_pw_edt);
        login_text = findViewById(R.id.login_text);

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pullnet();
            }
        });
    }

    private void pullnet(){
        String phone =login_phone_edt.getText().toString().trim();
        String pw =login_pw_edt.getText().toString().trim();
        String type="android";
//         query
//         LoginApi.getLoginDataForQuery(phone,pw,type,new OnSuccessAndFaultSub(new OnSuccessAndFaultListener() {
//             @Override
//             public void onSuccess(String result) {
//                 Toast.makeText(RetrofitOkhttpActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
//             }
//
//             @Override
//             public void onFault(String errorMsg) {
//                 Toast.makeText(RetrofitOkhttpActivity.this,errorMsg , Toast.LENGTH_SHORT).show();
//             }
//         }));

        Map<String,String> map = new HashMap<>();
        map.put("account",phone);
        map.put("pwd",pw);
        map.put("android","android");
//     querymap
        LoginApi.getLoginDataForMap(map,new OnSuccessAndFaultSub(new OnSuccessAndFaultListener() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(RetrofitOkhttpActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFault(String errorMsg) {
                Toast.makeText(RetrofitOkhttpActivity.this,errorMsg , Toast.LENGTH_SHORT).show();
            }
        }));


    }
}
