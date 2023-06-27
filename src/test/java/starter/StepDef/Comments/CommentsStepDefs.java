package starter.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Comments.Comments;
import starter.Cookit.Comments.CommentsResponses;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.InputStream;

public class CommentsStepDefs {

    @Steps
    Comments comments;

    @Given("{string} as valid recipe_id path, {string} as valid comment, and valid image file for post insert new recipe comment with valid recipe_id path, valid comment and valid image file")
    public void asValidRecipe_idPathAsValidCommentAndValidImageFileForPostInsertNewRecipeCommentWithValidRecipe_idPathValidCommentAndValidImageFile(String recipe_id, String comment) {
        File image = new File(Constants.ASSETS_DIR + "/comment_img.png");
        comments.postInsertNewCommentPositive(comment, image, Constants.RECIPE_ID);
    }

    @When("Send POST request for post insert new recipe comment with valid recipe_id path, valid comment and valid image file")
    public void sendPOSTRequestForPostInsertNewRecipeCommentWithValidRecipe_idPathValidCommentAndValidImageFile() {
        Constants.COMMENT_ID = SerenityRest.when().post(Constants.RECIPES + "/{recipe_id}/comments").jsonPath().getString("data.id");
    }

    @Then("API response for post insert new recipe comment with valid recipe_id path, valid comment and valid image file should return {int} Created status code")
    public void apiResponseForPostInsertNewRecipeCommentWithValidRecipe_idPathValidCommentAndValidImageFileShouldReturnCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("validate response body JSON Schema for post insert new recipe comment with valid recipe_id path, valid comment and valid image file")
    public void validateResponseBodyJSONSchemaForPostInsertNewRecipeCommentWithValidRecipe_idPathValidCommentAndValidImageFile() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Comments/PostInsertNewCommentPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body comment key for post insert new recipe comment with valid recipe_id path, valid comment and valid image file should be {string}")
    public void validateResponseBodyCommentKeyForPostInsertNewRecipeCommentWithValidRecipe_idPathValidCommentAndValidImageFileShouldBe(String comment) {
        SerenityRest.and().body(CommentsResponses.COMMENT, equalTo(comment));
    }

    @Given("valid recipe_id path, {string} as valid page parameter, and {string} as valid limit parameter for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter")
    public void asValidRecipe_idPathAsValidPageParameterAndAsValidLimitParameterForGetListOfRecipeCommentsWithValidRecipe_idPathValidPageParameterAndValidLimitParameter(String page, String limit) {
        comments.getListOfRecipeComment(Constants.RECIPE_ID, page, limit);
    }

    @When("Send GET request for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter")
    public void sendGETRequestForGetListOfRecipeCommentsWithValidRecipe_idPathValidPageParameterAndValidLimitParameter() {
        SerenityRest.when().get(Constants.RECIPES + "/{recipe_id}/comments");
    }

    @Then("API response for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter should return {int} OK status code")
    public void apiResponseForGetListOfRecipeCommentsWithValidRecipe_idPathValidPageParameterAndValidLimitParameterShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter")
    public void validateResponseBodyJSONSchemaForGetListOfRecipeCommentsWithValidRecipe_idPathValidPageParameterAndValidLimitParameter() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Comments/GetListRecipeCommentPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("valid recipe_id path, valid comment_id path, {string} as valid comment, and valid image file for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file")
    public void validRecipe_idPathValidComment_idPathAsValidCommentAndValidImageFileForPutUpdateRecipeCommentWithValidRecipe_idPathValidComment_idPathValidCommentAndValidImageFile(String comment) {
        File image = new File(Constants.ASSETS_DIR + "/comment_img.png");
        comments.putUpdateRecipeComment(Constants.RECIPE_ID, Constants.COMMENT_ID, comment, image);
    }

    @When("Send PUT request for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file")
    public void sendPUTRequestForPutUpdateRecipeCommentWithValidRecipe_idPathValidComment_idPathValidCommentAndValidImageFile() {
        SerenityRest.when().put(Constants.RECIPES + "/{recipe_id}/comments/{comment_id}");
    }

    @Then("API response for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file should return {int} OK status code")
    public void apiResponseForPutUpdateRecipeCommentWithValidRecipe_idPathValidComment_idPathValidCommentAndValidImageFileShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file")
    public void validateResponseBodyJSONSchemaForPutUpdateRecipeCommentWithValidRecipe_idPathValidComment_idPathValidCommentAndValidImageFile() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Comments/PutUpdateRecipeCommentPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateRecipeCommentWithValidRecipe_idPathValidComment_idPathValidCommentAndValidImageFileShouldBe(String message) {
        SerenityRest.and().body(CommentsResponses.MESSAGE, equalTo(message));
    }

    @Given("valid recipe_id path, valid comment_id path for delete recipe comment with valid recipe_id path and valid comment_id path")
    public void validRecipe_idPathValidComment_idPathForDeleteRecipeCommentWithValidRecipe_idPathAndValidComment_idPath() {
        comments.deleteRecipeCommentPositive(Constants.RECIPE_ID, Constants.COMMENT_ID);
    }

    @When("Send DELETE request for delete recipe comment with valid recipe_id path and valid comment_id path")
    public void sendDELETERequestForDeleteRecipeCommentWithValidRecipe_idPathAndValidComment_idPath() {
        SerenityRest.when().delete(Constants.RECIPES + "/{recipe_id}/comments/{comment_id}");
    }

    @Then("API response for delete recipe comment with valid recipe_id path and valid comment_id path should return {int} OK status code")
    public void apiResponseForDeleteRecipeCommentWithValidRecipe_idPathAndValidComment_idPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for delete recipe comment with valid recipe_id path and valid comment_id path")
    public void validateResponseBodyJSONSchemaForDeleteRecipeCommentWithValidRecipe_idPathAndValidComment_idPath() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Comments/DeleteRecipeCommentPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for delete recipe comment with valid recipe_id path and valid comment_id path should be {string}")
    public void validateResponseBodyMessageKeyForDeleteRecipeCommentWithValidRecipe_idPathAndValidComment_idPathShouldBe(String message) {
        SerenityRest.and().body(CommentsResponses.MESSAGE, equalTo(message));
    }
}
