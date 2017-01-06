package com.sherry.testcase;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zxin on 17/1/3.
 */
public class DataObserver implements Observer{
    @Override
    public void update(Observable object, Object arg) {
        DataInfo dataInfo = (DataInfo)object;
        System.out.println(dataInfo.toString());
    }

}
