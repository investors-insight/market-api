package market.stock.api.stockmarketapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import market.stock.api.stockmarketapi.domain.Test;
import market.stock.api.stockmarketapi.dto.TestCreateRequest;
import market.stock.api.stockmarketapi.dto.TestResponse;
import market.stock.api.stockmarketapi.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public TestResponse getTestById(Long id) {
        Test test = testRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);

        return TestResponse.of(test);
    }

    @Transactional
    public Long createTest(TestCreateRequest request) {
        Test test = request.toEntity();

        test = testRepository.save(test);

        return test.getId();
    }
}
