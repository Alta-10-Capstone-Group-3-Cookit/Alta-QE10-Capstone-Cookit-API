package starter.Cookit.Followers;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Followers {
    public static String idUserToFollow;
    public static int idUserToUnollow;

    @Step("Post follow user positive")
    public void postFollowUserPositive(String id) {
        Followers.idUserToFollow = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Delete unfollow user positive")
    public void deleteUnfollowUserPositive(int id) {
        Followers.idUserToUnollow = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Post Login User To Unfollow")
    public void postLoginUserToUnfollow(String username, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(user);
    }
}
