package starter.Cookit.Admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Admin {
    @Step("Post Login Admin")
    public void postLoginAdmin(String username, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(user);
    }

    @Step("Get list verify")
    public void getListVerify() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Put Admin Verify")
    public void putAdminVerify(String status) {
        Map<String, Object> verify = new HashMap<>();
        verify.put("status", status);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(verify);
    }
}