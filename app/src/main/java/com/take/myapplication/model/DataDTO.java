package com.take.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataDTO  {
    @SerializedName("status")
         String status="";
    @SerializedName("success")
         String success="";
    @SerializedName("message")
         String message="";
    @SerializedName("data")
         List<NameDTO> data=null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NameDTO> getData() {
        return data;
    }

    public void setData(List<NameDTO> data) {
        this.data = data;
    }
}
