package com.example.doan3.Adapter;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;

import java.util.HashMap;

public class Session {
    private static HashMap<String, Object> data = new HashMap<>();


    public Object get(String key) {
        return data.get(key);
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public void clear() {
        data.clear();
    }
}

