package com.getcapacitor.community.firebasecrashlytic;

import android.Manifest;
import android.util.Log;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

@NativePlugin(
  permissions = {
    Manifest.permission.ACCESS_NETWORK_STATE,
    Manifest.permission.INTERNET,
    Manifest.permission.WAKE_LOCK,
  }
)
public class FirebaseCrashlytic extends Plugin {
  public static final String TAG = "FirebaseCrashlytic";
  private Bridge bridge;

  @Override
  public void load() {
    if (bridge == null) {
      bridge = this.getBridge();
    }

    if (FirebaseApp.getApps(bridge.getContext()).size() == 0) {
      FirebaseApp.initializeApp(bridge.getActivity().getApplicationContext());
    }

    super.load();
  }

  /**
   * Trigger a fatal crash for crashlytics to record
   * @param call
   */
  @PluginMethod
  public void crash(PluginCall call) {
    if (!call.hasOption("message")) {
      call.error("message property is missing");
      return;
    }

    String message = call.getString("message");
    call.success();
    throw new RuntimeException(message);
  }

  /**
   * Sets a custom key and value to be associated with subsequent fatal and non-fatal reports. When setting an object value, the object is converted to a string.
   * @param call - key: a unique key
   *               value: a value to be associated with the given key
   */
  @PluginMethod
  public void setContext(PluginCall call) {
    if (!call.hasOption("key") || !call.hasOption("value")) {
      call.error(
        !call.hasOption("key")
          ? "key property is missing"
          : "value propery is missing"
      );
      return;
    }

    try {
      String key = call.getString("key");
      String type = call.getString("type", "string");

      switch (type) {
        case "string":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getString("value"));
          break;
        case "long":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, Long.valueOf(call.getInt("value")));
          break;
        case "int":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getInt("value"));
          break;
        case "boolean":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getBoolean("value"));
          break;
        case "float":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getFloat("value"));
          break;
        case "double":
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getDouble("value"));
          break;
        default:
          FirebaseCrashlytics
            .getInstance()
            .setCustomKey(key, call.getString("value"));
      }
      call.success();
    } catch (Exception ex) {
      Log.e(
        TAG,
        "Caught exception while setting a crashlytics context: " +
        ex.getLocalizedMessage()
      );
    }
  }

  /**
   * Records a user ID (identifier) that’s associated with subsequent fatal and non-fatal reports.
   * @param call - userId: unique user identifier
   */
  @PluginMethod
  public void setUserId(PluginCall call) {
    if (!call.hasOption("userId")) {
      call.error("userId is missing");
      return;
    }

    String userId = call.getString("userId");
    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .setUserId(userId);
    call.success();
  }

  /**
   * Adds logging that is sent with your crash data. The logging does not appear in the system.log and is only visible in the Crashlytics dashboard.
   * @param call - message: message - message to display during logging
   */
  @PluginMethod
  public void addLogMessage(PluginCall call) {
    if (call.hasOption("message")) {
      String message = call.getString("message");

      com
        .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
        .log(message);
      call.success();
    }
  }

  /**
   * Enables/disables automatic data collection.
   * @param call - enabled: boolean true/false to enable/disable crashlytics logging
   */
  @PluginMethod
  public void setEnabled(PluginCall call) {
    Boolean enabled = call.getBoolean("enabled", false);

    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .setCrashlyticsCollectionEnabled(enabled);
    call.success();
  }

  /**
   * Indicates whether or not automatic data collection is enabled
   * @param call
   * @return enabled: boolean true/false
   */
  @PluginMethod
  public void isEnabled(PluginCall call) {
    call.success(new JSObject().put("enabled", false));
  }

  /**
   * Returns whether the app crashed during the previous execution.
   * @param call
   * @return crashed: boolean true/false
   */
  @PluginMethod
  public void didCrashOnPreviousExecution(PluginCall call) {
    call.success(
      new JSObject()
      .put(
          "crashed",
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .didCrashOnPreviousExecution()
        )
    );
  }

  /**
   * Enqueues any unsent reports on the device to upload to Crashlytics.
   * This method only applies if automatic data collection is disabled.
   * @param call
   */
  @PluginMethod
  public void sendUnsentReports(PluginCall call) {
    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .sendUnsentReports();
    call.success();
  }

  /**
   * Deletes any unsent reports on the device.
   * This method only applies if automatic data collection is disabled.
   * @param call
   */
  @PluginMethod
  public void deleteUnsentReports(PluginCall call) {
    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .deleteUnsentReports();
    call.success();
  }
}
