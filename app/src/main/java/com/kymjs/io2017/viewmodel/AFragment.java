package com.kymjs.io2017.viewmodel;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymjs.io2017.R;
import com.kymjs.io2017.livedata.VIP;


/**
 * Created by ZhangTao on 7/5/17.
 */

public class AFragment extends LifecycleFragment {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        root = inflater.inflate(R.layout.fragment_a, container);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textView = root.findViewById(R.id.textView);

//        final VIPViewModel vipViewModel = ViewModelProviders.of(this).get(VIPViewModel.class);
        final VIPViewModel vipViewModel = ViewModelProviders.of(getActivity()).get(VIPViewModel.class);
        VIP cacheVip = vipViewModel.getVIPLiveData().getValue();
        if (cacheVip != null) {
            textView.setText(cacheVip.getName());
        }

        vipViewModel.getVIPLiveData().observe(this, new Observer<VIP>() {
            @Override
            public void onChanged(@Nullable VIP vip) {
                if (vip != null) {
                    textView.setText(vip.getName());
                }
            }
        });

        root.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VIP vip = new VIP();
                vip.setName("A界面" + (int) (Math.random() * 10));
                vipViewModel.getVIPLiveData().update(vip);
            }
        });
    }
}
