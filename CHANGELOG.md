# Changelog

All notable changes to this project will be documented in this file. See [standard-version](https://github.com/conventional-changelog/standard-version) for commit guidelines.

## [1.0.0](https://github.com/capacitor-community/firebase-crashlytics/compare/v0.4.0...v1.0.0) (2021-04-22)


### ⚠ BREAKING CHANGES

* replace `iOSException` and `AndroidException` with `RecordExceptionOptions`
* **android:** throw unimplemented error for `isEnabled` on Android
* **web:** throw unimplemented error on web
* Update to Capacitor 3


### Features

* add Capacitor 3 support ([#23](https://github.com/capacitor-community/firebase-crashlytics/issues/23)) ([98cf63c](https://github.com/capacitor-community/firebase-crashlytics/commit/98cf63c1eb431d9d5a52ebacd314f4fd5c63df5e))


* replace `iOSException` and `AndroidException` ([#29](https://github.com/capacitor-community/firebase-crashlytics/issues/29)) ([80289a9](https://github.com/capacitor-community/firebase-crashlytics/commit/80289a9af1270bfc5329cdc4e8c79c9cff53bbbc))
* **android:** throw unimplemented error ([#28](https://github.com/capacitor-community/firebase-crashlytics/issues/28)) ([c18321b](https://github.com/capacitor-community/firebase-crashlytics/commit/c18321be46e912223529cdb8e5a54bcac68c5ba4))
* **web:** throw unimplemented error ([#27](https://github.com/capacitor-community/firebase-crashlytics/issues/27)) ([4127e0a](https://github.com/capacitor-community/firebase-crashlytics/commit/4127e0ac58655d55361edc7707e8ed600f17505d))

## [0.4.0](https://github.com/capacitor-community/firebase-crashlytics/compare/v0.3.0...v0.4.0) (2021-04-11)


### Features

* **android:** add support for project variables ([#25](https://github.com/capacitor-community/firebase-crashlytics/issues/25)) ([1cb5e16](https://github.com/capacitor-community/firebase-crashlytics/commit/1cb5e1675d29eee9e7771e955b0e3822b83e53d2))


### Bug Fixes

* **ios:** FirebaseApp.configure() not called ([2bc3e3c](https://github.com/capacitor-community/firebase-crashlytics/commit/2bc3e3c78bebd29bd4a7606a3dd1b60d52f23daa))
* **android:** didCrashDuringPreviousExecution is not a function ([cbec445](https://github.com/capacitor-community/firebase-crashlytics/commit/cbec44549c8ae45a504c167cde50817a16ad1477))

## [0.3.0](https://github.com/capacitor-community/firebase-crashlytics/compare/v0.2.0...v0.3.0) (2020-06-30)


### Features

* **android:** add recordException method ([6ba14eb](https://github.com/capacitor-community/firebase-crashlytics/commit/6ba14eb36859927d9d272e691ad69b7fb59b26f1))
* **ios:** add recordException method ([7fdf456](https://github.com/capacitor-community/firebase-crashlytics/commit/7fdf45680b1e45a5e99c2d9d729b33f912ced2a0))
* **web:** add definition for recordException ([5f85199](https://github.com/capacitor-community/firebase-crashlytics/commit/5f851996f80db45347d9685c1dedbd57eaab3bc3))

## [0.2.0](https://github.com/capacitor-community/firebase-crashlytics/compare/v0.1.3...v0.2.0) (2020-06-30)


### Features

* **ios:** add isEnabled, didCrashDuringPreviousExecution, sendUnsentReports, deleteUnsentReports ([0ce276f](https://github.com/capacitor-community/firebase-crashlytics/commit/0ce276f1f2bcd3c60e96072dc266667d3a07caef))
* **android:** add isEnabled, didCrashDuringPreviousExecution, sendUnsentReports, deleteUnsentReports ([0c41d9a](https://github.com/capacitor-community/firebase-crashlytics/commit/0c41d9aa95b3902e8857c9d76b3e08f649f92652))
