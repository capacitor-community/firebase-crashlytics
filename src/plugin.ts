import { Plugins } from '@capacitor/core';
import { CrashlyticsProtocol, CrashlyticsUserOptions } from './definitions';

const { CrashlyticsPlugin } = Plugins;

export class Crashlytics implements CrashlyticsProtocol {
  crash(): Promise<void> {
    return CrashlyticsPlugin.crash();
  }

  logUser(options: CrashlyticsUserOptions): Promise<void> {
    return CrashlyticsPlugin.logUser(options);
  }
}
