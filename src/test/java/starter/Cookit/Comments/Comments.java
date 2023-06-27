package starter.Cookit.Comments;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class Comments {

    @Step("Post insert new comment positive")
    public void postInsertNewCommentPositive(String comment, File image, String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .multiPart("comment", comment)
                .multiPart("image", image)
                .pathParam("recipe_id", id);
    }

    @Step("Get list of recipe comment positive")
    public void getListOfRecipeComment(String id, String page, String limit) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .queryParam("page", page)
                .queryParam("limit", limit)
                .pathParam("recipe_id", id);
    }

    @Step("Put update recipe comments positive")
    public void putUpdateRecipeComment(String recipe_id, String comment_id, String comment, File image) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .multiPart("comment", comment)
                .multiPart("image", image)
                .pathParam("recipe_id", recipe_id)
                .pathParam("comment_id", comment_id);
    }

    @Step("Delete recipe comment positive")
    public void deleteRecipeCommentPositive(String recipe_id, String comment_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("comment_id", comment_id);
    }
}
