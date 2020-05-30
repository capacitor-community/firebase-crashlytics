package com.getcapacitor.community.firebasecrashlytics;

import android.Manifest;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin(
    permissions = {
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.INTERNET,
        Manifest.permission.WAKE_LOCK
    }
)
public class FirebaseCrashlytics extends Plugin {

    @Override
    public void load() {
        super.load();
    }

    @PluginMethod()
    public void crash(PluginCall call) {
        if (call.hasOption("message")) {
            call.success();
            throw new RuntimeException(call.getString("message"));
        } else {
            call.reject("message is missing.");
        }
    }

    @PluginMethod()
    public void setContext(PluginCall call) {
        if (call.hasOption("key") && call.hasOption("value")) {
            String key = call.getString("key");
            String value = call.getString("value");

            com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().setCustomKey(key, value);
        } else {
            call.reject("key or value is missing.");
        }
    }

    @PluginMethod()
    public void setUserId(PluginCall call) {
        if (call.hasOption("userId")) {
            String userId = call.getString("userId");

            com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().setUserId(userId);
            call.success();
        } else {
            call.reject("userId is missing.");
        }
    }

    @PluginMethod()
    public void addLogMessage(PluginCall call) {
        if (call.hasOption("message")) {
            String message = call.getString("message");

            com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().log(message);
            call.success();
        }
    }

    @PluginMethod()
    public void setEnabled(PluginCall call) {
        if (call.hasOption("enabled")) {
            Boolean enabled = call.getBoolean("enabled");

            com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(enabled);
            call.success();
        }
    }
}
