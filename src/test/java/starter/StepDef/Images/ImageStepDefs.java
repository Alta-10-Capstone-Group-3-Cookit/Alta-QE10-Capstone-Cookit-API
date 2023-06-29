package starter.StepDef.Images;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;
import starter.Cookit.Images.Images;
import starter.Cookit.Images.ImagesResponses;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class ImageStepDefs {

    @Steps
    Images images;

    @Given("valid recipe_id path and valid image for post insert recipe image with valid recipe_id path and valid image file")
    public void validRecipe_idPathAndValidImageForPostInsertRecipeImageWithValidRecipe_idPathAndValidImageFile() {
        File recipe_img = new File(Constants.ASSETS_DIR + "/comment_img.png");
        images.postInsertRecipeImagePositive(Constants.RECIPE_ID, recipe_img);
    }

    @When("Send POST request for post insert recipe image with valid recipe_id path and valid image file")
    public void sendPOSTRequestForPostInsertRecipeImageWithValidRecipe_idPathAndValidImageFile() {
//        SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/images");
        Constants.IMAGE_ID = SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/images").jsonPath().getString("data[0].id");
    }

    @Then("API response for post insert recipe image with valid recipe_id path and valid image file should return {int} Created status code")
    public void apiResponseForPostInsertRecipeImageWithValidRecipe_idPathAndValidImageFileShouldReturnCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for post insert recipe image with valid recipe_id path and valid image file")
    public void validateResponseBodyJSONSchemaForPostInsertRecipeImageWithValidRecipe_idPathAndValidImageFile() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Images/PostInserRecipeImagePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for post insert recipe image with valid recipe_id path and valid image file should be {string}")
    public void validateResponseBodyMessageKeyForPostInsertRecipeImageWithValidRecipe_idPathAndValidImageFileShouldBe(String message) {
        SerenityRest.and().body(ImagesResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path for delete recipe image by recipe id")
    public void validRecipe_idPathForDeleteRecipeImageByRecipeId() {
//        Post image first
        File recipe_img = new File(Constants.ASSETS_DIR + "/comment_img.png");
        images.postInsertRecipeImagePositive(Constants.RECIPE_ID, recipe_img);
        SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/images");

        images.deleteAllRecipeImagesPositive(Constants.RECIPE_ID);
    }

    @When("Send DELETE request for delete recipe image by recipe_id")
    public void sendDELETERequestForDeleteRecipeImageByRecipe_id() {
        SerenityRest.when().delete(Constants.RECIPES + "/{recipe_id}/images");
    }

    @Then("API response for delete recipe image by recipe_id should return {int} OK status code")
    public void apiResponseForDeleteRecipeImageByRecipe_idShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for delete recipe image by recipe_id")
    public void validateResponseBodyJSONSchemaForDeleteRecipeImageByRecipe_id() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Images/DeleteAllRecipeImagesPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for delete recipe image by recipe_id should be {string}")
    public void validateResponseBodyMessageKeyForDeleteRecipeImageByRecipe_idShouldBe(String message) {
        SerenityRest.and().body(ImagesResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path, valid image_id path, and valid image file for put update recipe image with valid recipe_id path, valid image_id path, and valid image file")
    public void validRecipe_idPathValidImage_idPathAndValidImageFileForPutUpdateRecipeImageWithValidRecipe_idPathValidImage_idPathAndValidImageFile() {
        File img = new File(Constants.ASSETS_DIR + "/recipe_img.png");
        images.putUpdateRecipeImage(Constants.RECIPE_ID, Constants.IMAGE_ID, img);
    }

    @When("Send PUT request for put update recipe image with valid recipe_id path, valid image_id path, and valid image file")
    public void sendPUTRequestForPutUpdateRecipeImageWithValidRecipe_idPathValidImage_idPathAndValidImageFile() {
        SerenityRest.when().put(Constants.RECIPES + "/{recipe_id}/images/{image_id}");
    }

    @Then("API response for put update recipe image with valid recipe_id path, valid image_id path, and valid image file should return {int} OK status code")
    public void apiResponseForPutUpdateRecipeImageWithValidRecipe_idPathValidImage_idPathAndValidImageFileShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update recipe image with valid recipe_id path, valid image_id path, and valid image file")
    public void validateResponseBodyJSONSchemaForPutUpdateRecipeImageWithValidRecipe_idPathValidImage_idPathAndValidImageFile() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Images/PutUpdateRecipeImagePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update recipe image with valid recipe_id path, valid image_id path, and valid image file should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateRecipeImageWithValidRecipe_idPathValidImage_idPathAndValidImageFileShouldBe(String message) {
        SerenityRest.and().body(ImagesResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path and valid image_id path for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path")
    public void validRecipe_idPathAndValidImage_idPathForDeleteRecipeImageByRecipe_idAndImage_idWithValidRecipe_idPathAndValidImage_idPath() {
        images.deleteCertainRecipeImagePositive(Constants.RECIPE_ID, Constants.IMAGE_ID);
    }

    @When("Send DELETE request for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path")
    public void sendDELETERequestForDeleteRecipeImageByRecipe_idAndImage_idWithValidRecipe_idPathAndValidImage_idPath() {
        SerenityRest.when().delete(Constants.RECIPES + "/{recipe_id}/images/{image_id}");
    }

    @Then("API response for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path should return {int} OK status code")
    public void apiResponseForDeleteRecipeImageByRecipe_idAndImage_idWithValidRecipe_idPathAndValidImage_idPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path")
    public void validateResponseBodyJSONSchemaForDeleteRecipeImageByRecipe_idAndImage_idWithValidRecipe_idPathAndValidImage_idPath() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Images/DeleteCertainRecipeImagePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path should be {string}")
    public void validateResponseBodyMessageKeyForDeleteRecipeImageByRecipe_idAndImage_idWithValidRecipe_idPathAndValidImage_idPathShouldBe(String message) {
        SerenityRest.and().body(ImagesResponses.MESSAGE, equalTo(message));
    }
}
