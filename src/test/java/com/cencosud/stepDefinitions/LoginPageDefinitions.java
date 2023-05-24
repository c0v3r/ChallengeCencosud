package com.cencosud.stepDefinitions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginPageDefinitions {
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> mobileDriver;


    @Given("User launches the application")
    public void launchApp() throws MalformedURLException {
        String path = "C:\\Users\\herna\\IdeaProjects\\ChallengeCencosud\\bin\\app-qa-release_acid.apk";

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability(MobileCapabilityType.APP, path);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appWaitActivity", "com.conduitreactnative.MainActivity");

        mobileDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @When("User enters username as {string} and password as {string}")
    public void login(String userName, String passWord) {
        new WebDriverWait(mobileDriver, 90).until(ExpectedConditions.elementToBeClickable(mobileDriver.findElementByXPath("//android.widget.Button[@content-desc='Login, tab, 2 of 2']/android.widget.ImageView")));
        mobileDriver.findElementByXPath("//android.widget.Button[@content-desc='Login, tab, 2 of 2']/android.widget.ImageView").click();

        WebDriverWait wait = new WebDriverWait(mobileDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Ex: email@dominio.com']")));

        mobileDriver.findElementByXPath("//android.widget.EditText[@text='Ex: email@dominio.com']").sendKeys(userName);
        mobileDriver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(passWord);
        mobileDriver.findElementByXPath("//android.widget.TextView[@text='Sign In']").click();
    }

    @Then("User should be able to login sucessfully")
    public void verifyLogin() {
        WebDriverWait wait = new WebDriverWait(mobileDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your feed']")));

        Assert.assertTrue(mobileDriver.findElementByXPath("//android.widget.TextView[@text='Your feed']").isDisplayed(),
                "Titles of the website do not match");
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(mobileDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='The email format is invalid']")));

        String actualErrorMessage = mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='The email format is invalid']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @AfterMethod
    public void teardown() {
        mobileDriver.resetApp();
    }
}
