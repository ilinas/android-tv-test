package com.trifork.android.tv.test.androidtvtest.custom;

import java.io.Serializable;

public class Device implements Serializable {

    private String name;
    private Integer minVal;
    private Integer maxVal;
    private Integer value;
    private int imageId;

    public Device(String name, Integer minVal, Integer maxVal, Integer value, int imageId) {
        this.name = name;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.value = value;
        this.imageId = imageId;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
