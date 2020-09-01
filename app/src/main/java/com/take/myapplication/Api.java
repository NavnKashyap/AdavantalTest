package com.take.myapplication;

import com.take.myapplication.model.DataDTO;
import com.take.myapplication.model.RequestDTO;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface Api {

    String BASE_URL = "http://35.237.168.75:3002/nurse/";

    @POST("getActionContentByDevice")
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    Call<ResponseBody> savePost(@Body RequestDTO requestDTO);
}
