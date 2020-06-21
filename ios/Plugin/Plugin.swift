import Foundation
import Capacitor
import Firebase
import FirebaseCrashlytics

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitor.ionicframework.com/docs/plugins/ios
 */
@objc(FirebaseCrashlytic)
public class FirebaseCrashlytic: CAPPlugin {
    
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
