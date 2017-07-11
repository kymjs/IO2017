package com.kymjs.io2017.room;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kymjs.io2017.R;

import java.util.List;

/**
 * Created by ZhangTao on 7/6/17.
 */

public class RoomActivity extends LifecycleActivity {

    MutableLiveData<List<User>> userlist = new MutableLiveData<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        final TextView textView = findViewById(R.id.textview);

        //todo:: single instance
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User(System.currentTimeMillis(), "hello", "world");
                        db.userDao().insertAll(user);
                        userlist.postValue(db.userDao().getAll());
                    }
                }).start();
            }
        });

        userlist.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                textView.setText(null);
                if (users != null) {
                    for (User u : users) {
                        textView.append("uid::" + u.getUid() + "\n");
                    }
                }
            }
        });
    }
}
