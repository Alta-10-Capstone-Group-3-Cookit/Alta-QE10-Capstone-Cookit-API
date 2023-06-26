package starter.Cookit.Auth;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Auth {
    @Step("Post Login User")
    public void postLoginUser(String username, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(user);
    }
}
