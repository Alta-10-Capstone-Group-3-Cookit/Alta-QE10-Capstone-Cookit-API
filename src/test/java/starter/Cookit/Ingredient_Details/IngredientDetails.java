package starter.Cookit.Ingredient_Details;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class IngredientDetails {

    @Step("Post insert ingredient detail positive")
    public void postInsertIngredientDetailPositive(String recipe_id, String ingredient_id) {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Gula Pasir");
        json.put("quantity", 100);
        json.put("unit", "g");

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id);
    }

    @Step("Put update ingredient detail positive")
    public void putUpdateIngredientDetailPositive(String recipe_id, String ingredient_detail_id) {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Gula Aren");
        json.put("price", "50g");

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id);
    }
}
