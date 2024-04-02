package com.bcn.stockService.controller;

import com.bcn.stockService.data.StockItem;
import com.bcn.stockService.data.StockItems;
import com.bcn.stockService.service.StockItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StockItemsController {

    @Autowired
    private StockItemsService stockItemsService;

    @GetMapping(path = "/stock-items")
    public List<StockItems> getAllStockItems() {

        //do the frontend mapping and show in stock table
        // stock and the stock items both need to fetch and show in frontend.
        // no need to do the modals' data. I will do those, once you completed the data mapping.
        return stockItemsService.getAllStockItems();
    }

    @GetMapping(path = "/stock-items/{stockDate}")
    public List<StockItems> getStockItemsByDate(@PathVariable Date stockDate) {

//        already implemented this in donor history to check stock already exist
        //can verify this working. no changes need to be done in here.

        return stockItemsService.getStockItemsByDate(stockDate);
    }

    @PostMapping(path = "/stock-items")
    public StockItems createStockItems(@RequestBody StockItem stockItem){
        System.out.println("called post stock item controller");
// I have already fixed the stock item issues here. Check the createStockItems method.
// I explained the next step.
// Also, we need to create a stock items PUT endpoint.
// But there is an issue: when we send blood type, NIC, and quantity to update stock items(from donor history to stock items),
// we cannot identify which stock item needs to be reduced or incremented.
// Since we store all the data in each blood type, there is no way to specify or catch the updating quantity.
// Either we have to create another table called stock item details
// and put id, NIC, data, blood type, and quantity of that day.
// If we use this approach, when stock item is called, first we need to update the stock item details table,
// then the stock item once the stock item details are successful,
// and finally the stock table.
//I have already finished the donor history to send data to stock. you can try it with frontend end . but get a latest from
//all the repos first
        return stockItemsService.createStockItems(stockItem);
    }
}
