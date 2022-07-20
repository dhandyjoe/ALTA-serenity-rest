package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import reqres.api.ReqresApi;
import reqres.response.ReqresResponse;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
        SerenityRest.then().body(ReqresResponse.FIRST_NAME, equalTo(firstName));
        SerenityRest.then().body(ReqresResponse.LAST_NAME, equalTo(lastName));
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
    public void statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain name {string} and {string}")
    public void responseBodyShouldContainNameAnd(String name, String job) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(name));
        SerenityRest.then().body(ReqresResponse.JOB, equalTo(job));
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

    @Given("Delete user with id {string}")
    public void deleteUserWithParameter(String idUser) {
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
