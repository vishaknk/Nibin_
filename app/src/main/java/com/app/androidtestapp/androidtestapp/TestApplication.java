package com.app.androidtestapp.androidtestapp;


import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class TestApplication extends Application {

    public static final String TAG = TestApplication.class
            .getSimpleName();

    private RequestQueue mRequestQueue;

    private static TestApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        mInstance = this;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        mRequestQueue.add(req);
    }

    public static synchronized TestApplication getInstance() {
        return mInstance;
    }
}
