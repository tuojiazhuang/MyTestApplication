package com.ali.android.volleyapp;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/12/12.
 */
public class VerifyGson {


    public  static void main(String args[]){
        String jsonStr = "{\"code\":0,\"data\":{\"country\":\"\\u7f8e\\u56fd\",\"country_id\":\"US\",\"area\":\"\",\"area_id\":\"\",\"region\":\"\",\"region_id\":\"\",\"city\":\"\",\"city_id\":\"\",\"county\":\"\",\"county_id\":\"\",\"isp\":\"\",\"isp_id\":\"\",\"ip\":\"63.223.108.42\"}}";
        Gson gson = new Gson();
        DataUtil dataUtil = gson.fromJson(jsonStr, DataUtil.class);
        Data data = dataUtil.getData();

        if (dataUtil != null && data != null){
            System.out.println("Output---"+dataUtil.getCode()+"++++"+data.getCountry());
        }else
            System.out.println("error");

    }
}
