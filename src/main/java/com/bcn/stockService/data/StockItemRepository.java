package com.bcn.stockService.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface StockItemRepository extends JpaRepository<StockItems, Integer> {

    @Query("select si from StockItems si where si.stockDate=?1")
    List<StockItems> getStockItemsByDate(Date stockDate);

    @Query("select si from StockItems si where si.stockDate=?1 order by date(stockDate) desc limit 1")
    StockItems isDateExists(Date stockDate);
}
