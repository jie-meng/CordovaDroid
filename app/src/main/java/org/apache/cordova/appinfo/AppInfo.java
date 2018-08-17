package org.apache.cordova.appinfo;

import com.jmengxy.cordovadroid.BuildConfig;
import com.jmengxy.cordovadroid.R;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

public class AppInfo extends CordovaPlugin {

    private static final String LOG_TAG = "AppInfo";

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if (this.cordova.getActivity().isFinishing()) return true;

        if (action.equals("getAppInfo")) {
            getAppInfo(callbackContext);
            return true;
        }

        return false;
    }

    private void getAppInfo(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(() -> {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name", cordova.getContext().getString(R.string.app_name));
                jsonObject.put("versionName", BuildConfig.VERSION_NAME);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            callbackContext.sendPluginResult(
                    new PluginResult(
                            PluginResult.Status.OK, jsonObject));
        });
    }
}
