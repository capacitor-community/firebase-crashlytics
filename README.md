# capacitor-crashlytics [![npm version](https://badge.fury.io/js/capacitor-crashlytics.svg)](https://badge.fury.io/js/capacitor-crashlytics)

Capacitor plugin to enable features from Firebase Crashlytics

<!-- ![Capacitor Firebase Crashlytics Plugin]() -->

## API

- `crash(): Promise<void>`

> For more information check the [`definitions`](/src/definitions.ts) file

## Usage

```js
import { Plugins } from '@capacitor/core';
const { CrashlyticsPlugin } = Plugins;

//
// force a crash
CrashlyticsPlugin.crash();

//
// alternative way
// with type inference

import { Crashlytics } from 'capacitor-crashlytics';
const crashlytics = new Crashlytics();

//
// force a crash
crashlytics.crash();
```

## Add Google config files

Navigate to the project settings page for your app on Firebase.

### iOS

Download the `GoogleService-Info.plist` file. In Xcode right-click on the yellow folder named "App" and select the `Add files to "App"`.

> Tip: if you drag and drop your file to this location, Xcode may not be able to find it.

### Android

Download the `google-services.json` file and copy it to `android/app/` directory of your capacitor project.

## iOS setup

- `ionic start my-cap-app --capacitor`
- `cd my-cap-app`
- `npm install --save capacitor-crashlytics`
- `mkdir www && touch www/index.html`
- `sudo gem install cocoapods` (only once)
- `npx cap add ios`
- `npx cap sync ios` (every time you run `npm install`)
- `npx cap open ios`
- sign your app at xcode (general tab)
- add `GoogleService-Info.plist` to the app folder in xcode

> Tip: every time you change a native code you may need to clean up the cache (Product > Clean build folder) and then run the app again.

## Android setup

- `ionic start my-cap-app --capacitor`
- `cd my-cap-app`
- `npm install --save capacitor-crashlytics`
- `mkdir www && touch www/index.html`
- `npx cap add android`
- `npx cap sync android` (every time you run `npm install`)
- `npx cap open android`
- add `google-services.json` to your `android/app` folder
- `[extra step]` in android case we need to tell Capacitor to initialise the plugin:

> on your `MainActivity.java` file add `import io.stewan.capacitor.crashlytics.CrashlyticsPlugin;` and then inside the init callback `add(CrashlyticsPlugin.class);`

Now you should be set to go. Try to run your client using `ionic cap run android --livereload --address=0.0.0.0`.

> Tip: every time you change a native code you may need to clean up the cache (Build > Clean Project | Build > Rebuild Project) and then run the app again.

## Updating

For existing projects you can upgrade all capacitor related packages (including this plugin) with this single command

`npx npm-upgrade '*capacitor*' && npm install`

## Sample app

https://github.com/stewwan/capacitor-analytics-demo

## You may also like

- [capacitor-analytics](https://github.com/stewwan/capacitor-analytics)
- [capacitor-fcm](https://github.com/stewwan/capacitor-fcm)
- [capacitor-media](https://github.com/stewwan/capacitor-media)
- [capacitor-datepick](https://github.com/stewwan/capacitor-datepick)
- [capacitor-intercom](https://github.com/stewwan/capacitor-intercom)
- [capacitor-twitter](https://github.com/stewwan/capacitor-twitter)

Cheers 🍻

Follow me [@Twitter](https://twitter.com/StewanSilva)

## License

MIT
