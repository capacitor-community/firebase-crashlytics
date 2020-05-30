import { Plugins } from '@capacitor/core';
import { FirebaseCrashlyticsPlugin as FBCrashlyticsPlugin, ContextOptions } from './definitions';

const { FirebaseCrashlyticsPlugin } = Plugins;

export class FirebaseCrashlytics implements FBCrashlyticsPlugin {
    setUserId(options: { userId: string; }): Promise<void> {
        return FirebaseCrashlyticsPlugin.setUserId(options);
    }

    addLogMessage(options: { message: string; }): Promise<void> {
        return FirebaseCrashlyticsPlugin.addLogMessage(options);
    }

    setEnabled(options: { enabled: boolean; }): Promise<void> {
        return FirebaseCrashlyticsPlugin.setEnabled(options);
    }

    crash(): Promise<void> {
        return FirebaseCrashlyticsPlugin.crash();
    }

    setContext(options: ContextOptions): Promise<void> {
        return FirebaseCrashlyticsPlugin.logContext(options);
    }

}