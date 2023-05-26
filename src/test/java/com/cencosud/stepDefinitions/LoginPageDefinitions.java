package com.cencosud.stepDefinitions;


import com.cencosud.pages.HomePage;
import com.cencosud.pages.LoginPage;
import com.cencosud.pages.MainPage;
import com.cencosud.utils.AppiumDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginPageDefinitions {
    public static AndroidDriver<MobileElement> mobileDriver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void start() {
        mobileDriver = AppiumDriverManager.getDriver();
    }

    @When("User enters username as {string} and password as {string}")
    public void login(String userName, String passWord) {
        mainPage = new MainPage();
        mainPage.clickGoToLoginPageBtn();

        loginPage = new LoginPage();
        loginPage.typeUserTxt(userName);
        loginPage.typePasswordTxt(passWord);
        loginPage.clickLoginBtn();
    }

    @Then("User should be able to login sucessfully")
    public void verifyLogin() {
        homePage = new HomePage();

        Assert.assertTrue(homePage.getGlobalFeedTab().isDisplayed(),
                "Titles of the website do not match");
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        loginPage = new LoginPage();

        Assert.assertEquals(loginPage.getErrorMsg().getText(), expectedErrorMessage);
    }

    @After
    public void teardown() {
        AppiumDriverManager.resetApp();
    }
}
