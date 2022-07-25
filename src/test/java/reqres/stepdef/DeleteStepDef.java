package reqres.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import reqres.api.ReqresApi;

public class DeleteStepDef {

    @Steps
    ReqresApi reqresApi;

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
