<p align="center"><br><img src="https://user-images.githubusercontent.com/236501/85893648-1c92e880-b7a8-11ea-926d-95355b8175c7.png" width="128" height="128" /></p>
<h3 align="center">Firebase Crashlytics</h3>
<p align="center"><strong><code>@capacitor-community/firebase-crashlytics</code></strong></p>
<p align="center">
  Capacitor community plugin for native <a href="https://firebase.google.com/docs/crashlytics">Firebase Crashlytics</a>.
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2020?style=flat-square" />
  <a href="https://github.com/capacitor-community/firebase-crashlytics/actions?query=workflow%3A%22Test+and+Build+Plugin%22"><img src="https://img.shields.io/github/workflow/status/capacitor-community/firebase-crashlytics/Test%20and%20Build%20Plugin?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/l/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/dw/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/v/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a href="#contributors-"><img src="https://img.shields.io/badge/all%20contributors-3-orange?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->
</p>

## Maintainers

| Maintainer     | GitHub                                                  | Social                                           |
| -------------- | ------------------------------------------------------- | ------------------------------------------------ |
| Priyank Patel  | [priyankpat](https://github.com/priyankpat)             | [@priyankpat\_](https://twitter.com/priyankpat_) |
| Stewan Silva   | [stewwan](https://github.com/stewwan)                   | [@StewanSilva](https://twitter.com/StewanSilva)  |
| Daniel Pereira | [danielprrazevedo](https://github.com/danielprrazevedo) | [@DandanPrr](https://twitter.com/DandanPrr)      |

## Installation

Using npm:

```bash
npm install @capacitor-community/firebase-crashlytics
```

Using yarn:

```bash
yarn add @capacitor-community/firebase-crashlytics
```

Sync native files:

```bash
npx cap sync
```

On iOS, no further steps are needed.

On Android, add `firebase-crashlytics-gradle` to `build.gradle` and register the plugin in your main activity:

`build.gradle` (root of the project):

```gradle
buildscript {
  repositories {
    google()
    jcenter()
  }

  dependencies {
    ...

    // Add the line below
    classpath 'com.google.firebase:firebase-crashlytics-gradle:2.2.0'
  }
}
```

`build.gradle` (inside app directory):

```gradle
// Add this at the bottom of the file
apply plugin: 'com.google.firebase.crashlytics'
```

`MainActivity.java`:

```java
import com.getcapacitor.community.firebasecrashlytics.FirebaseCrashlytics;

public class MainActivity extends BridgeActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Initializes the Bridge
    this.init(
        savedInstanceState,
        new ArrayList<Class<? extends Plugin>>() {

          {
            // Additional plugins you've installed go here
            // Ex: add(TotallyAwesomePlugin.class);
            add(FirebaseCrashlytics.class);
          }
        }
      );
  }
}
```

## Configuration

Download `google-services.json` and `GoogleService-Info.plist` and place it in their respective platform app directory.

- Android: `android/app`
- iOS: `ios/App/App`

## Examples

[Click here](https://github.com/priyankpat/capacitor-plugins-example/tree/firebase-crashlytics) for an example on how to implement this plugin.

You can also clone the repository:

```bash
git clone https://github.com/priyankpat/capacitor-plugins-example
git checkout -b firebase-crashlytics
```

## Supported methods

| Name                            | Android | iOS | Web |
| :------------------------------ | :------ | :-- | :-- |
| crash                           | ✅      | ✅  | ❌  |
| setContext                      | ✅      | ✅  | ❌  |
| setUserId                       | ✅      | ✅  | ❌  |
| addLogMessage                   | ✅      | ✅  | ❌  |
| setEnabled                      | ✅      | ✅  | ❌  |
| isEnabled                       | ❌      | ✅  | ❌  |
| didCrashDuringPreviousExecution | ✅      | ✅  | ❌  |
| sendUnsentReports               | ✅      | ✅  | ❌  |
| deleteUnsentReports             | ✅      | ✅  | ❌  |
| recordException                 | ✅      | ✅  | ❌  |

## Usage

```typescript
import { Plugins } from "@capacitor/core";

const { FirebaseCrashlytics } = Plugins;

/**
 * Platform: Android/iOS
 * This method will throw an exception triggering crashlytics to log the event.
 * @params message - string message to record (mandatory)
 * @returns void
 */
FirebaseCrashlytic.crash({
  message: "This is a crash message: Capacitor is awesome! 😃",
});

/**
 * Platform: Android/iOS
 * Records a non-fatal report to send to Crashlytics.
 * If automatic data collection is disabled, this method queues up all the reports on a device to send to Crashlytics.
 * @params (android) message - message to record for non-fatal error
 * @params (ios) code - the error code (optional) (default: -1001)
 * @params (ios) domain - a string containing the error domain (optional)
 * @params (ios) message - message to record for non-fatal error
 * @returns none
 */

// Android Example
FirebaseCrashlytics.recordException({
  message: "This is a non-fatal message",
});

// iOS Example
FirebaseCrashlytics.recordException({
  message: "This is a non-fatal message",
  code: 401, // optional, default is -1001
  domain: "capacitor", // optional
});

/**
 * Platform: Android/iOS
 * Sets a custom key and value to be associated with subsequent fatal and non-fatal reports. When setting an object value, the object is converted to a string.
 * @param keys - a unique key associated to the report
 *        value - a unique value associated to the key (string | number | boolean)
 *        type - type of value ('string' | 'long' | 'double' | 'boolean' | 'int' | 'float')
 * @returns none
 */
FirebaseCrashlytics.setContext({
  key: "theme",
  value: "dark",
  type: "string",
});

FirebaseCrashlytics.setContext({
  key: "battery",
  value: 32,
  type: "int",
});

/**
 * Platform: Android/iOS
 * Records a user ID (identifier) that's associated with subsequent fatal and non-fatal reports.
 * @param userId - unique identifier
 * @returns none
 */
FirebaseCrashlytics.setUserId({
  userId: "507f191e810c19729de860ea", // e.g. mongodb document id for a specific user
});

/**
 * Platform: Android/iOS
 * Logs a message that's included in the next fatal or non-fatal report.
 * @params message - string message to record
 * @returns none
 */
FirebaseCrashlytics.addLogMessage({
  message: "This is a test message: Capacitor is awesome! 😃",
});

/**
 * Platform: Android/iOS
 * Enables/disables automatic data collection by Crashlytics.
 * @params enabled - true/false to enable/disable reporting
 * @returns none
 */
FirebaseCrashlytics.setEnabled({
  enabled: false,
});

/**
 * Platform: iOS
 * Indicates whether or not automatic data collection is enabled
 * @params enabled - true/false to enable/disable reporting
 * @returns none
 */
FirebaseCrashlytics.isEnabled();

/**
 * Platform: Android/iOS
 * Enqueues any unsent reports on the device to upload to Crashlytics.
 * This method only applies if automatic data collection is disabled.
 * @params enabled - true/false to enable/disable reporting
 * @returns none
 */
FirebaseCrashlytics.sendUnsentReports();

/**
 * Platform: Android/iOS
 * Deletes any unsent reports on the device.
 * This method only applies if automatic data collection is disabled.
 * @params enabled - true/false to enable/disable reporting
 * @returns none
 */
FirebaseCrashlytics.deleteUnsentReports();
```

## Enable Crashlytics debug logging

If your forced crash didn't crash, crashed before you wanted it to, or you're experiencing some other issue with Crashlytics, you can enable Crashlytics debug logging to track down the problem.

### iOS

To enable debug logging on your development device, specify the following command line argument in Xcode:

```bash
-FIRDebugEnabled
```

### Android

To enable debug logging on your development device, set an adb shell flag before running your app:

```bash
adb shell setprop log.tag.FirebaseCrashlytics DEBUG
```

To view the logs in your device logs, run:

```bash
adb logcat -s FirebaseCrashlytics
```

To disable debug logging, set the flag back to **INFO**:

```
adb shell setprop log.tag.FirebaseCrashlytics INFO
```
