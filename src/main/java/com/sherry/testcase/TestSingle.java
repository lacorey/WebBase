package com.sherry.testcase;

/**
 * Created by zxin on 16/12/13.
 */
public class TestSingle {

    public static void main(String[] args) {
        ShareUser.getInstance().context(new Context());
    }
}
