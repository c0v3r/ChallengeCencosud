package com.cencosud.pages;

import com.cencosud.utils.AppiumDriverManager;
import com.cencosud.utils.WaitManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {
    public static AndroidDriver<MobileElement> mobileDriver;

    public static final String YOUR_FEED_TAB = "//android.widget.TextView[@text='Your feed']";
    public static final String GLOBAL_FEED_TAB = "//android.widget.TextView[@text='Global feed']";
    public static final int TIMEOUT = 5;

    public HomePage() {
        mobileDriver = AppiumDriverManager.getDriver();
    }
    public MobileElement getYourFeedTab(){
        return mobileDriver.findElement(By.xpath(YOUR_FEED_TAB));
    }
    public MobileElement getGlobalFeedTab(){

        WaitManager.waitForElement(mobileDriver, GLOBAL_FEED_TAB, TIMEOUT);
        return mobileDriver.findElement(By.xpath(GLOBAL_FEED_TAB));
    }
}
