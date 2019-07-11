import { Plugins } from '@capacitor/core';
import { CrashlyticsProtocol } from './definitions';

const { CrashlyticsPlugin } = Plugins;

export class Crashlytics implements CrashlyticsProtocol {
  crash(): Promise<void> {
    return CrashlyticsPlugin.crash();
  }
}
