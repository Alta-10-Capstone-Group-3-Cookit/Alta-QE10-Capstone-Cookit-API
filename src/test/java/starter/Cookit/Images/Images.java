package starter.Cookit.Images;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class Images {

    @Step("Post insert recipe image positive")
    public void postInsertRecipeImagePositive(String recipe_id, File img) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .multiPart("image", img);
    }

    @Step("Delete all recipe images")
    public void deleteAllRecipeImagesPositive(String recipe_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id);
    }

    @Step("Put update recipe image")
    public void putUpdateRecipeImage(String recipe_id, String image_id, File img) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id)
                .multiPart("image", img);
    }

    @Step("Delete certain recipe image positive")
    public void deleteCertainRecipeImagePositive(String recipe_id, String image_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id);
    }
}
