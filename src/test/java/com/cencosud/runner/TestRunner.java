package com.cencosud.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
                 glue = {"com.cencosud.stepDefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests{
}
