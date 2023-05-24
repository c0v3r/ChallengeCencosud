package com.cencosud.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ApiDefinitions {
    private  static  final  String  BASE_URL  =  "https://jsonplaceholder.typicode.com";
    RequestSpecification request;
    private  static  Response response;


    @When("User sets get all endpoint")
    public void getAll() {
        RestAssured.baseURI  =  BASE_URL;
        request  =  RestAssured.given();
        request.header("Content-Type",  "application/json");

        response = request.get("/posts");
    }

    @Then("statusCode equals 200")
    public void status_code_equals() {
        Assert.assertEquals(200,
                response.getStatusCode(), "Code does not match");
    }

    @When("User sets get by parameter endpoint")
    public void user_sets_get_by_parameter_endpoint(){
        RestAssured.baseURI  =  BASE_URL;
        request  =  RestAssured.given();

        response = request.get("/posts/1");
    }

    @Then("User receive a valid {string}")
    public void user_receive_a_valid(String title) {
        String actualTitle = getJsonPath(response, "title");
        Assert.assertEquals(title,actualTitle, "Title does not match");
    }

    public String getJsonPath(Response response, String key) {
        String rs = response.asString();
        JsonPath json = new JsonPath(rs);
        return json.get(key).toString();
    }
}