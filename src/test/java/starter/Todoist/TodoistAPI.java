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
}
