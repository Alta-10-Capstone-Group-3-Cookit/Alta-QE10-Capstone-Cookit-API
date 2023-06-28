package starter.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Recipes.Recipes;
import starter.Utils.Constants;

import java.io.File;

public class RecipesStepDef {
    @Steps
    Recipes recipes;

    // Post insert new user's recipes

    @Given("Post insert new user's recipes with valid path and valid data")
    public void postInsertNewUsersRecipesWithValidPathAndValidData(){
        File image = new File(Constants.ASSETS_DIR+"/nasgor_gila.png");
        recipes.postInsertNewUsersRecipesWithValidPathAndData("Test Nasgor", "Nasi digoreng", image);
    }
    @When("Send post insert new user's recipes")
    public void sendPostInsertNewUsersRecipes(){
        SerenityRest.when().post(Constants.RECIPES);
    }
    @And("Validate post insert new user's recipes with valid path and valid data json schema")
    public void validatePostInsertNewUsersRecipesWithValidPathAndValidData (){
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Recipes/PostInsertNewUser'sRecipesPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Get List Recipes

    @Given("Get list recipes with valid path")
    public void getListRecipesWithValidPath() {
        recipes.getListRecipesWithValidPath();
    }

    @When("Send get list recipes")
    public void sendGetListRecipes() {
        SerenityRest.when().get(Constants.RECIPES);
    }

    @And("And Validate get list recipes with valid path json schema")
    public void andValidateGetListRecipesWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/GetListRecipesPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Put Update User's Recipe

    @Given("Put update user's recipe with valid recipe id and valid json body")
    public void putUpdateUserSRecipeWithValidRecipeIdAndValidJsonBody() {
        recipes.putUpdateUsersRecipe("Nasi Gila", "Nasi dengan banyak topping");
    }

    @When("Send put update user's recipes")
    public void sendPutUpdateUserSRecipes() {
        SerenityRest.when().put(Constants.RECIPES + "/" + Constants.RECIPE_ID);
    }

    @And("Validate put update user's recipes with valid recipe id and valid json body json schema")
    public void validatePutUpdateUserSRecipesWithValidRecipeIdAndValidJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/PutUpdateUser'sRecipePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Post Like User's Recipe
    @Given("Post like user's recipe with valid recipe id")
    public void postLikeUserSRecipeWithValidRecipeId() {
        recipes.postLikeUsersRecipes();
    }

    @When("Send Post like user's recipe")
    public void sendPostLikeUserSRecipe() {
        SerenityRest.when().post(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/like");
    }

    @And("Validate Post like user's recipe with valid recipe id json schema")
    public void validatePostLikeUserSRecipeWithValidRecipeIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/PutUpdateUser'sRecipePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Get Timeline Of Recipes

    @Given("Get timeline of recipes with valid path")
    public void getTimelineOfRecipesWithValidPath() {
        recipes.getTimelineOfRecipes();
    }

    @When("Send Get timeline of recipes")
    public void sendGetTimelineOfRecipes() {
        SerenityRest.when().get(Constants.USERS+"/recipes/timeline");
    }

    @And("Validate Get timeline of recipes with valid path json schema")
    public void validateGetTimelineOfRecipesWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/GetTimelineOfRecipesPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Get List Of Trending Recipes
    @Given("Get list of trending recipes with valid path")
    public void getListOfTrendingRecipesWithValidPath() {
        recipes.getListOfTrendingRecipes();
    }

    @When("Send Get list of trending recipes")
    public void sendGetListOfTrendingRecipes() {
        SerenityRest.when().get(Constants.RECIPES+"/trending");
    }

    @And("Validate Get list of trending recipes with valid path json schema")
    public void validateGetListOfTrendingRecipesWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/GetListOfTrendingRecipesPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Delete unlike user's recipe

    @Given("Delete unlike user's recipe with valid recipe id")
    public void deleteUnlikeUserSRecipeWithValidRecipeId() {
        recipes.deleteUnlikeUsersRecipe();
    }

    @When("Send Delete unlike user's recipe")
    public void sendDeleteUnlikeUserSRecipe() {
        SerenityRest.when().delete(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/unlike");
    }

    @And("Validate Delete unlike user's recipe with valid recipe id json schema")
    public void validateDeleteUnlikeUserSRecipeWithValidRecipeIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Recipes/PutUpdateUser'sRecipePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
