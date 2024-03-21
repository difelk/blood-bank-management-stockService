package com.bcn.stockService.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItems, Integer> {
}
