package com.hly.network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/4/9~~~~~~
 * ~~~~~~更改时间:2019/4/9~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class HttpUrlConnectionActivity extends AppCompatActivity implements View.OnClickListener {

   private static EditText phone;
   private static EditText pw;
   private TextView login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpurl_connection_layout);
        phone = findViewById(R.id.login_phone_edt);
        pw = findViewById(R.id.login_pw_edt);
        login =findViewById(R.id.login_text);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_text:
                new MyTask().execute();
                break;
        }
    }
  static  class MyTask extends AsyncTask<Void,Void,String>{
      @Override
      protected String doInBackground(Void... voids){
           String result =  login_net();
          return result;
      }
      @Override
      protected void onPostExecute(String s) {
          Log.e("xyj","-----------------------------------"+s);
          super.onPostExecute(s);
      }

      public String login_net() {
          String phone1 = phone.getText().toString().trim();
          String pw1= pw.getText().toString().trim();
          HttpURLConnection connection = null;
          InputStream is = null;
          try {
              URL url = new URL("http://192.168.1.252/ne/customer/login?account="+phone1+"&pwd="+pw1+"&accountType=android");
              //获得URL对象
              connection = (HttpURLConnection) url.openConnection();
              //获得HttpURLConnection对象
              connection.setRequestMethod("GET");
//              connection.setRequestMethod("POST");
              // 默认为GET
              connection.setUseCaches(false);
              //不使用缓存
              connection.setConnectTimeout(10000);
              //设置超时时间
              connection.setReadTimeout(10000);
              //设置读取超时时间
              connection.setDoInput(true);
              //设置是否从httpUrlConnection读入，默认情况下是true;
              if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                  //相应码是否为200
                  is = connection.getInputStream();
                  //获得输入流
                  BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                  //包装字节流为字符流
                  StringBuilder response = new StringBuilder();
                  String line;
                  while ((line = reader.readLine()) != null) {
                      response.append(line);
                  }
                  return response.toString();
              }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if (connection != null) {
                  connection.disconnect();
                  connection = null;
              }
              if (is != null) {
                  try {
                      is.close();
                      is = null;
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
          return null;
      }


      public static void readContentFromPost() throws IOException {
          String phone1 = phone.getText().toString().trim();
          String pw1= pw.getText().toString().trim();

          // Post请求的url，与get不同的是不需要带参数
          URL postUrl = new URL("http://192.168.1.252/ne/customer/login");
          // 打开连接
          HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
          // 设置是否向connection输出，因为这个是post请求，参数要放在
          // http正文内，因此需要设为true
          connection.setDoOutput(true);
          // Read from the connection. Default is true.
          connection.setDoInput(true);
          // 默认是 GET方式
          connection.setRequestMethod("POST");
          // Post 请求不能使用缓存
          connection.setUseCaches(false);
          //设置本次连接是否自动重定向
          connection.setInstanceFollowRedirects(true);
          // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
          // 意思是正文是urlencoded编码过的form参数
          connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
          // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
          // 要注意的是connection.getOutputStream会隐含的进行connect。
          connection.connect();
          DataOutputStream out = new DataOutputStream(connection
                  .getOutputStream());
          // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
          String content = "account="+phone1+"&pwd="+pw1+"&accountType="+"android";
          // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
          out.writeBytes(content);
          //流用完记得关
          out.flush();
          out.close();
          //获取响应
          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          String line;
          while ((line = reader.readLine()) != null){
              System.out.println(line);
          }
          reader.close();
          //该干的都干完了,记得把连接断了
          connection.disconnect();
      }






  }
}
