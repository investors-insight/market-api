package market.stock.api.stockmarketapi.dto;

import lombok.Getter;
import market.stock.api.stockmarketapi.domain.Test;

@Getter
public class TestCreateRequest {
    private String testValue;

    public Test toEntity() {
        return Test.builder()
            .testValue(testValue)
            .build();
    }
}
