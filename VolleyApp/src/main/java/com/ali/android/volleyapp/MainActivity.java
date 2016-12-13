package com.ali.android.volleyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String TAG = "VolleyApp-MainActivity---";
    String jsonUri = "http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42";
    String uri = "http://qzone-music.qq.com/fcg-bin/fcg_music_fav_getinfo.fcg?dirinfo=0&dirid=1&uin=QQ%E5%8F%B7&p=0.519638272547262&g_tk=1284234856";
    String imageUri = "http://jiangsu.china.com.cn/uploadfile/2016/0318/1458253664376652.jpg";
    String xmlUri = "http://flash.weather.com.cn/wmaps/xml/china.xml";
    TextView testView;
    Button gBtn;
    Button pBtn;
    Button jsonBtn;
    Button imageBtn;
    Button imageLoadBtn;
    Button networkImageBtn;
    NetworkImageView networkImageView;
    Button xmlBtn;
    Button gsonBtn;

    ImageView imageView;
    RequestQueue requestQueue;
    Response.Listener listener;
    Response.ErrorListener errorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        initView();
        setListener();

    }

    protected void initView() {
        testView = (TextView) findViewById(R.id.responseText);
        gBtn = (Button) findViewById(R.id.stringGBtn);
        pBtn = (Button) findViewById(R.id.stringPBtn);
        jsonBtn = (Button) findViewById(R.id.jsonGBt);
        imageBtn = (Button) findViewById(R.id.imageGBt);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.b));
        imageLoadBtn = (Button) findViewById(R.id.imageLoadGBt);
        networkImageView = (NetworkImageView) findViewById(R.id.netWorkImageView);
        networkImageView.setDefaultImageResId(R.drawable.woman);
        networkImageBtn = (Button) findViewById(R.id.newworkImageGBt);
        xmlBtn = (Button) findViewById(R.id.xmlGBtn);
        gsonBtn =(Button)findViewById(R.id.GsonBtn);

    }

    protected void addRequest(RequestQueue requestQueue, int method, final String requestType) {
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        };
        if (requestType.equals("StringRequest")) {
            listener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    testView.setText(response);
                    Log.d(TAG, response);
                }
            };
            StringRequest stringRequest = new StringRequest(uri, listener, errorListener);
            if (method == Request.Method.POST) {
                stringRequest = new StringRequest(method, uri, listener, errorListener) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("params1", "value1");
                        map.put("params2", "value2");
                        return map;
                    }
                };

            }
            requestQueue.add(stringRequest);
        } else if (requestType.equals("JsonRequest")) {

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(jsonUri, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    testView.setText(jsonObject.toString());
                    Log.d(TAG, jsonObject.toString());
                }
            }, errorListener);
            requestQueue.add(jsonObjectRequest);
        } else if (requestType.equals("ImageRequest")) {
            /*
           * ImageRequest的构造函数接收六个参数，
           * 第一个参数就是图片的URL地址，这个没什么需要解释的。
           * 第二个参数是图片请求成功的回调，这里我们把返回的Bitmap参数设置到ImageView中。
           * 第三第四个参数分别用于指定允许图片最大的宽度和高度，如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，
           * 指定成0的话就表示不管图片有多大，都不会进行压缩。
           * 第五个参数用于指定图片的颜色属性，Bitmap.Config下的几个常量都可以在这里使用，
           * 其中ARGB_8888可以展示最好的颜色属性，每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大
           * 第六个参数是图片请求失败的回调，这里我们当请求失败时在ImageView中显示一张默认图片。
             */
            ImageRequest imageRequest = new ImageRequest(imageUri, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    imageView.setImageBitmap(response);
                    Log.d(TAG, "Image Success");
                }
            }, 0, 0, Bitmap.Config.RGB_565, errorListener);
            requestQueue.add(imageRequest);

        } else if (requestType.equals("ImageLoader")) {
            ImageCacheImpl imageCache = new ImageCacheImpl();
            ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView, R.drawable.load, R.drawable.b);
            imageLoader.get(imageUri, listener);
        } else if (requestType.equals("netWorkImageView")) {
            ImageLoader.ImageCache imageCache = new ImageCacheImpl();
            ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
            networkImageView.setErrorImageResId(R.drawable.load);
            networkImageView.setImageUrl(imageUri, imageLoader);
        } else if (requestType.equals("XMLRequest")) {
            XMLRequest xmlRequest = new XMLRequest(xmlUri, new Response.Listener<XmlPullParser>() {
                @Override
                public void onResponse(XmlPullParser response) {
                    try {
                        int type = response.getEventType();
                        StringBuffer sb = new StringBuffer();
                        while (type != XmlPullParser.END_DOCUMENT) {
                            if (type == XmlPullParser.START_TAG) {
                                if (response.getName().equals("city")) {
                                    sb.append("pName is " + response.getAttributeValue(0).toString());
                                }
                            }
                            try {
                                type = response.next();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        testView.setText(sb.toString());
                        Log.d(TAG, "success");
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                }
            }, errorListener);
            requestQueue.add(xmlRequest);
        }else if(requestType.equals("GsonRequest")){
            GsonRequest<DataUtil> request = new GsonRequest(method, jsonUri, DataUtil.class, new Response.Listener<DataUtil>() {
                @Override
                public void onResponse(DataUtil response) {
                    Data data = response.getData();
                    testView.setText(data.getCountry()+"---"+data.getCountry_id()+"---"+data.getIp());

                }
            }, errorListener);
            requestQueue.add(request);
        }
    }


    protected void setListener() {
        gBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.GET, "StringRequest");
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.POST, "StringRequest");
            }
        });
        jsonBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.GET, "JsonRequest");
            }
        });
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.GET, "ImageRequest");
            }
        });
        imageLoadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addRequest(requestQueue, Request.Method.GET, "ImageLoader");
            }
        });
        networkImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRequest(requestQueue, Request.Method.GET, "netWorkImageView");
            }
        });
        xmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.GET, "XMLRequest");
            }
        });
        gsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setText("");
                addRequest(requestQueue, Request.Method.GET, "GsonRequest");
            }
        });
    }
}
