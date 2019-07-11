declare module '@capacitor/core' {
  interface PluginRegistry {
    CrashlyticsPlugin: CrashlyticsProtocol;
  }
}

export interface CrashlyticsProtocol {
  crash(): Promise<void>;
}
