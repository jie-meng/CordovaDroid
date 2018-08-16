package com.jmengxy.cordovadroid.base;

import android.content.Context;

import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendCordovaConfigXmlParser {
    private static String TAG = "ExtendCordovaConfigXmlParser";
    private String webPagePath;
    private String launchUrl = webPagePath + "/index.html";
    private CordovaPreferences prefs = new CordovaPreferences();
    private ArrayList<PluginEntry> pluginEntries = new ArrayList(20);
    boolean insideFeature = false;
    String service = "";
    String pluginClass = "";
    String paramType = "";
    boolean onload = false;

    public ExtendCordovaConfigXmlParser(String webPagePath) {
        this.webPagePath = webPagePath;
    }

    public CordovaPreferences getPreferences() {
        return this.prefs;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }

    public String getLaunchUrl() {
        return this.launchUrl;
    }

    public void parse(Context action, String config) {
        int id = action.getResources().getIdentifier(config, "xml", action.getClass().getPackage().getName());
        if (id == 0) {
            id = action.getResources().getIdentifier(config, "xml", action.getPackageName());
            if (id == 0) {
                LOG.e(TAG, String.format("res/xml/%s.xml is missing!", config));
                return;
            }
        }

        this.parse(action.getResources().getXml(id));
    }

    public void parse(XmlPullParser xml) {
        int eventType = -1;

        while (eventType != 1) {
            if (eventType == 2) {
                this.handleStartTag(xml);
            } else if (eventType == 3) {
                this.handleEndTag(xml);
            }

            try {
                eventType = xml.next();
            } catch (XmlPullParserException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }

    public void handleStartTag(XmlPullParser xml) {
        String strNode = xml.getName();
        if (strNode.equals("feature")) {
            this.insideFeature = true;
            this.service = xml.getAttributeValue(null, "name");
        } else if (this.insideFeature && strNode.equals("param")) {
            this.paramType = xml.getAttributeValue(null, "name");
            if (this.paramType.equals("service")) {
                this.service = xml.getAttributeValue(null, "value");
            } else if (!this.paramType.equals("package") && !this.paramType.equals("android-package")) {
                if (this.paramType.equals("onload")) {
                    this.onload = "true".equals(xml.getAttributeValue(null, "value"));
                }
            } else {
                this.pluginClass = xml.getAttributeValue(null, "value");
            }
        } else {
            String src;
            if (strNode.equals("preference")) {
                src = xml.getAttributeValue(null, "name").toLowerCase(Locale.ENGLISH);
                String value = xml.getAttributeValue(null, "value");
                this.prefs.set(src, value);
            } else if (strNode.equals("content")) {
                src = xml.getAttributeValue(null, "src");
                if (src != null) {
                    this.setStartUrl(src);
                }
            }
        }

    }

    public void handleEndTag(XmlPullParser xml) {
        String strNode = xml.getName();
        if (strNode.equals("feature")) {
            this.pluginEntries.add(new PluginEntry(this.service, this.pluginClass, this.onload));
            this.service = "";
            this.pluginClass = "";
            this.insideFeature = false;
            this.onload = false;
        }

    }

    private void setStartUrl(String src) {
        if (src == null) {
            return;
        }

        Pattern schemeRegex = Pattern.compile("^[a-z-]+://");
        Matcher matcher = schemeRegex.matcher(src);
        if (matcher.find()) {
            this.launchUrl = src;
        } else {
            if (src.charAt(0) == '/') {
                src = src.substring(1);
            }

            this.launchUrl = webPagePath + "/" + src;
        }
    }
}
