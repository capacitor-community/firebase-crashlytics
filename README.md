# Capacitor Firebase Crashlytics Plugin

Capacitor community plugin for Firebase Crashlytics.

## Maintainers

| Maintainer    | GitHub                                      | Social                                           | Sponsoring Company |
| ------------- | ------------------------------------------- | ------------------------------------------------ | ------------------ |
| Priyank Patel | [priyankpat](https://github.com/priyankpat) | [@priyankpat\_](https://twitter.com/priyankpat_) | Ionic              |

Maintenance Status: Actively Maintained

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
import com.getcapacitor.community.firebasecrashlytic.FirebaseCrashlytic;

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
            add(FirebaseCrashlytic.class);
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

| Name          | Android | iOS | Web |
| :------------ | :------ | :-- | :-- |
| crash         | ✅      | ✅  | ❌  |
| setContext    | ✅      | ✅  | ❌  |
| setUserId     | ✅      | ✅  | ❌  |
| addLogMessage | ✅      | ✅  | ❌  |
| setEnabled    | ✅      | ✅  | ❌  |

## Usage

```typescript
import { Plugins } from "@capacitor/core";

const { FirebaseCrashlytic } = Plugins;

/**
 * This method will throw an exception triggering crashlytics to log the event.
 * @param none
 * @returns void
 */
FirebaseCrashlytic.crash();

/**
 * This method will record custom key/value pair associated with subsequent fatals and non-fatal reports.
 * @param keys - a unique key associated to the report
 *        value - a unique value associated to the key (string | number | boolean)
 *        type - type of value ('string' | 'long' | 'double' | 'boolean' | 'int' | 'float')
 * @returns none
 */
FirebaseCrashlytic.setContext({
  key: "theme",
  value: "dark",
  type: "string",
});

FirebaseCrashlytic.setContext({
  key: "battery",
  value: 32,
  type: "int",
});

/**
 * This method will record a user identifier that's associated with subsequent fatal and non-fatal reports.
 * @param userId - unique identifier
 * @returns none
 */
FirebaseCrashlytic.setUserId({
  userId: "507f191e810c19729de860ea", // e.g. mongodb document id for a specific user
});

/**
 * This method will log a message that's included in the next fatal and non-fatal crash.
 * @params message - string message to record
 * @returns none
 */
FirebaseCrashlytic.addLogMessage({
  message: "This is a test message: Capacitor is awesome! 😃",
});

/**
 * This method will enable/disable crashlytics report collection.
 * @params enabled - true/false to enable/disable reporting
 * @returns none
 */
FirebaseCrashlytic.setEnabled({
  enabled: false,
});
```
