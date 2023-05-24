package starter.Todoist;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class TodoistAPI {

    @Step("Post create")
    public void postCreate(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //  ---------
//  KHUSUS DIPANGGIL HANYA SAAT SEND REQUEST POST CREATE SUCCESS/ POSITIF CASE
    @Step("Send post create for valid id path and request body")
    public void sendValidPostCreate(String url) {
        Constants.AVAILABLE_ID_PATH = SerenityRest.when().post(url).jsonPath().getString("id");
    }
//  ---------

    @Step("Get single")
    public void getSingle(String idPath) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Post update")
    public void postUpdate(String idPath, File json) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Delete")
    public void deleteSomething(String idPath) {
        Constants.ID_PATH = idPath;
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
