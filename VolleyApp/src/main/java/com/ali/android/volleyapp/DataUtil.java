package com.ali.android.volleyapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/12/11.
 */
public class DataUtil {
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private  Data data;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }




    }


