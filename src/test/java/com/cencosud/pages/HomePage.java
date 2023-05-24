package com.cencosud.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.cencosud.utils.AppiumDriverManager;

public class HomePage {
    private static final By yourFeedTab = By.xpath("//android.widget.TextView[@text='Your feed']");
    private static final By globalFeedTab = By.xpath("//android.widget.TextView[@text='Global feed']");
}
