package com.bcn.stockService.service;

import com.bcn.stockService.data.StockItem;
import com.bcn.stockService.data.StockItemRepository;
import com.bcn.stockService.data.StockItems;
import com.bcn.stockService.data.StockResponse;
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

    public StockResponse createStockItems(StockItem stockItem) {

        StockResponse stockResponse = new StockResponse();
        try {
            if(stockItemRepository.getStockItemsByDate(stockItem.getDonationDate()).isEmpty()){
                StockItems stockItems = new StockItems();
                stockItems.setStockDate(stockItem.getDonationDate());
                stockItems.setCategory("Regular");

                System.out.println("BLOOD TYPE: "+ stockItem.getBloodType());
                System.out.println("stockItem.getBloodType().trim() : "+ stockItem.getBloodType().trim());
                switch (stockItem.getBloodType().trim()) {
                    case "A +":
                        stockItems.setaPositive(stockItem.getQuantity());
                        break;
                    case "A -":
                        stockItems.setaNegative(stockItem.getQuantity());
                        break;
                    case "B +":
                        stockItems.setbPositive(stockItem.getQuantity());
                        break;
                    case "B -":
                        stockItems.setbNegative(stockItem.getQuantity());
                        break;
                    case "AB +":
                        stockItems.setAbPositive(stockItem.getQuantity());
                        break;
                    case "AB -":
                        stockItems.setAbNegative(stockItem.getQuantity());
                        break;
                    case "O +":
                        stockItems.setoPositive(stockItem.getQuantity());
                        break;
                    case "O -":
                        stockItems.setoNegative(stockItem.getQuantity());
                        break;
                    default:
                        System.out.println("Invalid blood type: " + stockItem.getBloodType());
                        break;
                }
                System.out.println("stockItem in service - " + stockItem.getDonorNic());
                stockItemRepository.save(stockItems);
                stockResponse.setMessage("Stock created successfully");
                stockResponse.setStatus(200);
            }
            else {
                stockResponse.setMessage("Stock already exists");
                stockResponse.setStatus(500);
            }

        }
        catch(Exception e){
            System.out.println("Error in creating stock item: " + e.getMessage());
            stockResponse.setMessage("Stock created failed");
            stockResponse.setStatus(500);
        }
        finally {
            return stockResponse;
        }
    }

    public StockResponse updateStockItems(StockItem stockItem) {
        StockResponse stockResponse = new StockResponse();
        try {
//            System.out.println("stockItem.getDonationDate()).equals(1): " + stockItem.getDonationDate().equals(1));
//            System.out.println("SIZE: " + getStockItemsByDate(stockItem.getDonationDate()).size());
            if(stockItemRepository.getStockItemsByDate(stockItem.getDonationDate()).size() == 1){
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

                System.out.println("BLOOD TYPE: "+ stockItem.getBloodType());
                System.out.println("stockItem.getBloodType().trim() : "+ stockItem.getBloodType().trim());

                switch (stockItem.getBloodType().trim()) {
                    case "A +":
                        stockItems.setaPositive(stockItem.getQuantity());
                        break;
                    case "A -":
                        stockItems.setaNegative(stockItem.getQuantity());
                        break;
                    case "B +":
                        stockItems.setbPositive(stockItem.getQuantity());
                        break;
                    case "B -":
                        stockItems.setbNegative(stockItem.getQuantity());
                        break;
                    case "AB +":
                        stockItems.setAbPositive(stockItem.getQuantity());
                        break;
                    case "AB -":
                        stockItems.setAbNegative(stockItem.getQuantity());
                        break;
                    case "O +":
                        stockItems.setoPositive(stockItem.getQuantity());
                        break;
                    case "O -":
                        stockItems.setoNegative(stockItem.getQuantity());
                        break;
                    default:
                        System.out.println("Invalid blood type: " + stockItem.getBloodType());
                        break;
                }

                System.out.println("stockItem in service - " + stockItem.getDonorNic());
                stockItemRepository.save(stockItems);
                stockResponse.setMessage("Stock updated successfully");
                stockResponse.setStatus(200);
            }
            else {
                stockResponse.setMessage("Stock does not exist");
                stockResponse.setStatus(500);
            }
        }

        catch(Exception e){
            System.out.println("Error in creating stock item: " + e.getMessage());
            stockResponse.setMessage("Stock updated unsuccessful");
            stockResponse.setStatus(500);
        }
        finally {
            return stockResponse;
        }
    }
}
