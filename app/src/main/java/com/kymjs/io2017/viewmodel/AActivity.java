package com.kymjs.io2017.viewmodel;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kymjs.io2017.R;
import com.kymjs.io2017.livedata.VIP;


/**
 * Created by ZhangTao on 7/5/17.
 */

public class AActivity extends LifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        final TextView textView = findViewById(R.id.textview);

        final VIPViewModel vipViewModel = ViewModelProviders.of(this).get(VIPViewModel.class);
        VIP cacheVip = vipViewModel.getVIPLiveData().getValue();
        if (cacheVip != null) {
            textView.setText(cacheVip.getName());
        }


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VIP vip = new VIP();
                vip.setName("A界面" + (int) (Math.random() * 10));
                vipViewModel.getVIPLiveData().update(vip);
            }
        });

        vipViewModel.getVIPLiveData().observe(this, new Observer<VIP>() {
            @Override
            public void onChanged(@Nullable VIP vip) {
                if (vip != null) {
                    textView.setText(vip.getName());
                }
            }
        });

    }
}
