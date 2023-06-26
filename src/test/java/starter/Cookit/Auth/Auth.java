package starter.Cookit.Auth;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Auth {
    @Step("Post Register User With Valid Path And Json Body")
    public void postRegisterUserWithValidPathAndJsonBody(String username, String email, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("email", email);
        user.put("password", password);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(user);
    }

    @Step("Post Login User With Valid Path")
    public void postLoginUserWithValidPath(String username, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(user);
    }
}
