package reqres.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresApi {

    public static final String URL = "https://reqres.in/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json/";

    // GET
    public static String GET_LIST_USER = URL+"api/users?page={page}";
    public static String GET_SINGLE_USER = URL+"api/users/{id}";
    public static String GET_LIST_RESOURCE = URL+"api/unknown";
    public static String GET_SINGLE_RESOURCE = URL+"api/unknown/{id}";

    // POST
    public static String POST_CREATE_USER = URL+"api/users";
    public static String POST_REGISTER_USER = URL+"api/register";
    public static String POST_LOGIN_USER = URL+"api/login";

    // PUT
    public static String PUT_UPDATE_USER = URL+"api/users/{id}";

    // DELETE
    public static String DELETE_USER = URL+"api/users/{id}";

    // PATCH
    public static String PATCH_UPDATE_USER = URL+"/api/users/2";

    @Step("Get list user")
    public void getListUser(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get single user")
    public void getSingleUser(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get list resource")
    public void getListResource() {
        SerenityRest.given();
    }

    @Step("Get single resource")
    public void getSingleResource(String idUser) {
        SerenityRest.given()
                .pathParam("id", idUser);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login user")
    public void postLoginUser(File json) {
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

    @Step("Patch update user")
    public void patchUpdateUser(File json, String idUser) {
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
