package com.kymjs.io2017;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kymjs.io2017.lifecycle.LifecycleObserverImpl;
import com.kymjs.io2017.livedata.VIP;
import com.kymjs.io2017.livedata.VIPLiveData;
import com.kymjs.io2017.room.RoomActivity;
import com.kymjs.io2017.viewmodel.AActivity;

/**
 * 也可以直接继承 LifecycleActivity
 */
public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textview);

        //lifecycler demo
        mRegistry.addObserver(new LifecycleObserverImpl());

        //livedata demo
        VIPLiveData.get().observe(this, new Observer<VIP>() {
            @Override
            public void onChanged(@Nullable VIP vip) {
                if (vip != null) {
                    textView.setText(vip.getName());
                }
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        VIP vip = new VIP();
                        vip.setName("延迟5秒");
                        VIPLiveData.get().update(vip);
                    }
                }, 5000);
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VIP vip = new VIP();
                vip.setName("张涛" + (int) (Math.random() * 10));
                VIPLiveData.get().update(vip);
            }
        });

        //viewmodel demo
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AActivity.class));
            }
        });

        //room
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("kymjs", "activity======onPause:");
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }
}
