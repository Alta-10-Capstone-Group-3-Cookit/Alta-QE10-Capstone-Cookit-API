package starter.Cookit.Transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Transactions {
    @Step("Post Insert New User's Transaction")
    public void postInsertNewUsersTransaction(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get List Of User's Transaction")
    public void getListOfUsersTransaction(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
    @Step("Put update user's status transaction")
    public void PutUpdateUsersStatusTransaction(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
