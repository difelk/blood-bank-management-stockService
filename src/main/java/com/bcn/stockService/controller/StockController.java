package com.bcn.stockService.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @GetMapping(path = "/stocks")
    public String getAllStocks() {
        return "stock called";
    }

    @PostMapping(path = "/stocks")
    public String createStock(@RequestBody String stockData) {
        return "Stock created";
    }

    @PutMapping(path = "/stocks/{id}")
    public String updateStock(@PathVariable Long id, @RequestBody String stockData) {
        return "Stock updated";
    }
}

