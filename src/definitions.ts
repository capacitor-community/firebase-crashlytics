declare module "@capacitor/core" {
  interface PluginRegistry {
    FirebaseCrashlytics: FirebaseCrashlyticsPlugin;
  }
}

export interface FirebaseCrashlyticsPlugin {
  crash(): Promise<void>;
  setContext(options: ContextOptions): Promise<void>;
  setUserId(options: { userId: string }): Promise<void>;
  addLogMessage(options: { message: string }): Promise<void>;
  setEnabled(options: { enabled: boolean }): Promise<void>;
}

export interface ContextOptions {
  key: string;
  value: string | number | boolean;
  type: 'string' | 'long' | 'double' | 'boolean' | 'int' | 'float';
}
