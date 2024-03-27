package com.bcn.stockService.controller;


import com.bcn.stockService.data.Donor;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @GetMapping(path = "/stocks")
    public String getAllStocks() {
        return "stock called";
    }

    @PostMapping(path = "/stocks")
    public String createStock(@RequestBody Donor donor) {
        return "Stock created for donor: " + donor.getDonorNic();
    }

    @PutMapping(path = "/stocks/{id}")
    public String updateStock(@PathVariable String id, @RequestBody Donor donor) {
        return "received new donation from " + donor.getFirstName() + " "  + donor.getLastName();
    }
}

