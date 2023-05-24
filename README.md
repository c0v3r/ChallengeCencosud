Requirements
- Windows operating system
- Java 8+
- Node.js 14+
- Appium Server GUI 
- Android SDK or Android Studio
- Set JAVA_HOME as an environment variable
- Set ANDROID_HOME as an environment variable
- npm install -g appium-doctor (Check if everything you need to start with Appium is correct)
- appium-doctor --android

Running tests
Important: To run the test are absolutely necessary two conditions:
- The emulator should be running (Android).
- Appium Server should be running.

mvn test