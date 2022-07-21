package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.simple.parser.JSONParser;
import reqres.api.ReqresApi;
import reqres.response.ReqresResponse;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresApi reqresApi;

    @When("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresApi.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(reqresApi.GET_LIST_USER);
    }

    @Then("Status coded should be {int} OK")
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
        File jsonFile = new File(ReqresApi.JSON_FILE+"GetListUserJsonValidation.json");

        URL url;
        try {
            url = new URL("https://reqres.in/api/users?page=2");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(url));
    }

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/CreateUser.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(reqresApi.POST_CREATE_USER);
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
        File jsonFile = new File(ReqresApi.JSON_FILE+"/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Put update user with id {string} valid json file")
    public void putUpdateUserWithValidJsonFile(String idUser) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/UpdateUser.json");
        reqresApi.putUpdateUser(jsonFiles, idUser);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(reqresApi.PUT_UPDATE_USER);
    }

    @And("Put update user assert json validation")
    public void putUpateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/PutUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Delete user with id {string}")
    public void deleteUserWithParwwameter(String idUser) {
        reqresApi.deleteUser(idUser);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(reqresApi.DELETE_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
