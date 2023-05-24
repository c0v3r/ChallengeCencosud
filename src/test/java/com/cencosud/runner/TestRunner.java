package com.cencosud.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
                 features = {"src/test/resources/features/LoginPage.feature","src/test/resources/features/Api.feature"},
                 glue = {"com.cencosud.stepDefinitions"},
                 plugin = {})
public class TestRunner extends AbstractTestNGCucumberTests{
}
