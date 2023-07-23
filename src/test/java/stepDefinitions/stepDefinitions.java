package stepDefinitions;

import Pojo.Request.BoqSetter;
import Pojo.Request.boq_items;
import Pojo.Response.Boq;
import Pojo.Response.Groups;
import Resources.ApiResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static junit.framework.TestCase.*;

public class stepDefinitions extends Utils {

    ResponseSpecification resSpec;
    RequestSpecification reqSpec;
    Response response;
    Boq boq;
    String[] PM_TR_data;
    TestDataBuild testData = new TestDataBuild();

    @Given("boq payload with {int} sets")
    public void boqPayloadWithSets(int BoqCount) throws IOException {

        //testData.ExcelData();
        PM_TR_data = testData.readTextFile(BoqCount);
        reqSpec = given().spec(requestSpecification()).body(testData.sendBoq(BoqCount, PM_TR_data));
    }

    @When("User calls {string} payload with {string} methodfrom the client machine")
    public void userCallsPayloadWithMethodfromTheClientMachine(String resource, String method) {
        ApiResources resourceAPI = ApiResources.valueOf(resource);
        System.out.println(resourceAPI.getResources());
        response = testData.methodSelector(method, reqSpec, resourceAPI, resSpec);
        boq = response.then().spec(responseSpecification()).extract().as(Boq.class);
        //System.out.println(boq.getGroups().size());
    }

    @Then("verify if the response has given success code")
    public void verify_if_the_reponse_has_given_success_code() {
        assertEquals(boq.getStatus().getstatus_code(), 1);
        assertEquals(boq.getStatus().getStatus_type(), "SUCCESS");
    }

    @Then("verify if group id is returned successfully")
    public void verify_if_group_id_is_returned_successfully() {
        // Write code here that turns the phrase above into concrete actions

        for (int i = 0; i < boq.getGroups().size(); i++) {
            System.out.println(boq.getGroups().get(i).getMd5_hash());
            System.out.println(boq.getGroups().get(i).getGroup_id());
        }
        for (int i = 0; i < boq.getGroups().size(); i++) {
            if (boq.getGroups().isEmpty() || boq.getGroups().get(i).getMd5_hash().isEmpty()) {
                System.out.println("Test case failed");
            } else {
                System.out.println("Test passed");
            }
        }
    }


    @Then("Extract Group Id from the response")
    public void extract_group_id_from_the_response() {


    }

    @Then("calls the create Order API")
    public void calls_the_create_order_api() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify if the status code")
    public void verify_if_the_status_code() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify if the order id gets generated")
    public void verify_if_the_order_id_gets_generated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
