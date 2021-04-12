
  Pod::Spec.new do |s|
    s.name = 'CapacitorCommunityFirebaseCrashlytics'
    s.version = '0.1.0'
    s.summary = 'A native plugin for firebase crashlytics'
    s.license = 'MIT'
    s.homepage = 'https://github.com/capacitor-community/firebase-crashlytics'
    s.author = 'Priyank Patel <priyank.patel@stackspace.ca>'
    s.source = { :git => 'https://github.com/capacitor-community/firebase-crashlytics', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '12.0'
    s.static_framework = true
    s.dependency 'Capacitor'
    s.dependency 'Firebase/Crashlytics'
  end
