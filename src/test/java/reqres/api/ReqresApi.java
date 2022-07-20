package reqres.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;

import java.io.File;

public class ReqresApi {

    public static final String URL = "https://reqres.in/";
    public static final String DIR = System.getProperty("user.dir");
    public static String GET_LIST_USER = URL+"api/users?page={page}";
    public static String POST_CREATE_USER = URL+"api/users";

    @Step("Get list user")
    public void getListUser(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void updateUser() {

    }

    @Step("Delete user")
    public void deleteUser(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
}
