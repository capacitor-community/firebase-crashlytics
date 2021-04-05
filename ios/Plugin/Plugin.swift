import Foundation
import Capacitor
import FirebaseCore
import FirebaseCrashlytics

@objc(FirebaseCrashlytics)
public class FirebaseCrashlytics: CAPPlugin {
    
    public override func load() {
        if (FirebaseApp.app() == nil) {
            FirebaseApp.configure()
        }
    }
    
    
    /// Trigger a fatal crash for crashlytics to record
    /// - Parameter call: none
    @objc func crash(_ call: CAPPluginCall) {
        call.resolve()
        
        fatalError()
    }
    
    
    /// Sets a custom key and value to be associated with subsequent fatal and non-fatal reports. When setting an object value, the object is converted to a string.
    /// - Parameter call: key - unique key
    ///                   value - value for the key to record
    @objc func setContext(_ call: CAPPluginCall) {
        if !call.hasOption("key") || !call.hasOption("value") {
            call.reject(!call.hasOption("key") ? "key propery is missing" : "value propery is missing")
            return
        }
        
        let key = call.getString("key")
        let type = call.getString("type") ?? "string"
        
        switch type {
        case "string":
            Crashlytics.crashlytics().setCustomValue(call.getString("value") as Any, forKey: key!)
            break
            
        case "int":
            Crashlytics.crashlytics().setCustomValue(call.getInt("value") as Any, forKey: key!)
            break
            
        case "boolean":
            Crashlytics.crashlytics().setCustomValue(call.getBool("value") as Any, forKey: key!)
            break
            
        case "long":
            Crashlytics.crashlytics().setCustomValue(call.getInt("value") as Any, forKey: key!)
            break
            
        case "double":
            Crashlytics.crashlytics().setCustomValue(call.getDouble("value") as Any, forKey: key!)
            break
            
        case "float":
            Crashlytics.crashlytics().setCustomValue(call.getFloat("value") as Any, forKey: key!)
            break
            
        default:
            Crashlytics.crashlytics().setCustomValue(call.getString("value") as Any, forKey: key!)
        }
        call.resolve()
    }
    
    
    /// Adds logging that is sent with your crash data. The logging does not appear in the system.log and is only visible in the Crashlytics dashboard.
    /// - Parameter call: message - message to display during logging
    @objc func addLogMessage(_ call: CAPPluginCall) {
        if !call.hasOption("message") {
            call.reject("message property is missing")
            return
        }
        
        let message = call.getString("message")
        Crashlytics.crashlytics().log(message!)
        call.resolve()
    }
    
    
    
    /// Records a user ID (identifier) that’s associated with subsequent fatal and non-fatal reports.
    /// - Parameter call: userId - unique user identifier
    @objc func setUserId(_ call: CAPPluginCall) {
        if !call.hasOption("userId") {
            call.reject("userId property is missing")
            return
        }
        
        let userId = call.getString("userId")
        Crashlytics.crashlytics().setUserID(userId!)
        call.resolve()
    }
    
    
    /// Enables/disables automatic data collection.
    /// - Parameter call: enabled - boolean true/false to enable/disable crashlytics logging
    @objc func setEnabled(_ call: CAPPluginCall) {
        let enabled = call.hasOption("enabled") ? call.getBool("enabled") : false;
        Crashlytics.crashlytics().setCrashlyticsCollectionEnabled(enabled!)
        call.resolve()
    }
    
    
    /// Indicates whether or not automatic data collection is enabled
    /// - Parameter call: none
    /// - Parameter return: enabled - boolean true/false if crashlytics is enabled or disabled
    @objc func isEnabled(_ call: CAPPluginCall) {
        call.resolve([
            "enabled": Crashlytics.crashlytics().isCrashlyticsCollectionEnabled()
        ])
    }
    
    /// Returns whether the app crashed during the previous execution.
    /// - Parameter call: none
    /// - Parameter return: crashed - boolean true/false
    @objc func didCrashDuringPreviousExecution(_ call: CAPPluginCall) {
        call.resolve([
            "crashed": Crashlytics.crashlytics().didCrashDuringPreviousExecution()
        ])
    }
    
    /// Enqueues any unsent reports on the device to upload to Crashlytics.
    /// This method only applies if automatic data collection is disabled.
    /// - Parameter call: none
    @objc func sendUnsentReports(_ call: CAPPluginCall) {
        if Crashlytics.crashlytics().isCrashlyticsCollectionEnabled() {
            call.reject("cannot send report while crashlytics is enabled")
            return;
        }
        
        Crashlytics.crashlytics().sendUnsentReports()
        call.resolve()
    }
    
    /// Deletes any unsent reports on the device.
    /// This method only applies if automatic data collection is disabled.
    /// - Parameter call: none
    @objc func deleteUnsentReports(_ call: CAPPluginCall) {
        if Crashlytics.crashlytics().isCrashlyticsCollectionEnabled() {
            call.reject("cannot send report while crashlytics is enabled")
            return;
        }
        
        Crashlytics.crashlytics().deleteUnsentReports()
        call.resolve()
    }
    
    /// Records a non-fatal report to send to Crashlytics.
    /// If automatic data collection is disabled, this method queues up all the reports on a device to send to Crashlytics.
    /// - Parameter call: code - the error code
    ///                   domain - a string containing the error domain
    ///                   message - message to record for non-fatal crash
    @objc func recordException(_ call: CAPPluginCall) {
        
        let domain = call.getString("domain") ?? ""
        let code = call.getInt("code") ?? -1001
        let message = call.getString("message") ?? ""
        
        Crashlytics.crashlytics().record(error: NSError(domain: domain, code: code, userInfo: [ NSLocalizedDescriptionKey: message]))
        call.resolve()
    }
}
