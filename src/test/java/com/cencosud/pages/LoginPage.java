package com.cencosud.pages;

import com.cencosud.utils.AppiumDriverManager;
import com.cencosud.utils.WaitManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {
    public static final String INVALIDFORMATEMAIL_LBL = "//android.widget.TextView[@text='The email format is invalid']";
    public static final String LOGIN_BTN = "//android.widget.TextView[@text='Sign In']";
    public static final String USER_TXT = "//android.widget.EditText[@text='Ex: email@dominio.com']";
    public static final String PASSWORD_TXT = "//android.widget.EditText[@text='Password']";
    public static AndroidDriver<MobileElement> mobileDriver;
    public static final int TIMEOUT = 5;


    public LoginPage() {
        mobileDriver = AppiumDriverManager.getDriver();
    }
    public void typeUserTxt(String user){
        WaitManager.waitForElement(mobileDriver, USER_TXT, TIMEOUT );
        mobileDriver.findElement(By.xpath(USER_TXT)).sendKeys(user);
    }

    public void typePasswordTxt(String pass){
        mobileDriver.findElement(By.xpath(PASSWORD_TXT)).sendKeys(pass);
    }

    public void clickLoginBtn(){
        mobileDriver.findElement(By.xpath(LOGIN_BTN)).click();
    }

    public MobileElement getErrorMsg(){
        WaitManager.waitForElement(mobileDriver, INVALIDFORMATEMAIL_LBL, TIMEOUT);
        return mobileDriver.findElement(By.xpath(INVALIDFORMATEMAIL_LBL));
    }
}
