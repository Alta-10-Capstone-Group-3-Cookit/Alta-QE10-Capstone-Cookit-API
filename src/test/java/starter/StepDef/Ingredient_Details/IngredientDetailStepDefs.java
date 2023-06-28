package starter.StepDef.Ingredient_Details;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;
import starter.Cookit.Ingredient_Details.IngredientDetailResponses;
import starter.Cookit.Ingredient_Details.IngredientDetails;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class IngredientDetailStepDefs {

    @Steps
    IngredientDetails ingDetails;

    @Given("valid recipe_id path, valid ingredient_id path, and valid request body json for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json")
    public void validRecipe_idPathValidIngredient_idPathAndValidRequestBodyJsonForPostInsertIngredientDetailWithValidRecipe_idPathValidIngredient_idPathAndValidRequestBodyJson() {
        ingDetails.postInsertIngredientDetailPositive(Constants.RECIPE_ID, Constants.INGREDIENT_ID);
    }

    @When("Send POST request for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json")
    public void sendPOSTRequestForPostInsertIngredientDetailWithValidRecipe_idPathValidIngredient_idPathAndValidRequestBodyJson() {
//        SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/ingredients/{ingredient_id}/ingredientDetails");
        Constants.INGREDIENT_DETAIL_ID = String.valueOf(SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/ingredients/{ingredient_id}/ingredientDetails").jsonPath().getInt("data.id"));
    }

    @Then("API response for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json should return {int} Created status code")
    public void apiResponseForPostInsertIngredientDetailWithValidRecipe_idPathValidIngredient_idPathAndValidRequestBodyJsonShouldReturnCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json")
    public void validateResponseBodyJSONSchemaForPostInsertIngredientDetailWithValidRecipe_idPathValidIngredient_idPathAndValidRequestBodyJson() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredient_Details/PostInsertIngredientDetailPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json should be {string}")
    public void validateResponseBodyMessageKeyForPostInsertIngredientDetailWithValidRecipe_idPathValidIngredient_idPathAndValidRequestBodyJsonShouldBe(String message) {
        SerenityRest.and().body(IngredientDetailResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path, valid ingredient_detail_id path, and valid request body json for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json")
    public void validRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJsonForPutUpdateIngredientDetailWithValidRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJson() {
        ingDetails.putUpdateIngredientDetailPositive(Constants.RECIPE_ID, Constants.INGREDIENT_DETAIL_ID);
    }

    @When("Send PUT request for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json")
    public void sendPUTRequestForPutUpdateIngredientDetailWithValidRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJson() {
        SerenityRest.when().put(Constants.RECIPES + "/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}");
    }

    @Then("API response for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json should return {int} OK status code")
    public void apiResponseForPutUpdateIngredientDetailWithValidRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJsonShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json")
    public void validateResponseBodyJSONSchemaForPutUpdateIngredientDetailWithValidRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJson() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredient_Details/PutUpdateIngredientPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json should be {string}")
    public void validateResponseBodyForPutUpdateIngredientDetailWithValidRecipe_idPathValidIngredient_detail_idPathAndValidRequestBodyJsonShouldBe(String message) {
        SerenityRest.and().body(IngredientDetailResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path and valid ingredient_detail_id path for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path")
    public void validRecipe_idPathAndValidIngredient_detail_idPathForDeleteIngredientDetailWithValidRecipe_idPathAndValidIngredient_detail_idPath() {
        ingDetails.deleteIngredientDetailsPositive(Constants.RECIPE_ID, Constants.INGREDIENT_DETAIL_ID);
    }

    @When("Send DELETE request for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path")
    public void sendPUTRequestForDeleteIngredientDetailWithValidRecipe_idPathAndValidIngredient_detail_idPath() {
        SerenityRest.when().delete(Constants.RECIPES + "/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}");
    }

    @Then("API response for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path should return {int} OK status code")
    public void apiResponseForPutDeleteIngredientDetailWithValidRecipe_idPathAndValidIngredient_detail_idPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path")
    public void validateResponseBodyJSONSchemaForDeleteIngredientDetailWithValidRecipe_idPathAndValidIngredient_detail_idPath() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Ingredient_Details/DeleteIngredientDetailPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path should be {string}")
    public void validateResponseBodyForDeleteIngredientDetailWithValidRecipe_idPathAndValidIngredient_detail_idPathShouldBe(String message) {
        SerenityRest.and().body(IngredientDetailResponses.MESSAGE, equalTo(message));
    }
}
