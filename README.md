<p align="center"><br><img src="https://user-images.githubusercontent.com/236501/85893648-1c92e880-b7a8-11ea-926d-95355b8175c7.png" width="128" height="128" /></p>
<h3 align="center">Firebase Crashlytics</h3>
<p align="center"><strong><code>@capacitor-community/firebase-crashlytics</code></strong></p>
<p align="center">
  Capacitor plugin for <a href="https://firebase.google.com/docs/crashlytics">Firebase Crashlytics</a>.
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2021?style=flat-square" />
  <a href="https://github.com/capacitor-community/firebase-crashlytics/actions?query=workflow%3A%22CI%22"><img src="https://img.shields.io/github/workflow/status/capacitor-community/firebase-crashlytics/CI/master?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/l/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/dw/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capacitor-community/firebase-crashlytics"><img src="https://img.shields.io/npm/v/@capacitor-community/firebase-crashlytics?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a href="#contributors-"><img src="https://img.shields.io/badge/all%20contributors-1-orange?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->
</p>

## Maintainers

| Maintainer | GitHub                                    | Social                                        |
| ---------- | ----------------------------------------- | --------------------------------------------- |
| Robin Genz | [robingenz](https://github.com/robingenz) | [@robin_genz](https://twitter.com/robin_genz) |

## Installation

```
npm install @capacitor-community/firebase-crashlytics
npx cap sync
```

Add Firebase to your project if you haven't already ([Android](https://firebase.google.com/docs/android/setup) / [iOS](https://firebase.google.com/docs/ios/setup)).

### Android

See [Add Firebase Crashlytics to your app](https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-sdk) and follow the instructions to set up your app correctly.

#### Variables

This plugin will use the following project variables (defined in your app’s `variables.gradle` file):
- `$firebaseCrashlyticsVersion` version of `com.google.firebase:firebase-crashlytics` (default: `17.4.1`)

### iOS

See [Initialize Crashlytics](https://firebase.google.com/docs/crashlytics/get-started?platform=ios#initialize-crashlytics) and follow the instructions to initialize Crashlytics correctly.

## Configuration

No configuration required for this plugin.

## Demo

A working example can be found here: [robingenz/capacitor-plugin-demo](https://github.com/robingenz/capacitor-plugin-demo)

## Usage

```typescript
import { FirebaseCrashlytics } from '@capacitor-community/firebase-crashlytics';

const crash = async () => {
  await FirebaseCrashlytics.crash({ message: 'Test' });
};

const recordException = async () => {
  await FirebaseCrashlytics.recordException({
    message: "This is a non-fatal message.",
  });
};

const setUserId = async () => {
  await FirebaseCrashlytics.setUserId({
    userId: "123",
  });
};

const addLogMessage = async () => {
  await FirebaseCrashlytics.addLogMessage({
    message: "Test",
  });
};

const sendUnsentReports = async () => {
  await FirebaseCrashlytics.sendUnsentReports();
};

const deleteUnsentReports = async () => {
  await FirebaseCrashlytics.deleteUnsentReports();
};
```

## API

<docgen-index>

* [`crash(...)`](#crash)
* [`setContext(...)`](#setcontext)
* [`setUserId(...)`](#setuserid)
* [`addLogMessage(...)`](#addlogmessage)
* [`setEnabled(...)`](#setenabled)
* [`isEnabled()`](#isenabled)
* [`didCrashDuringPreviousExecution()`](#didcrashduringpreviousexecution)
* [`sendUnsentReports()`](#sendunsentreports)
* [`deleteUnsentReports()`](#deleteunsentreports)
* [`recordException(...)`](#recordexception)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### crash(...)

```typescript
crash(options: { message: string; }) => Promise<void>
```

Forces a crash to test the implementation.

Only available for Android and iOS.

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ message: string; }</code> |

--------------------


### setContext(...)

```typescript
setContext(options: ContextOptions) => Promise<void>
```

Sets a custom key and value that is associated with subsequent fatal and non-fatal reports.

Only available for Android and iOS.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#contextoptions">ContextOptions</a></code> |

--------------------


### setUserId(...)

```typescript
setUserId(options: { userId: string; }) => Promise<void>
```

Sets a user ID (identifier) that is associated with subsequent fatal and non-fatal reports.

Only available for Android and iOS.

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ userId: string; }</code> |

--------------------


### addLogMessage(...)

```typescript
addLogMessage(options: { message: string; }) => Promise<void>
```

Adds a log message that is sent with your crash data.
Only visible in the Crashlytics dashboard.

Only available for Android and iOS.

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ message: string; }</code> |

--------------------


### setEnabled(...)

```typescript
setEnabled(options: { enabled: boolean; }) => Promise<void>
```

Enables/disables automatic data collection.
The value does not apply until the next run of the app.

Only available for Android and iOS.

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### isEnabled()

```typescript
isEnabled() => Promise<{ enabled: boolean; }>
```

Returns whether or not automatic data collection is enabled.

Only available for iOS.

**Returns:** <code>Promise&lt;{ enabled: boolean; }&gt;</code>

--------------------


### didCrashDuringPreviousExecution()

```typescript
didCrashDuringPreviousExecution() => Promise<{ crashed: boolean; }>
```

Returns whether the app crashed during the previous execution.

Only available for Android and iOS.

**Returns:** <code>Promise&lt;{ crashed: boolean; }&gt;</code>

--------------------


### sendUnsentReports()

```typescript
sendUnsentReports() => Promise<void>
```

Uploads any unsent reports to Crashlytics.
When automatic data collection is enabled, Crashlytics automatically uploads reports at startup.

Only available for Android and iOS.

--------------------


### deleteUnsentReports()

```typescript
deleteUnsentReports() => Promise<void>
```

Deletes any unsent reports on the device.

Only available for Android and iOS.

--------------------


### recordException(...)

```typescript
recordException(options: RecordExceptionOptions) => Promise<void>
```

Records a non-fatal report to send to Crashlytics.

Only available for Android and iOS.

| Param         | Type                                                                      |
| ------------- | ------------------------------------------------------------------------- |
| **`options`** | <code><a href="#recordexceptionoptions">RecordExceptionOptions</a></code> |

--------------------


### Interfaces


#### ContextOptions

| Prop        | Type                                                                         |
| ----------- | ---------------------------------------------------------------------------- |
| **`key`**   | <code>string</code>                                                          |
| **`value`** | <code>string \| number \| boolean</code>                                     |
| **`type`**  | <code>'string' \| 'boolean' \| 'long' \| 'double' \| 'int' \| 'float'</code> |


#### RecordExceptionOptions

| Prop          | Type                | Description                                                        |
| ------------- | ------------------- | ------------------------------------------------------------------ |
| **`message`** | <code>string</code> |                                                                    |
| **`code`**    | <code>number</code> | Error code within a specific error domain. Only available for iOS. |
| **`domain`**  | <code>string</code> | A string containing the error domain. Only available for iOS.      |

</docgen-api>

## Test your implementation

[Here](https://firebase.google.com/docs/crashlytics/force-a-crash) you can find more information on how to test the Firebase Crashlytics implementation.
Among other things, you will find information on how to correctly [adjust the project's debug settings](https://firebase.google.com/docs/crashlytics/force-a-crash?platform=ios#adjust_your_projects_debug_settings) under iOS and how to [test it out](https://firebase.google.com/docs/crashlytics/force-a-crash?platform=ios#test_it_out).

If you get obfuscated crash reports for iOS, make sure you have [initialized Crashlytics](https://firebase.google.com/docs/crashlytics/get-started?platform=ios#initialize-crashlytics)) correctly and take a look at [this guide](https://firebase.google.com/docs/crashlytics/get-deobfuscated-reports?platform=ios), which provides some ways to troubleshoot if Crashlytics can't find your app's dSYM.

## Changelog

See [CHANGELOG.md](https://github.com/capacitor-community/firebase-crashlytics/blob/master/CHANGELOG.md).

## License

See [LICENSE](https://github.com/capacitor-community/firebase-crashlytics/blob/master/LICENSE).
