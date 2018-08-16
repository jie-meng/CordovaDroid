package com.jmengxy.cordovadroid.base;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

public abstract class ExtendCordovaActivity extends CordovaActivity {

    public abstract String getConfig();

    public abstract String getWebPagePath();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadConfig();

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        loadUrl(launchUrl);
    }

    @Override
    protected void loadConfig() {
        ExtendCordovaConfigXmlParser parser = new ExtendCordovaConfigXmlParser(getWebPagePath());
        parser.parse(this, getConfig());
        this.preferences = parser.getPreferences();
        this.preferences.setPreferencesBundle(getIntent().getExtras());
        this.launchUrl = parser.getLaunchUrl();
        this.pluginEntries = parser.getPluginEntries();
    }
}