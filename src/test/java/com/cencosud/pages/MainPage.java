package com.cencosud.pages;

import com.cencosud.utils.AppiumDriverManager;
import com.cencosud.utils.WaitManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage {
    public static final String XPATH_GOTO_LOGINPAGE_IMG = "//android.widget.Button[@content-desc='Login, tab, 2 of 2']/android.widget.ImageView";
    public static AndroidDriver<MobileElement> mobileDriver;
    public static final int TIMEOUT = 5;

    public MainPage() {
        mobileDriver = AppiumDriverManager.getDriver();
    }

    public void clickGoToLoginPageBtn(){
        WaitManager.waitForElement(mobileDriver, XPATH_GOTO_LOGINPAGE_IMG, TIMEOUT );
        mobileDriver.findElement(By.xpath(XPATH_GOTO_LOGINPAGE_IMG)).click();
    }
}
