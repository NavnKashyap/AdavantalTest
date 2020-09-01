package com.take.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestDTO {

    @SerializedName("serial_number")
    @Expose
    private String serial_number;
    @SerializedName("imei_number")
    @Expose
    private String imei_number;
    @SerializedName("type_name")
    @Expose
    private String type_name;
    @SerializedName("android_id")
    @Expose
    private String android_id;
    @SerializedName("type")
    @Expose
    private String type;


    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getImei_number() {
        return imei_number;
    }

    public void setImei_number(String imei_number) {
        this.imei_number = imei_number;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
