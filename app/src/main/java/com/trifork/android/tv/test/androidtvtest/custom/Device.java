package com.trifork.android.tv.test.androidtvtest.custom;

import java.io.Serializable;

public class Device implements Serializable {

    private String name;
    private Integer minVal;
    private Integer maxVal;
    private Integer value;

    public Device(String name, Integer minVal, Integer maxVal, Integer value) {
        this.name = name;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinVal() {
        return minVal;
    }

    public void setMinVal(Integer minVal) {
        this.minVal = minVal;
    }

    public Integer getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Integer maxVal) {
        this.maxVal = maxVal;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
