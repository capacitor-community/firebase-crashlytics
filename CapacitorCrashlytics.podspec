
  Pod::Spec.new do |s|
    s.name = 'CapacitorCrashlytics'
    s.version = '0.0.1'
    s.summary = 'Enable Firebase Crashlytics for Capacitor Apps'
    s.license = 'MIT'
    s.homepage = 'https://github.com/stewwan/capacitor-crashlytics'
    s.author = 'Stewan Silva'
    s.source = { :git => 'https://github.com/stewwan/capacitor-crashlytics', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
    s.dependency 'Firebase'
    s.dependency 'FirebaseCore'
    s.dependency 'Fabric'
    s.dependency 'Crashlytics'
  end