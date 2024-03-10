package market.stock.api.stockmarketapi.repository;

import market.stock.api.stockmarketapi.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
