package com.jmengxy.cordovadroid;

import com.jmengxy.cordovadroid.base.ExtendCordovaActivity;
import com.jmengxy.cordovadroid.definitions.WebPagePath;

public class ReactActivity extends ExtendCordovaActivity {
    @Override
    public String getConfig() {
        return "react";
    }

    @Override
    public String getWebPagePath() {
        return WebPagePath.INTERNAL_STORAGE;
    }
}
