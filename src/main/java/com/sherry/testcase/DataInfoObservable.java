package com.sherry.testcase;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zxin on 17/1/3.
 */
public class DataInfoObservable extends Observable{
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }
}
