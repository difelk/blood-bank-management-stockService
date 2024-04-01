package com.bcn.stockService.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Integer> {

    @Query("select st from Stock st where st.stockDate=?1")
    Stock getStockByDate(Date date);

}
