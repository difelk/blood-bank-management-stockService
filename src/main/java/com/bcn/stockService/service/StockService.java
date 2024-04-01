package com.bcn.stockService.service;

import com.bcn.stockService.data.Stock;
import com.bcn.stockService.data.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        try {
            return stockRepository.findAll();
        } catch (Exception e) {
            System.out.println("Failed to fetch all stocks: " + e.getMessage());
            return null;
        }
    }

    public Stock getStockByDate(Date date) {
        try {
            return stockRepository.getStockByDate(date);
        } catch (Exception e) {
            System.out.println("Failed to find stock by Date: " + e.getMessage());
            return null;
        }
    }

}
