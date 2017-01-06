package com.sherry.testcase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxin on 17/1/3.
 */
public class ListInfo {
    private List<DataInfo> dataList = new ArrayList<DataInfo>();
    private String pKey;
    private String pValue;

    public List<DataInfo> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataInfo> dataList) {
        this.dataList = dataList;
    }

    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    public String getpValue() {
        return pValue;
    }

    public void setpValue(String pValue) {
        this.pValue = pValue;
    }
}
