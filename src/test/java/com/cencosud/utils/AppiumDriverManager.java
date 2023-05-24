package com.cencosud.utils;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumDriverManager {
    private static AppiumDriverManager instanceAppium = null;
    private final AppiumDriver<AndroidElement> mobileDriver;


    private AppiumDriverManager() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appWaitActivity", "com.conduitreactnative.MainActivity");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\herna\\IdeaProjects\\ChallengeCencosud\\bin\\app-qa-release_acid.apk");


        mobileDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public static AppiumDriverManager getInstanceAppium() throws MalformedURLException {
        if (instanceAppium == null)
            instanceAppium = new AppiumDriverManager();

        return instanceAppium;
    }

    public AppiumDriver<AndroidElement> getDriver() {
        return mobileDriver;
    }
}
