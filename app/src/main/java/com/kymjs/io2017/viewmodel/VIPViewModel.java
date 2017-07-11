package com.kymjs.io2017.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.kymjs.io2017.livedata.VIP;
import com.kymjs.io2017.livedata.VIPLiveData;

/**
 * Created by ZhangTao on 7/5/17.
 */

public class VIPViewModel extends ViewModel {

    //    private VIPLiveData mVIPLiveData = VIPLiveData.get();
    private VIPLiveData mVIPLiveData = new VIPLiveData();

    public VIPLiveData getVIPLiveData() {
        return mVIPLiveData;
    }

    public VIPViewModel setVIPData(VIP vip) {
        mVIPLiveData.update(vip);
        return this;
    }
}
