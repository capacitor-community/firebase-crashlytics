import Foundation

@objc public class FirebaseCrashlytics: NSObject {
    override init() {
        if (FirebaseApp.app() == nil) {
            FirebaseApp.configure()
        }
    }

    @objc public func crash() {
        fatalError()
    }

    @objc func setContext(_ key: String, _ type: String, _ call: CAPPluginCall) {
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
    }

    @objc func addLogMessage(_ message: String) {
        Crashlytics.crashlytics().log(message)
    }

    @objc func addLogMessage(_ userId: String) {
        Crashlytics.crashlytics().setUserID(userId)
    }

    @objc func setEnabled(_ enabled: Bool) {
        Crashlytics.crashlytics().setCrashlyticsCollectionEnabled(enabled)
    }

    @objc func isEnabled() -> Bool {
        return Crashlytics.crashlytics().isCrashlyticsCollectionEnabled()
    }

    @objc func didCrashDuringPreviousExecution() -> Bool {
        return Crashlytics.crashlytics().didCrashDuringPreviousExecution()
    }

    @objc func sendUnsentReports() {
        Crashlytics.crashlytics().sendUnsentReports()
    }

    @objc func deleteUnsentReports() {
        Crashlytics.crashlytics().deleteUnsentReports()
    }

    @objc func recordException(_ message: String, _ domain: String, _ code: Int) {
        let error = NSError((domain: domain, code: code, userInfo: [ NSLocalizedDescriptionKey: message]))
        Crashlytics.crashlytics().record(error: error)
    }
}
