package com.bcn.stockService.controller;

import com.bcn.stockService.data.StockItem;
import com.bcn.stockService.data.StockItems;
import com.bcn.stockService.data.StockResponse;
import com.bcn.stockService.service.StockItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StockItemsController {

    @Autowired
    private StockItemsService stockItemsService;

    @GetMapping(path = "/stock-items")
    public List<StockItems> getAllStockItems() {
        return stockItemsService.getAllStockItems();
    }

    @GetMapping(path = "/stock-items/{stockDate}")
    public List<StockItems> getStockItemsByDate(@PathVariable Date stockDate) {
        return stockItemsService.getStockItemsByDate(stockDate);
    }

    @PostMapping(path = "/stock-items")
    public StockResponse createStockItems(@RequestBody StockItem stockItem){
        System.out.println("called post stock item controller");
        return stockItemsService.createStockItems(stockItem);
    }

    @PutMapping(path = "/stock-items")
    public StockResponse updateStockItems(@RequestBody StockItem stockItem){
        System.out.println("received an put request to the stock");
        return stockItemsService.updateStockItems(stockItem);
    }
}
