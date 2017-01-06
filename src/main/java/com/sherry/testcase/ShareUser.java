package com.sherry.testcase;

/**
 * Created by zxin on 16/12/13.
 */
public class ShareUser {
    private Context mContext;

    private ShareUser() {

    }

    private static ShareUser single = null;

    public static ShareUser getInstance() {
        if (single == null) {
            single = new ShareUser();
        }
        return single;
    }

    public ShareUser context(Context context){
        if(single == null){
            try {
                throw new Exception("context method must invoke after getInstance method");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mContext = context;
        System.out.println(this.mContext == this.single.mContext);
        System.out.println(this == this.single);
        return single;
    }
}
