package com.cencosud.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.cencosud.utils.AppiumDriverManager;

public class LoginPage {
    private static final By userTxt = By.xpath("//android.widget.EditText[@text='Ex: email@dominio.com']");
    private static final By passTxt = By.xpath("//android.widget.EditText[@text='Password']");
    private static final By loginBtn = By.xpath("//android.widget.TextView[@text='Sign In']");
}
