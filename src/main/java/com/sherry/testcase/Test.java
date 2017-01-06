package com.sherry.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zxin on 16/12/19.
 */
public class Test {

    public static void main(String[] args) {
        DataObserver observer = new DataObserver();
        DataInfo dataInfo = new DataInfo();
        dataInfo.setKey("123");
        dataInfo.addObserver(observer);

        dataInfo.setKey("haha");
        dataInfo.setValue("value");

    }
}
