package com.jmengxy.cordovadroid;

import com.jmengxy.cordovadroid.base.ExtendCordovaActivity;
import com.jmengxy.cordovadroid.definitions.WebPagePath;

public class IndexActivity extends ExtendCordovaActivity {

    @Override
    public String getConfig() {
        return "index";
    }

    @Override
    public String getWebPagePath() {
        return WebPagePath.ASSETS;
    }
}
