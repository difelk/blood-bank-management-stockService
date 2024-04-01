package com.bcn.stockService.controller;


import com.bcn.stockService.data.Donor;
import com.bcn.stockService.data.Stock;
import com.bcn.stockService.data.StockItem;
import com.bcn.stockService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(path = "/stocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping(path = "/stocks/{date}")
    public Stock getStockByDate(@PathVariable Date date) {
        return stockService.getStockByDate(date);
    }

//    @GetMapping(path = "/stocks")
//    public String getAllStocks() {
//        return "stock called";
//    }
//
//    @PostMapping(path = "/stocks")
//    public String createStock(@RequestBody Donor donor) {
//        return "Stock created for donor: " + donor.getDonorNic();
//    }
//
//    @PutMapping(path = "/stocks/{id}")
//    public String updateStock(@PathVariable String id, @RequestBody StockItem stockItem) {
//        return "received new donation from " + stockItem.getDonorNic() + " blood type of "  + stockItem.getBloodType();
//    }
}


