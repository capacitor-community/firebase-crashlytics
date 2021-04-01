import { registerPlugin } from "@capacitor/core";
import type { FirebaseCrashlyticsPlugin } from "./definitions";

const FirebaseAnalytics = registerPlugin<FirebaseCrashlyticsPlugin>(
  "FirebaseCrashlytics",
  {
    web: () => import("./web").then((m) => new m.FirebaseCrashlyticsWeb()),
  }
);

export * from "./definitions";
export { FirebaseAnalytics };
