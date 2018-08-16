package com.jmengxy.cordovadroid.definitions;

import com.jmengxy.cordovadroid.BuildConfig;

public class WebPagePath {
    public static final String ASSETS = "file:///android_asset/www";
    public static final String INTERNAL_STORAGE = "file:///sdcard/Android/data/" + BuildConfig.APPLICATION_ID + "/www";
    public static final String EXTERNAL_STORAGE = "file:///sdcard/CordovaDroid/www";
}
