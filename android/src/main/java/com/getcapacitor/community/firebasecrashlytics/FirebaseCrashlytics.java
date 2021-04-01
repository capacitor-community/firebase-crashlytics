package com.getcapacitor.community.firebasecrashlytics;

import android.Manifest;
import android.util.Log;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.google.firebase.FirebaseApp;

@CapacitorPlugin(
  name = "FirebaseCrashlytics",
  permissions = {
    @Permission(
      strings = { Manifest.permission.ACCESS_NETWORK_STATE },
      alias = "network"
    ),
    @Permission(strings = { Manifest.permission.INTERNET }, alias = "internet"),
    @Permission(
      strings = { Manifest.permission.WAKE_LOCK },
      alias = "wakelock"
    ),
  }
)
public class FirebaseCrashlytics extends Plugin {
  public static final String TAG = "FirebaseCrashlytics";
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
      call.reject("message property is missing");
      return;
    }

    String message = call.getString("message");
    call.resolve();
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
      call.reject(
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
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getString("value"));
          break;
        case "long":
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, Long.valueOf(call.getInt("value")));
          break;
        case "int":
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getInt("value"));
          break;
        case "boolean":
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getBoolean("value"));
          break;
        case "float":
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getFloat("value"));
          break;
        case "double":
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getDouble("value"));
          break;
        default:
          com
            .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            .setCustomKey(key, call.getString("value"));
      }
      call.resolve();
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
      call.reject("userId is missing");
      return;
    }

    String userId = call.getString("userId");
    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .setUserId(userId);
    call.resolve();
  }

  /**
   * Adds logging that is sent with your crash data. The logging does not appear in the system.log and is only visible in the Crashlytics dashboard.
   * @param call - message: message - message to display during logging
   */
  @PluginMethod
  public void addLogMessage(PluginCall call) {
    if (!call.hasOption("message")) {
      call.reject("message property is missing");
      return;
    }

    String message = call.getString("message");

    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .log(message);
    call.resolve();
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
    call.resolve();
  }

  /**
   * Indicates whether or not automatic data collection is enabled
   * @param call
   * @return enabled: boolean true/false
   */
  @PluginMethod
  public void isEnabled(PluginCall call) {
    call.resolve(new JSObject().put("enabled", false));
  }

  /**
   * Returns whether the app crashed during the previous execution.
   * @param call
   * @return crashed: boolean true/false
   */
  @PluginMethod
  public void didCrashDuringPreviousExecution(PluginCall call) {
    call.resolve(
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
    call.resolve();
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
    call.resolve();
  }

  /**
   * Records a non-fatal report to send to Crashlytics.
   * If automatic data collection is disabled, this method queues up all the reports on a device to send to Crashlytics.
   * @param call
   */
  @PluginMethod
  public void recordException(PluginCall call) {
    if (!call.hasOption("message")) {
      call.reject("message property is missing");
      return;
    }

    String message = call.getString("message");
    com
      .google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
      .recordException(new Throwable(message));
    call.resolve();
  }
}
