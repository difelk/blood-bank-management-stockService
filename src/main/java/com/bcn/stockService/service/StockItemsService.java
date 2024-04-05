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

        try {
//            validate the DATE. cannot have the creating date in the db
            StockItems stockItems = new StockItems();
            stockItems.setStockDate(stockItem.getDonationDate());
            stockItems.setCategory("Regular");

            System.out.println("BLOOD TYPE: "+ stockItem.getBloodType());
            switch (stockItem.getBloodType().trim()) {
                case "A+":
                    stockItems.setaPositive(stockItem.getQuantity());
                    break;
                case "A-":
                    stockItems.setaNegative(stockItem.getQuantity());
                    break;
                case "B+":
                    stockItems.setbPositive(stockItem.getQuantity());
                    break;
                case "B-":
                    stockItems.setbNegative(stockItem.getQuantity());
                    break;
                case "AB+":
                    stockItems.setAbPositive(stockItem.getQuantity());
                    break;
                case "AB-":
                    stockItems.setAbNegative(stockItem.getQuantity());
                    break;
                case "O+":
                    stockItems.setoPositive(stockItem.getQuantity());
                    break;
                case "O-":
                    stockItems.setoNegative(stockItem.getQuantity());
                    break;
                default:
                    System.out.println("Invalid blood type: " + stockItem.getBloodType());
                    break;
            }


            System.out.println("stockItem in service - " + stockItem.getDonorNic());
            return stockItemRepository.save(stockItems);
        }
        catch(Exception e){
            System.out.println("Error in creating stock item: " + e.getMessage());
            return null;
        }
    }

    public StockItems updateStockItems(StockItem stockItem) {

        try {
//            validate DATE. cannot repeat the same date.
//            there should be a stock for the specific date
            StockItems stockItems = stockItemRepository.getStockItemsByDate(stockItem.getDonationDate()).get(0);
            stockItems.setStockDate(stockItem.getDonationDate());
            stockItems.setCategory("Regular");

            stockItems.setaPositive(stockItems.getaPositive());
            stockItems.setaNegative(stockItems.getaNegative());
            stockItems.setbPositive(stockItems.getbPositive());
            stockItems.setbNegative(stockItems.getbNegative());
            stockItems.setAbPositive(stockItems.getAbPositive());
            stockItems.setAbNegative(stockItems.getAbNegative());
            stockItems.setoPositive(stockItems.getoPositive());
            stockItems.setoNegative(stockItems.getoNegative());

            switch (stockItem.getBloodType().trim()) {
                case "A+":
                    stockItems.setaPositive(stockItem.getQuantity());
                    break;
                case "A-":
                    stockItems.setaNegative(stockItem.getQuantity());
                    break;
                case "B+":
                    stockItems.setbPositive(stockItem.getQuantity());
                    break;
                case "B-":
                    stockItems.setbNegative(stockItem.getQuantity());
                    break;
                case "AB+":
                    stockItems.setAbPositive(stockItem.getQuantity());
                    break;
                case "AB-":
                    stockItems.setAbNegative(stockItem.getQuantity());
                    break;
                case "O+":
                    stockItems.setoPositive(stockItem.getQuantity());
                    break;
                case "O-":
                    stockItems.setoNegative(stockItem.getQuantity());
                    break;
                default:
                    System.out.println("Invalid blood type: " + stockItem.getBloodType());
                    break;
            }

            System.out.println("stockItem in service - " + stockItem.getDonorNic());
            return stockItemRepository.save(stockItems);
        }
        catch(Exception e){
            System.out.println("Error in creating stock item: " + e.getMessage());
            return null;
        }
    }
}
