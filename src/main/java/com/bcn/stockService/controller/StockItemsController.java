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
        /* When making a donation in the frontend,
         ensure that the donation data is not already in the stock item table.
        I have already implemented logic that updates the stock item table
        with the same date as the donation for PUT requests.
        Therefore, when creating a donation, use a date that is not in the database.*/




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

//** IMPORTANT: First, finish creating the stock item and stock table, then fetch the data to the frontend.
// The PUT request is a bit
// complicated, so I need some time to think about finding a better solution for that.
// For now, your task is to create
// the stock creation part in the backend and then fetch that data to the frontend.**

        return stockItemsService.createStockItems(stockItem);
    }

    @PutMapping(path = "/stock-items")
    public StockItems updateStockItems(@RequestBody StockItem stockItem){
        System.out.println("received an put request to the stock");
// *** Don't implement this part for now.
// I will come up with a better solution later. Focus on the creation part for now. ***

// When making a donation in the frontend, ensure that the donation data is not already in the stock item table.
// I have already implemented logic that updates the stock item table with the same date as the donation for PUT requests.
// Therefore, when creating a donation, use a date that is not in the database.

// Need to implement PUT request logic.
// The issue is as mentioned in the above POST request:
// We cannot identify which blood quantity needs to be increased or decreased,
// as we are adding the newly added blood quantity directly to the blood type quantity in the stock item.
// There is no way to identify this.
// We need to create another table called "stock items donor details" (or a suitable name).
// This table should have columns for ID, donor NIC, donor blood type, date, and quantity.
// When creating or updating a new donation through these controllers in the service,
// first update that table. After that, we cannot directly update the stock item table with the new quantity,
// because the quantity might increase, decrease, or the data might change.


        return  null;
    }
}
