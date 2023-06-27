package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Users.Users;
import starter.Cookit.Users.UsersResponses;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.InputStream;

public class UsersStepdefs {

    @Steps
    Users users;

    @Given("Valid path for get show user profile with valid path")
    public void validPathForGetShowUserProfileWithValidPath() {
        users.getUserProfileValidPath();
    }

    @When("Send GET request for get show user profile with valid path")
    public void sendGETRequestForGetShowUserProfileWithValidPath() {
        Constants.OUR_USER_ID = SerenityRest.when().get(Constants.USERS).jsonPath().getString("data.id");
    }

    @Then("API response for get show user profile should return {int} OK status code")
    public void apiResponseForGetShowUserProfileShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get show user profile with valid path")
    public void validateResponseBodyJSONSchemaForGetShowUserProfileWithValidPath() {
//        File json = new File(Constants.JSON_SCHEMA_DIR + "Users/GetUserProfilePositive.json");
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/GetUserProfilePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Valid request body and valid profile picture for put update user profile with valid request body and valid profile picture")
    public void validRequestBodyAndValidProfilePictureForPutUpdateUserProfileWithValidRequestBodyAndValidProfilePicture() {
        File image = new File(Constants.ASSETS_DIR + "/profile.png");
        users.putUpdateUserPositive(Constants.USERNAME, "I Love Cooking", Constants.EMAIL, Constants.PASSWORD, image);
    }

    @When("Send PUT request for put update user profile with valid request body and valid profile picture")
    public void sendPUTRequestForPutUpdateUserProfileWithValidRequestBodyAndValidProfilePicture() {
        SerenityRest.when().put(Constants.USERS);
    }

    @Then("API response for put update user profile with valid request body and valid profile picture should return {int} OK status code")
    public void apiResponseForPutUpdateUserProfileWithValidRequestBodyAndValidProfilePictureShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update user profile with valid request body and valid profile picture")
    public void validateResponseBodyJSONSchemaForPutUpdateUserProfileWithValidRequestBodyAndValidProfilePicture() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/PutUpdateUserPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update user profile with valid request body and valid profile picture should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateUserProfileWithValidRequestBodyAndValidProfilePictureShouldBe(String message) {
        SerenityRest.and().body(UsersResponses.MESSAGE, equalTo(message));
    }

    @Given("{string} as valid username and {string} as valid offset parameter for get user by username")
    public void asValidUsernameAndAsValidOffsetParameterForGetUserByUsername(String username, String offset) {
        users.getUserByUsernamePositive(username, offset);
    }

    @When("Send GET request for get user by username with valid offset and valid username parameter")
    public void sendGETRequestForGetUserByUsernameWithValidOffsetAndValidUsernameParameter() {
        SerenityRest.when().get(Constants.USERS + "/search");
    }

    @Then("API response for get user by username with valid offset and valid username parameter should return {int} OK status code")
    public void apiResponseForGetUserByUsernameWithValidOffsetAndValidUsernameParameterShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get user by username with valid offset and valid username parameter")
    public void validateResponseBodyJSONSchemaForGetUserByUsernameWithValidOffsetAndValidUsernameParameter() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/GetUserByUsernamePositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body username key for get user by username with valid offset and valid username parameter should be {string}")
    public void validateResponseBodyUsernameKeyForGetUserByUsernameWithValidOffsetAndValidUsernameParameterShouldBe(String username) {
        SerenityRest.and().body(UsersResponses.USERNAME, equalTo(username));
    }

    @Given("{string} as valid id path for get user by id with valid id path")
    public void asValidIdPathForGetUserByIdWithValidIdPath(String id) {
        users.getUserByIdPositive(id);
    }

    @When("Send GET request for get user by id with valid id path")
    public void sendGETRequestForGetUserByIdWithValidIdPath() {
        SerenityRest.when().get(Constants.USERS + "/" + Users.idForGetUserById);
    }

    @Then("API response for get user by id with valid id path should return {int} OK status code")
    public void apiResponseForGetUserByIdWithValidIdPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get user by id with valid id path")
    public void validateResponseBodyJSONSchemaForGetUserByIdWithValidIdPath() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/GetUserByIdPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body id key for get user by id with valid id path should be {int}")
    public void validateResponseBodyIdKeyForGetUserByIdWithValidIdPathShouldBe(int id) {
        SerenityRest.and().body(UsersResponses.ID, equalTo(id));
    }

    @Given("Valid request body for put update user password with valid request body")
    public void validRequestBodyForPutUpdateUserPasswordWithValidRequestBody() {
        users.putUpdateUserPasswordPositive();
    }

    @When("Send PUT request for put update user password with valid request body")
    public void sendPUTRequestForPutUpdateUserPasswordWithValidRequestBody() {
        SerenityRest.when().put(Constants.USERS + "/password");
    }

    @Then("API response for put update user password with valid request body should return {int} OK status code")
    public void apiResponseForPutUpdateUserPasswordWithValidRequestBodyShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update user password with valid request body")
    public void validateResponseBodyJSONSchemaForPutUpdateUserPasswordWithValidRequestBody() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/PutUpdatePasswordPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update user password with valid request body should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateUserPasswordWithValidRequestBodyShouldBe(String message) {
        SerenityRest.and().body(UsersResponses.MESSAGE, equalTo(message));
    }

    @Given("Valid path for post upgrade verified user with valid path")
    public void validPathForPostUpgradeVerifiedUserWithValidPath() {
        users.postUpgradeVerifiedUserPositive();
    }

    @When("Send POST request for post upgrade verified user with valid path")
    public void sendPOSTRequestForPostUpgradeVerifiedUserWithValidPath() {
        SerenityRest.when().post(Constants.USERS + "/upgrade");
    }

    @Then("API response for post upgrade verified user with valid path should return {int} Created status code")
    public void apiResponseForPostUpgradeVerifiedUserWithValidPathShouldReturnCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for post upgrade verified user with valid path")
    public void validateResponseBodyJSONSchemaForPostUpgradeVerifiedUserWithValidPath() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/PostUpgradeVerifiedUserPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for post upgrade verified user with valid path should be {string}")
    public void validateResponseBodyMessageKeyForPostUpgradeVerifiedUserWithValidPathShouldBe(String message) {
        SerenityRest.and().body(UsersResponses.MESSAGE, equalTo(message));
    }

    @Given("{string} as valid page parameter and {string} as valid limit parameter for get list of user following with valid page and limit parameter")
    public void asValidPageParameterAndAsValidLimitParameterForGetListOfUserFollowingWithValidPageAndLimitParameter(String page, String limit) {
        users.getListUserFollowingPositive(page, limit);
    }

    @When("Send GET request for get list of user following with valid page and limit parameter")
    public void sendGETRequestForGetListOfUserFollowingWithValidPageAndLimitParameter() {
        SerenityRest.when().get(Constants.USERS + "/following");
    }

    @Then("API response for get list of user following with valid page and limit parameter should return {int} OK status code")
    public void apiResponseForGetListOfUserFollowingWithValidPageAndLimitParameterShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get list of user following with valid page and limit parameter")
    public void validateResponseBodyJSONSchemaForGetListOfUserFollowingWithValidPageAndLimitParameter() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Users/GetListUserFollowingPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
