package com.sherry.testcase;


import java.util.Observable;

/**
 * Created by zxin on 17/1/3.
 */
public class DataInfo extends Observable{
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
        this.setChanged();
        this.notifyObservers();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
