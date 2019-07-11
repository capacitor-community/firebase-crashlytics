declare module '@capacitor/core' {
  interface PluginRegistry {
    CrashlyticsPlugin: CrashlyticsProtocol;
  }
}

export type CrashlyticsUserOptions = {
  email: string;
  id: string;
  name: string;
};
export interface CrashlyticsProtocol {
  crash(): Promise<void>;
  logUser(options: CrashlyticsUserOptions): Promise<void>;
}
