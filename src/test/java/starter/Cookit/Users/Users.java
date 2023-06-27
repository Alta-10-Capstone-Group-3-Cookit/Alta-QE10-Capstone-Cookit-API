package starter.Cookit.Users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Users {
    public static String idForGetUserById;

    @Step("Get user profile positive")
    public void getUserProfileValidPath() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Put update user positive")
    public void putUpdateUserPositive(String username, String bio, String email, String password, File image) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .multiPart("username", username)
                .multiPart("bio", bio)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("file", image);
    }

    @Step("Get user by username positive")
    public void getUserByUsernamePositive(String username, String offset) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .queryParam("q", username)
                .queryParam("offset", offset);
    }

    @Step("Get user by id positive")
    public void getUserByIdPositive(String id) {
        Users.idForGetUserById = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Put update user password positive")
    public void putUpdateUserPasswordPositive() {
        Map<String, Object> password = new HashMap<>();
        password.put("old_password", Constants.PASSWORD);
        password.put("new_password", "Asdfg123");
        password.put("password_confirmation", "Asdfg123");

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(password);
    }

    @Step("Post upgrade verified user positive")
    public void postUpgradeVerifiedUserPositive() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Get list user following positive")
    public void getListUserFollowingPositive(String page, String limit) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .queryParam("page", page)
                .queryParam("limit", limit);
    }
}
