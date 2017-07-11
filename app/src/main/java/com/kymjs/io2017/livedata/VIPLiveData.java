package com.kymjs.io2017.livedata;

import android.arch.lifecycle.LiveData;
import android.util.Log;

/**
 * Created by ZhangTao on 7/5/17.
 */
public class VIPLiveData extends LiveData<VIP> {

    private static VIPLiveData sInstance;
    
    //为了另一个 demo 方便，这里就不私有构造器了
//    private VIPLiveData() {
//    }

    public static VIPLiveData get() {
        if (sInstance == null) {
            synchronized (VIPLiveData.class) {
                if (sInstance == null) {
                    sInstance = new VIPLiveData();
                }
            }
        }
        return sInstance;
    }

    public void update(VIP vip) {
        setValue(vip);
    }

    @Override
    protected void onActive() {
        Log.d("kymjs", "=======开始监听");
    }

    @Override
    protected void onInactive() {
        Log.d("kymjs", "=======不再需要监听");
    }
}