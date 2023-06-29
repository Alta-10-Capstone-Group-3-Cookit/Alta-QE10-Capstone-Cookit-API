package starter.StepDef.Ingredients;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Ingredients.Ingredients;
import starter.Utils.Constants;

import java.io.File;

public class IngredientsStepDef {
    @Steps
    Ingredients ingredients;

    @Given("Post insert new recipe's ingredients with valid recipe id and json body")
    public void postInsertNewRecipesIngredientsWithValidRecipeIdAndJsonBody(){
        ingredients.postInsertNewRecipesIngredient("Paket Puas", 100000);
    }

    @When("Send Post insert new recipe's ingridients")
    public void sendPostInsertNewRecipeSIngridients() {
        SerenityRest.when().post(Constants.RECIPES+"/"+Constants.RECIPE_ID+"/ingredients");
    }

    @And("Validate post insert new recipe's ingredients with valid recipe id and json body json schema")
    public void validatePostInsertNewRecipeSIngredientsWithValidRecipeIdAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredients/PostInsertNewRecipe'sIngredientPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update recipe's ingredients with valid recipe id and ingredient id and json body")
    public void putUpdateRecipeSIngredientsWithValidRecipeIdAndIngredientIdAndJsonBody() {
        ingredients.putUpdateRecipesIngredient("Paket Puas", 100000);
    }

    @When("Send Put update recipe's ingredients")
    public void sendPutUpdateRecipeSIngredients() {
        SerenityRest.when().put(Constants.RECIPES+"/"+Constants.RECIPE_ID+"/ingredients/" + Constants.INGREDIENT_ID);
    }

    @And("Validate put update recipe's ingredients with valid recipe id and ingredient id and json body json schema")
    public void validatePutUpdateRecipeSIngredientsWithValidRecipeIdAndIngredientIdAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredients/PutUpdateIngredientRecipe.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Delete Recipe's Ingredient

    @Given("Delete recipe's ingredients with valid recipe id and ingredient id")
    public void deleteRecipeSIngredientsWithValidRecipeIdAndIngredientId() {
        ingredients.deleteRecipesIngredients();
    }

    @When("Send Delete recipe's ingredients Id")
    public void sendDeleteRecipeSIngredientsId() {
        SerenityRest.when().delete(Constants.RECIPES+"/"+Constants.RECIPE_ID+"/ingredients/"+Constants.INGREDIENT_ID);
    }
    @And("And Validate delete recipe's ingredients with valid recipe id and ingredient id json schema")
    public void andValidateDeleteRecipeSIngredientsWithValidRecipeIdAndIngredientIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredients/DeleteRecipeIngredients.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete recipe's ingredients with valid recipe id")
    public void deleteRecipeSIngredientsWithValidRecipeId() {
        ingredients.deleteRecipesIngredients();
    }

    @When("Send Delete recipe's ingredients")
    public void sendDeleteRecipeSIngredients() {
        SerenityRest.when().delete(Constants.RECIPES+"/"+Constants.RECIPE_ID+"/ingredients");
    }

    @And("Validate delete recipe's ingredients with valid recipe id json schema")
    public void validateDeleteRecipeSIngredientsWithValidRecipeIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredients/DeleteRecipeIngredients.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
