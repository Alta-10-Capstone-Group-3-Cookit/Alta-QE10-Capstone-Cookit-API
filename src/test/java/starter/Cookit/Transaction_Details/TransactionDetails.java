package starter.Cookit.Transaction_Details;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class TransactionDetails {

    @Step("Get list user transactions")
    public void getListUserTransactionPositive(String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("transaction_detail_id", id);
    }
}
