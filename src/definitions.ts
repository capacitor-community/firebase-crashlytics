export interface FirebaseCrashlyticsPlugin {
  /**
   * Forces a crash to test the implementation.
   *
   * Only available for Android and iOS.
   */
  crash(options: { message: string }): Promise<void>;
  /**
   * Sets a custom key and value that is associated with subsequent fatal and non-fatal reports.
   *
   * Only available for Android and iOS.
   */
  setContext(options: ContextOptions): Promise<void>;
  /**
   * Sets a user ID (identifier) that is associated with subsequent fatal and non-fatal reports.
   *
   * Only available for Android and iOS.
   */
  setUserId(options: { userId: string }): Promise<void>;
  /**
   * Adds a log message that is sent with your crash data.
   * Only visible in the Crashlytics dashboard.
   *
   * Only available for Android and iOS.
   */
  addLogMessage(options: { message: string }): Promise<void>;
  /**
   * Enables/disables automatic data collection.
   * The value does not apply until the next run of the app.
   *
   * Only available for Android and iOS.
   */
  setEnabled(options: { enabled: boolean }): Promise<void>;
  /**
   * Returns whether or not automatic data collection is enabled.
   *
   * Only available for iOS.
   */
  isEnabled(): Promise<{ enabled: boolean }>;
  /**
   * Returns whether the app crashed during the previous execution.
   *
   * Only available for Android and iOS.
   */
  didCrashDuringPreviousExecution(): Promise<{ crashed: boolean }>;
  /**
   * Uploads any unsent reports to Crashlytics.
   * When automatic data collection is enabled, Crashlytics automatically uploads reports at startup.
   *
   * Only available for Android and iOS.
   */
  sendUnsentReports(): Promise<void>;
  /**
   * Deletes any unsent reports on the device.
   *
   * Only available for Android and iOS.
   */
  deleteUnsentReports(): Promise<void>;
  /**
   * Records a non-fatal report to send to Crashlytics.
   *
   * Only available for Android and iOS.
   */
  recordException(options: RecordExceptionOptions): Promise<void>;
}

export interface ContextOptions {
  key: string;
  value: string | number | boolean;
  type: 'string' | 'long' | 'double' | 'boolean' | 'int' | 'float';
}

export interface RecordExceptionOptions {
  message: string;
  /**
   * Error code within a specific error domain.
   *
   * Only available for iOS.
   */
  code?: number;
  /**
   * A string containing the error domain.
   *
   * Only available for iOS.
   */
  domain?: string;
}
