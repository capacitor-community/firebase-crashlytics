declare module "@capacitor/core" {
  interface PluginRegistry {
    FirebaseCrashlytic: FirebaseCrashlyticsPlugin;
  }
}

export interface FirebaseCrashlyticsPlugin {
  crash(options: { message: string }): Promise<void>;
  setContext(options: ContextOptions): Promise<void>;
  setUserId(options: { userId: string }): Promise<void>;
  addLogMessage(options: { message: string }): Promise<void>;
  setEnabled(options: { enabled: boolean }): Promise<void>;
  isEnabled(): Promise<{ enabled: boolean }>;
  didCrashDuringPreviousExecution(): Promise<{ crashed: boolean }>;
  sendUnsentReports(): Promise<void>;
  deleteUnsentReports(): Promise<void>;
  recordException(options: iOSException | AndroidException): Promise<void>;
}

export interface ContextOptions {
  key: string;
  value: string | number | boolean;
  type: "string" | "long" | "double" | "boolean" | "int" | "float";
}

export interface iOSException {
  code?: number;
  domain?: string;
  message: string;
}

export interface AndroidException {
  message: string;
}
