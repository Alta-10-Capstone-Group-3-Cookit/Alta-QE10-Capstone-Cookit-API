package starter.Cookit.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    @Step("Post insert user cart positive")
    public void postInsertUserCartPositive(String ingredient_id) {
        Map<String, Object> json = new HashMap<>();
        json.put("ingredient_id", Integer.valueOf(ingredient_id));
        json.put("quantity", 2);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get list user carts")
    public void getListUserCarts(String page, String limit) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .queryParam("page", page)
                .queryParam("limit", limit);
    }

    @Step("Put update user cart")
    public void putUpdateUserCartPositive(String cart_id) {
        Map<String, Object> json = new HashMap<>();
        json.put("quantity", 1);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("cart_id", cart_id);
    }

    @Step("Delete user cart positive")
    public void deleteUserCartPositive(String cart_id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("cart_id", cart_id);
    }
}
