package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import reqres.api.ReqresApi;

import java.io.File;

public class PatchStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Patch update user with id {string} valid json file")
    public void patchUpdateUserWithID (String idUser) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/UpdateUser.json");
        reqresApi.putUpdateUser(jsonFiles, idUser);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(reqresApi.PUT_UPDATE_USER);
    }

    @And("Patch update user assert json validation")
    public void patchUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
