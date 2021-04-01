import { WebPlugin } from "@capacitor/core";

import {
  FirebaseCrashlyticsPlugin,
  ContextOptions,
  iOSException,
  AndroidException,
} from "./definitions";

export class FirebaseCrashlyticsWeb
  extends WebPlugin
  implements FirebaseCrashlyticsPlugin {
  constructor() {
    super({
      name: "FirebaseCrashlytic",
      platforms: ["web"],
    });
  }

  setUserId(_options: { userId: string }): Promise<void> {
    return new Promise((resolve, _reject) => resolve);
  }

  addLogMessage(_options: { message: string }): Promise<void> {
    return new Promise((resolve, _reject) => resolve);
  }

  setEnabled(_options: { enabled: boolean }): Promise<void> {
    return new Promise((resolve, _reject) => resolve);
  }

  crash(): Promise<void> {
    throw new Error("Method not implemented.");
  }

  setContext(options: ContextOptions): Promise<void> {
    console.log(options);
    return new Promise((resolve, _reject) => resolve);
  }

  isEnabled(): Promise<{ enabled: boolean }> {
    throw new Error("Method not implemented.");
  }

  didCrashDuringPreviousExecution(): Promise<{ crashed: boolean }> {
    throw new Error("Method not implemented.");
  }

  sendUnsentReports(): Promise<void> {
    throw new Error("Method not implemented.");
  }

  deleteUnsentReports(): Promise<void> {
    throw new Error("Method not implemented.");
  }

  recordException(_options: iOSException | AndroidException): Promise<void> {
    throw new Error("Method not implemented.");
  }
}
