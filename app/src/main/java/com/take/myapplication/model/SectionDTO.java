package com.take.myapplication.model;

import java.io.Serializable;

public class SectionDTO implements Serializable {
       String    title="";
       String    id="";
       String    normal_range="";
       String    value_type="";
       String    description="";
       String    unit="";
       String    symbol="";
       String    value_1="";
       String    value_2="";
       String    note="";
       String    task_status="";
       String    inner_content_id="";


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNormal_range() {
        return normal_range;
    }

    public void setNormal_range(String normal_range) {
        this.normal_range = normal_range;
    }

    public String getValue_type() {
        return value_type;
    }

    public void setValue_type(String value_type) {
        this.value_type = value_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getValue_1() {
        return value_1;
    }

    public void setValue_1(String value_1) {
        this.value_1 = value_1;
    }

    public String getValue_2() {
        return value_2;
    }

    public void setValue_2(String value_2) {
        this.value_2 = value_2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public String getInner_content_id() {
        return inner_content_id;
    }

    public void setInner_content_id(String inner_content_id) {
        this.inner_content_id = inner_content_id;
    }
}
