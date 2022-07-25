package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import reqres.api.ReqresApi;
import reqres.response.ReqresResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Put update user with id {string} valid json file")
    public void putUpdateUserWithValidJsonFile(String idUser) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/UpdateUser.json");
        reqresApi.putUpdateUser(jsonFiles, idUser);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(reqresApi.PUT_UPDATE_USER);
    }

    @And("Put update user assert json validation")
    public void putUpateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Put update user with id {string} name key only json file")
    public void putUpdateUserWithIdInvalidJsonFile(String idUser) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutNameOnlyUpdateUser.json");
        reqresApi.putUpdateUser(jsonFiles, idUser);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String firstName) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(firstName));
    }

    @And("Put update user assert name key only json validation")
    public void putUpdateUserAssertInvalidJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutNameKeyUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Put update user with id {string} job key only json file")
    public void putUpdateUserWithIdJobKeyOnlyJsonFile(String idUser) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutJobOnlyUpdateUser.json");
        reqresApi.putUpdateUser(jsonFiles, idUser);
    }

    @And("Response body should contain job {string}")
    public void responseBodyShouldContainJob(String job) {
        SerenityRest.then().body(ReqresResponse.JOB, equalTo(job));
    }

    @And("Put update user assert job key only json validation")
    public void putUpdateUserAssertJobKeyOnlyJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutJobKeyUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
