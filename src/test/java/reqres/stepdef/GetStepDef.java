package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import reqres.api.ReqresApi;
import reqres.response.ReqresResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.Matchers.equalTo;

public class GetStepDef {

    @Steps
    ReqresApi reqresApi;

    // GET LIST USER
    @When("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresApi.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(reqresApi.GET_LIST_USER);
    }

    @Then("Status coded should be {int}")
    public void statusCodedShouldBeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain {string} and {string}")
    public void responseBodyShouldContainFirstNameAndLastName(String firstName, String lastName) {
        SerenityRest.then().body(ReqresResponse.FIRST_NAME, equalTo(firstName))
                .body(ReqresResponse.LAST_NAME, equalTo(lastName));
    }

    @And("Get list user assert json validation")
    public void getListUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetListUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // GET SINGLE USER
    @Given("Get single user with id {string}")
    public void getSingleUserWithId(String idUser) {
        reqresApi.getSingleUser(idUser);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_USER);
    }

    @And("Response body single user should contain {string} and {string}")
    public void responseBodySingleUserShouldContainAnd(String firstName, String lastName) {
        SerenityRest.then().body(ReqresResponse.FIRST_NAME_SINGLE, equalTo(firstName))
                .body(ReqresResponse.LAST_NAME_SINGLE, equalTo(lastName));
    }

    @And("Get single user assert json validation")
    public void getSingleUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetSingleUserJsonValidation.json");

//        URL url;
//        try {
//            url = new URL("https://reqres.in/api/users/1");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }

        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // GET LIST RESOURCE
    @Given("Get list resource")
    public void getListResource() {
        reqresApi.getListResource();
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresApi.GET_LIST_RESOURCE);
    }

    @And("Response body resource should contain {string} and {int}")
    public void responseBodyResourceShouldContainAnd(String name, int year) {
        SerenityRest.then().body(ReqresResponse.NAME_RESOURCES, equalTo(name))
                .body(ReqresResponse.YEAR_RESOURCES, equalTo(year));
    }

    @And("Get list resource assert json validation")
    public void getListResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetListResourceJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // GET SINGLE RESOURCE
    @Given("Get single resource with id {string}")
    public void getSingleResource(String idUser) {
        reqresApi.getSingleResource(idUser);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_RESOURCE);
    }

    @And("Get single resource assert json validation")
    public void getSingleResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetSingleResourcesJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
