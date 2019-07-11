# capacitor-crashlytics [![npm version](https://badge.fury.io/js/capacitor-crashlytics.svg)](https://badge.fury.io/js/capacitor-crashlytics)

Capacitor plugin to enable features from Firebase Crashlytics

> Android coming soon

![Capacitor Firebase Crashlytics Plugin](https://i.imgur.com/F8cy3PQ.png)

## API

- `crash(): Promise<void>`
- `logUser(options: {id: string, email:string, name: string}): Promise<void>`

> For more information check the [`definitions`](/src/definitions.ts) file

## Usage

```js
import { Crashlytics } from 'capacitor-crashlytics';
const crashlytics = new Crashlytics();

//
// log user
crashlytics
  .logUser({
    name: this.name,
    email: this.email,
    id: this.id
  })
  .then(() => alert(`user logged`))
  .catch(err => alert(err.message));

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

### Build phase

1. [Create a Fabric account](https://fabric.io/kits?show_signup=true)
2. Go to [install instructions](https://fabric.io/kits/ios/crashlytics/install)
3. Follow steps on **Add a Run Script Build Phase**
4. Follow steps on **Add Your API Key**

After you build the app in xcode you should be able to link it in Firebase console. To start seeing logs in the panel, force a crash using method `crash` (app must not be running within xcode) and then re-start the app.

### Not seeing a crash in the dashboard?

- Double-check in your Build Settings that your Debug Information Format is **DWARF with dSYM File** for both Debug and Release
- Make sure to launch the app after crashing it, so that the crash can be uploaded
- If you don’t see the crash after a few minutes, run your app again to retry crash delivery.

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

https://github.com/stewwan/capacitor-crashlytics-demo

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
