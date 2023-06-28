package starter.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Carts.Cart;
import starter.Cookit.Carts.CartResponses;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class CartStepDefs {

    @Steps
    Cart cart;

    @Given("Valid request body json for post insert new user cart with valid request body json")
    public void validRequestBodyJsonForPostInsertNewUserCartWithValidRequestBodyJson() {
        cart.postInsertUserCartPositive(Constants.INGREDIENT_ID);
    }

    @When("Send POST request for post insert new user cart with valid request body json")
    public void sendPOSTRequestForPostInsertNewUserCartWithValidRequestBodyJson() {
        Constants.CART_ID = SerenityRest.when().post(Constants.USERS + "/carts").jsonPath().getString("data.id");
    }

    @Then("API response for post insert new user cart with valid request body json should return {int} Created status code")
    public void apiResponseForPostInsertNewUserCartWithValidRequestBodyJsonShouldReturnCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for post insert new user cart with valid request body json")
    public void validateResponseBodyJSONSchemaForPostInsertNewUserCartWithValidRequestBodyJson() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Carts/PostInsertUserCartPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for post insert new user cart with valid request body json should be {string}")
    public void validateResponseBodyMessageKeyForPostInsertNewUserCartWithValidRequestBodyJsonShouldBe(String message) {
        SerenityRest.and().body(CartResponses.MESSAGE, equalTo(message));
    }

    @Given("{string} as valid page parameter and {string} as valid limit parameter for get list user carts with valid page parameter and valid limit parameter")
    public void asValidPageParameterAndAsValidLimitParameterForGetListUserCartsWithValidPageParameterAndValidLimitParameter(String page, String limit) {
        cart.getListUserCarts(page, limit);
    }

    @When("Send GET request for get list user carts with valid page parameter and valid limit parameter")
    public void sendGETRequestForGetListUserCartsWithValidPageParameterAndValidLimitParameter() {
        SerenityRest.when().get(Constants.USERS + "/carts");
    }

    @Then("API response for get list user carts with valid page parameter and valid limit parameter should return {int} OK status code")
    public void apiResponseForGetListUserCartsWithValidPageParameterAndValidLimitParameterShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get list user carts with valid page parameter and valid limit parameter")
    public void validateResponseBodyJSONSchemaForGetListUserCartsWithValidPageParameterAndValidLimitParameter() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Carts/GetListUserCartsPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for get list user carts with valid page parameter and valid limit parameter should be {string}")
    public void validateResponseBodyMessageKeyForGetListUserCartsWithValidPageParameterAndValidLimitParameterShouldBe(String message) {
        SerenityRest.and().body(CartResponses.MESSAGE, equalTo(message));
    }

    @Given("valid cart_id path and valid request body json for put update user cart with valid cart_id path and valid request body json")
    public void validCart_idPathAndValidRequestBodyJsonForPutUpdateUserCartWithValidCart_idPathAndValidRequestBodyJson() {
        cart.putUpdateUserCartPositive(Constants.CART_ID);
    }

    @When("Send PUT request for put update user cart with valid cart_id path and valid request body json")
    public void sendPUTRequestForPutUpdateUserCartWithValidCart_idPathAndValidRequestBodyJson() {
        SerenityRest.when().put(Constants.USERS + "/carts/{cart_id}");
    }

    @Then("API response for put update user cart with valid cart_id path and valid request body json should return {int} OK status code")
    public void apiResponseForPutUpdateUserCartWithValidCart_idPathAndValidRequestBodyJsonShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update user cart with valid cart_id path and valid request body json")
    public void validateResponseBodyJSONSchemaForPutUpdateUserCartWithValidCart_idPathAndValidRequestBodyJson() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Carts/PutUpdateUserCartPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update user cart with valid cart_id path and valid request body json should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateUserCartWithValidCart_idPathAndValidRequestBodyJsonShouldBe(String message) {
        SerenityRest.and().body(CartResponses.MESSAGE, equalTo(message));
    }

    @Given("valid cart_id path for delete user cart with valid card_id path")
    public void validCart_idPathForDeleteUserCartWithValidCard_idPath() {
        cart.deleteUserCartPositive(Constants.CART_ID);
    }

    @When("Send DELETE request for delete user cart with valid card_id path")
    public void sendDELETERequestForDeleteUserCartWithValidCard_idPath() {
        SerenityRest.when().delete(Constants.USERS + "/carts/{cart_id}");
    }

    @Then("API response for delete user cart with valid card_id path should return {int} OK status code")
    public void apiResponseForDeleteUserCartWithValidCard_idPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for put update user cart with valid card_id path")
    public void validateResponseBodyJSONSchemaForPutUpdateUserCartWithValidCard_idPath() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Carts/DeleteUserCartPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for put update user cart with valid card_id path should be {string}")
    public void validateResponseBodyMessageKeyForPutUpdateUserCartWithValidCard_idPathShouldBe(String message) {
        SerenityRest.and().body(CartResponses.MESSAGE, equalTo(message));
    }
}
