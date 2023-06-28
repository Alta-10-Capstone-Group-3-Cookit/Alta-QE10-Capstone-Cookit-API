package starter.Cookit.Ingredients;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Ingredients {
    @Step("Post Insert New Recipe's Ingredient")
    public void postInsertNewRecipesIngredient(String name, int price) {
        Map<String, Object> ingredient = new HashMap<>();
        ingredient.put("name", name);
        ingredient.put("price", price);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(ingredient);
    }

    @Step("Put Update Recipe's Ingredient")
    public void putUpdateRecipesIngredient(String name, int price) {
        Map<String, Object> ingredient = new HashMap<>();
        ingredient.put("name", name);
        ingredient.put("price", price);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(ingredient);
    }
    @Step("Delete recipe's ingredients")
    public void deleteRecipesIngredients(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}