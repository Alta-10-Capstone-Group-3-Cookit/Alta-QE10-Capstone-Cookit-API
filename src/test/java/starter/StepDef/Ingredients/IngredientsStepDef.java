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
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredients/PostInsertNewUser'sRecipesIngredientPositive.json");
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
}
