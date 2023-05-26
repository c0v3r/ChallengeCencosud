package com.cencosud.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {
    private static AndroidDriver<MobileElement> mobileDriver;


    private static AndroidDriver<MobileElement> init() {
        String pathApk = System.getProperty("user.dir") +"\\bin\\app-qa-release_acid.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.conduitreactnative.MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, pathApk);

        try {
            mobileDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return mobileDriver;
    }

    public static AndroidDriver<MobileElement> getDriver() {
        if (mobileDriver == null) {
            mobileDriver = init();
        }
        return mobileDriver;
    }

    public static void resetApp() {
        mobileDriver.resetApp();
    }
}
