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
}

export interface ContextOptions {
  key: string;
  value: string | number | boolean;
  type: "string" | "long" | "double" | "boolean" | "int" | "float";
}
