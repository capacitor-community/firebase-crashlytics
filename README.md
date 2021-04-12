<p align="center"><br><img src="https://user-images.githubusercontent.com/236501/85893648-1c92e880-b7a8-11ea-926d-95355b8175c7.png" width="128" height="128" /></p>
<h3 align="center">Firebase Crashlytics</h3>
<p align="center"><strong><code>@capacitor-community/firebase-crashlytics</code></strong></p>
<p align="center">
  Capacitor community plugin for native <a href="https://firebase.google.com/docs/crashlytics">Firebase Crashlytics</a>.
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

### Android

See [Add Firebase Crashlytics to your app](https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-sdk) and follow the instructions to set up your app correctly.

#### Variables

This plugin will use the following project variables (defined in your app’s `variables.gradle` file):
- `$firebaseCrashlyticsVersion` version of `com.google.firebase:firebase-crashlytics` (default: `17.4.1`)

## Configuration

No configuration required for this plugin.

## Usage

```typescript
import { FirebaseCrashlytics } from '@capacitor-community/firebase-crashlytics';

// WIP
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
recordException(options: iOSException | AndroidException) => Promise<void>
```

Records a non-fatal report to send to Crashlytics.

Only available for Android and iOS.

| Param         | Type                                                                                                      |
| ------------- | --------------------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#iosexception">iOSException</a> \| <a href="#androidexception">AndroidException</a></code> |

--------------------


### Interfaces


#### ContextOptions

| Prop        | Type                                                                         |
| ----------- | ---------------------------------------------------------------------------- |
| **`key`**   | <code>string</code>                                                          |
| **`value`** | <code>string \| number \| boolean</code>                                     |
| **`type`**  | <code>'string' \| 'boolean' \| 'long' \| 'double' \| 'int' \| 'float'</code> |


#### iOSException

| Prop          | Type                |
| ------------- | ------------------- |
| **`code`**    | <code>number</code> |
| **`domain`**  | <code>string</code> |
| **`message`** | <code>string</code> |


#### AndroidException

| Prop          | Type                |
| ------------- | ------------------- |
| **`message`** | <code>string</code> |

</docgen-api>

## Changelog

See [CHANGELOG.md](https://github.com/capacitor-community/firebase-crashlytics/blob/master/CHANGELOG.md).

## License

See [LICENSE](https://github.com/capacitor-community/firebase-crashlytics/blob/master/LICENSE).
