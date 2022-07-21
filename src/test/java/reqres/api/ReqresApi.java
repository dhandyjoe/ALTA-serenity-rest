package reqres.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresApi {

    public static final String URL = "https://reqres.in/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json/";

    public static String GET_LIST_USER = URL+"api/users?page={page}";
    public static String POST_CREATE_USER = URL+"api/users";
    public static String PUT_UPDATE_USER = URL+"api/users/{id}";
    public static String DELETE_USER = URL+"api/users/{id}";

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
    public void putUpdateUser(File json, String idUser) {
        SerenityRest.given()
                .pathParam("id", idUser)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(String idUser) {
        SerenityRest.given()
                .pathParam("id", idUser);
    }
}
