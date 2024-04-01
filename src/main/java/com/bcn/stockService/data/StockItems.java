package com.bcn.stockService.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "stock_item")
public class StockItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private Date stockDate;

    @Column(name = "Aplus")
    private float aPositive;

    @Column(name = "Aminus")
    private float aNegative;

    @Column(name = "Bplus")
    private float bPositive;

    @Column(name = "Bminus")
    private float bNegative;

    @Column(name = "ABplus")
    private float abPositive;

    @Column(name = "ABminus")
    private float abNegative;

    @Column(name = "Oplus")
    private float oPositive;

    @Column(name = "Ominus")
    private float oNegative;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    public float getaPositive() {
        return aPositive;
    }

    public void setaPositive(float aPositive) {
        this.aPositive = aPositive;
    }

    public float getaNegative() {
        return aNegative;
    }

    public void setaNegative(float aNegative) {
        this.aNegative = aNegative;
    }

    public float getbPositive() {
        return bPositive;
    }

    public void setbPositive(float bPositive) {
        this.bPositive = bPositive;
    }

    public float getbNegative() {
        return bNegative;
    }

    public void setbNegative(float bNegative) {
        this.bNegative = bNegative;
    }

    public float getAbPositive() {
        return abPositive;
    }

    public void setAbPositive(float abPositive) {
        this.abPositive = abPositive;
    }

    public float getAbNegative() {
        return abNegative;
    }

    public void setAbNegative(float abNegative) {
        this.abNegative = abNegative;
    }

    public float getoPositive() {
        return oPositive;
    }

    public void setoPositive(float oPositive) {
        this.oPositive = oPositive;
    }

    public float getoNegative() {
        return oNegative;
    }

    public void setoNegative(float oNegative) {
        this.oNegative = oNegative;
    }
}
