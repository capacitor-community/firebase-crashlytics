import { Plugins } from '@capacitor/core';
import { FirebaseCrashlyticsPlugin, ContextOptions } from './definitions';

const { FirebaseCrashlytics: FBCrashlytics } = Plugins;

export class FirebaseCrashlytics implements FirebaseCrashlyticsPlugin {
    setUserId(options: { userId: string; }): Promise<void> {
        return FBCrashlytics.setUserId(options);
    }

    addLogMessage(options: { message: string; }): Promise<void> {
        return FBCrashlytics.addLogMessage(options);
    }

    setEnabled(options: { enabled: boolean; }): Promise<void> {
        return FBCrashlytics.setEnabled(options);
    }

    crash(): Promise<void> {
        return FBCrashlytics.crash();
    }

    setContext(options: ContextOptions): Promise<void> {
        return FBCrashlytics.logContext(options);
    }

}