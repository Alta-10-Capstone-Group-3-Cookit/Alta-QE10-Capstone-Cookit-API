package starter.Cookit.Followers;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class Followers {
    public static String idUserToFollow;

    @Step("Post follow user positive")
    public void postFollowUserPositive(String id) {
        Followers.idUserToFollow = id;
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
