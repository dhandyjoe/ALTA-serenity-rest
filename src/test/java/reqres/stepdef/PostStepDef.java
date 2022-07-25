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

public class PostStepDef {

    @Steps
    ReqresApi reqresApi;

    // POST CREATE USER
    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/CreateUser.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void  statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain name {string} and {string}")
    public void responseBodyShouldContainNameAnd(String name, String job) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.JOB, equalTo(job));
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // POST REGISTER SUCCESSFULL
    @Given("Post register with valid json file")
    public void postRegisterWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/RegisterUser.json");
        reqresApi.postRegisterUser(jsonFiles);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresApi.POST_REGISTER_USER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then().body(ReqresResponse.ID, equalTo(id))
                .body(ReqresResponse.TOKEN, equalTo(token));
    }

    @And("Post register user assert json validation")
    public void postRegisterUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostRegisterUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // POST REGISTER UNSUCCESS
    @Given("Post register with invalid json file")
    public void postRegisterWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/UnsuccessRegisterUser.json");
        reqresApi.postRegisterUser(jsonFiles);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then().body(ReqresResponse.ERROR, equalTo(error));
    }

    @And("Post unsuccess register user assert json validation")
    public void postUnsuccessRegisterUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostRegisterUnsuccessUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    // POST LOGIN SUCCESS
    @Given("Post login with valid json file")
    public void postLoginWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/LoginUser.json");
        reqresApi.postLoginUser(jsonFiles);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresApi.POST_LOGIN_USER);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponse.TOKEN, equalTo(token));
    }

    @And("Post success login user assert json validation")
    public void postSuccessLoginUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostLoginUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    // POST LOGIN UNSUCCESS
    @Given("Post login with invalid json file")
    public void postLoginWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/UnsuccessLoginUser.json");
        reqresApi.postLoginUser(jsonFiles);
    }

    @And("Post unsuccess login user assert json validation")
    public void postUnsuccessLoginUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostLoginUnsuccessUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
