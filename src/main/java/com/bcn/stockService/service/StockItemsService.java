package com.bcn.stockService.service;

import com.bcn.stockService.data.StockItem;
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

    public List<StockItems> getStockItemsByDate(Date stockDate) {
        System.out.println("called get stock items by date with data of : " + stockDate);
        try {
            System.out.println("received stocked on : " + stockItemRepository.getStockItemsByDate(stockDate).get(0).getStockDate());
            return stockItemRepository.getStockItemsByDate(stockDate);
        } catch (Exception e) {
            System.out.println("Failed to find stock items by Date: " + e.getMessage());
            return null;
        }
    }

    public StockItems isDateExists(Date stockDate) {
        return stockItemRepository.isDateExists(stockDate);
    }

    public StockItems createStockItems(StockItem stockItem) {
        System.out.println("stockItem in service - " + stockItem.getDonorNic());

// In this scenario, we have a new stock item, which means this stock item's date does not exist in the stock item table.
// Therefore, we need to create a new stock item.
// Before that, since we have data in the stockItem object but the database has data organized in the "stockItems" object,
// you need to first create a stock items object here and use a switch case to check the stock item blood type (above stockItem parameter donor blood type).
// Then assign the correct setter method with the blood type quantity and set other blood types as 0.
// Then you can create the save query by passing the whole newly created stockItems object.
//once the stock item successful then send the stockItem qty to the stock tb.
        // for testing I commented out the save method.
        //and return null because method is expecting return value
        //also created meaningful respond method for all the requests


        return null;
//        return stockItemRepository.save(stockItems);
    }
}
