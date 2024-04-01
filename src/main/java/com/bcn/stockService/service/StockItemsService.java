package com.bcn.stockService.service;

import com.bcn.stockService.data.StockItemRepository;
import com.bcn.stockService.data.StockItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StockItemsService {

    @Autowired
    private StockItemRepository stockItemRepository;

    public List<StockItems> getAllStockItems() {
        try {
            return stockItemRepository.findAll();
        } catch (Exception e) {
            System.out.println("Failed to fetch all stock items: " + e.getMessage());
            return null;
        }
    }

    public StockItems getStockItemsByDate(Date stockDate) {
        try {
            return stockItemRepository.getStockItemsByDate(stockDate);
        } catch (Exception e) {
            System.out.println("Failed to find stock items by Date: " + e.getMessage());
            return null;
        }
    }public StockItems isDateExists(Date stockDate){
        return stockItemRepository.isDateExists(stockDate);
    }

    public StockItems createStockItems(StockItems stockItems){
        return stockItemRepository.save(stockItems);
    }
}
