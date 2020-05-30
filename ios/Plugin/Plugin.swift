import Foundation
import Capacitor
import Firebase

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitor.ionicframework.com/docs/plugins/ios
 */
@objc(FirebaseCrashlytics)
public class FirebaseCrashlytics: CAPPlugin {
    
    public override func load() {
        FirebaseApp.configure()
    }
    
    @objc func crash(_ call: CAPPluginCall) {
        call.success()
        
        fatalError()
    }
    
    @objc func setContext(_ call: CAPPluginCall) {
        if call.hasOption("key") && call.hasOption("value") {
            let key = call.getString("key")
            let value = call.getString("value")
            
            Crashlytics.crashlytics().setCustomValue(value as Any, forKey: key!)
            call.success()
        } else {
            call.reject("key or value is missing")
        }
    }
    
    @objc func addLogMessage(_ call: CAPPluginCall) {
        if call.hasOption("message") {
            let message = call.getString("message")
            
            Crashlytics.crashlytics().log(message!)
            call.success()
        } else {
            call.reject("message is missing")
        }
    }
    
    @objc func setUserId(_ call: CAPPluginCall) {
        if call.hasOption("userId") {
            let userId = call.getString("userId")
            
            Crashlytics.crashlytics().setUserID(userId!)
            call.success()
        } else {
            call.reject("userId is missing")
        }
    }
    
    @objc func setEnabled(_ call: CAPPluginCall) {
        if call.hasOption("enabled") {
            let enabled = call.getBool("enabled")
            
            Crashlytics.crashlytics().setCrashlyticsCollectionEnabled(enabled!)
            call.success()
        } else {
            call.reject("enabled flag is missing")
        }
    }
}
