import { WebPlugin } from '@capacitor/core';
import { FirebaseCrashlyticsPlugin, ContextOptions } from './definitions';

export class FirebaseCrashlyticsWeb extends WebPlugin implements FirebaseCrashlyticsPlugin {
  constructor() {
    super({
      name: 'FirebaseCrashlytics',
      platforms: ['web']
    });
  }

  setUserId(options: { userId: string; }): Promise<void> {
    console.log(options);
    throw new Error("Method not implemented.");
  }

  addLogMessage(options: { message: string; }): Promise<void> {
    console.log(options);
    throw new Error("Method not implemented.");
  }

  setEnabled(options: { enabled: boolean; }): Promise<void> {
    console.log(options);
    throw new Error("Method not implemented.");
  }

  crash(): Promise<void> {
    throw new Error("Method not implemented.");
  }

  setContext(options: ContextOptions): Promise<void> {
    console.log(options);
    throw new Error("Method not implemented.");
  }
}

const FirebaseCrashlytics = new FirebaseCrashlyticsWeb();

export { FirebaseCrashlytics };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(FirebaseCrashlytics);
