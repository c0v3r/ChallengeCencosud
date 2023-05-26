package com.cencosud.stepDefinitions;

import com.cencosud.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Base {
    public DesiredCapabilities capabilities;
    public static AppiumDriver<MobileElement> mobileDriver;

    @Before
    public void start() throws MalformedURLException {
        /*String pathApk = System.getProperty("user.dir") +"\\bin\\app-qa-release_acid.apk";
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability(MobileCapabilityType.APP, pathApk);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appWaitActivity", "com.conduitreactnative.MainActivity");

        mobileDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
        mobileDriver = AppiumDriverManager.getDriver();
    }

    @After
    public void teardown() {
        mobileDriver.resetApp();
    }
}
