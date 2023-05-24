package com.cencosud.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class WaitManager {
    public static boolean waitForElement(AndroidDriver<MobileElement> mobileDriver, String locator, int timeOutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return mobileDriver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
