package market.stock.api.stockmarketapi.controller;

import lombok.RequiredArgsConstructor;
import market.stock.api.stockmarketapi.dto.TestCreateRequest;
import market.stock.api.stockmarketapi.dto.TestResponse;
import market.stock.api.stockmarketapi.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity<TestResponse> getTestById(
        @PathVariable Long id
    ) {
        TestResponse response = testService.getTestById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> createTest(
        @RequestBody TestCreateRequest request
    ) {
        Long testId = testService.createTest(request);

        URI url = URI.create(String.format("/test/%d", testId));
        return ResponseEntity.created(url)
            .build();
    }
}
