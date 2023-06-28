package starter.Cookit.Recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Recipes {

    @Step("Post insert new user's recipes with valid path and data")
    public void postInsertNewUsersRecipesWithValidPathAndData(String name, String description, File image){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .multiPart("name", name)
                .multiPart("description", description)
                .multiPart("image", image);
    }
    @Step("Get list recipes with valid path")
    public void getListRecipesWithValidPath(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Put Update User's Recipe")
    public void putUpdateUsersRecipe(String name, String description){
        Map<String, Object> recipe = new HashMap<>();
        recipe.put("name", name);
        recipe.put("description", description);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(recipe);
    }

    @Step("Post Like User's Recipes")
    public void postLikeUsersRecipes(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step("Get Timeline Of Recipes")
    public void getTimelineOfRecipes(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Get List Of Trending Recipes")
    public void getListOfTrendingRecipes(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Delete Unlike User's Recipe")
    public void deleteUnlikeUsersRecipe(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Get details of recipes")
    public void getDetailsOfRecipe(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
