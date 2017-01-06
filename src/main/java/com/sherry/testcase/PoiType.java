package com.sherry.testcase;

/**
 * Created by zxin on 16/12/29.
 */
public enum PoiType {
    POI_UNKNOWN(0,"未知"),POI_EAT(1,"美食"),POI_HOTEL(2,"酒店"),POI_SCENERY(3,"景点"),POI_SHOPPING(4,"购物"),POI_ENTERTAINMENT(5,"娱乐"),POI_TRAFFIC(6,"交通"),POI_MERCHANT(7,"商户");

    private int index;

    private String name;

    private PoiType(int index,String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
