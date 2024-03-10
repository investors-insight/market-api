package market.stock.api.stockmarketapi.dto;

import lombok.Getter;
import market.stock.api.stockmarketapi.domain.Test;

@Getter
public class TestResponse {
    private String testValue;

    public static TestResponse of(Test test) {
        TestResponse response = new TestResponse();

        response.testValue = test.getTestValue();

        return response;
    }
}
