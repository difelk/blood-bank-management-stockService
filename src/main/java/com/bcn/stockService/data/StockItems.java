package com.bcn.stockService.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "stockItems")
public class StockItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock_date")
    private Date stockDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    public Integer getaPositive() {
        return aPositive;
    }

    public void setaPositive(Integer aPositive) {
        this.aPositive = aPositive;
    }

    public Integer getaNegative() {
        return aNegative;
    }

    public void setaNegative(Integer aNegative) {
        this.aNegative = aNegative;
    }

    public Integer getbPositive() {
        return bPositive;
    }

    public void setbPositive(Integer bPositive) {
        this.bPositive = bPositive;
    }

    public Integer getbNegative() {
        return bNegative;
    }

    public void setbNegative(Integer bNegative) {
        this.bNegative = bNegative;
    }

    public Integer getAbPositive() {
        return abPositive;
    }

    public void setAbPositive(Integer abPositive) {
        this.abPositive = abPositive;
    }

    public Integer getAbNegative() {
        return abNegative;
    }

    public void setAbNegative(Integer abNegative) {
        this.abNegative = abNegative;
    }

    public Integer getoPositive() {
        return oPositive;
    }

    public void setoPositive(Integer oPositive) {
        this.oPositive = oPositive;
    }

    public Integer getoNegative() {
        return oNegative;
    }

    public void setoNegative(Integer oNegative) {
        this.oNegative = oNegative;
    }

    @Column(name = "a_positive")
    private Integer aPositive;

    @Column(name = "a_negative")
    private Integer aNegative;

    @Column(name = "b_positive")
    private Integer bPositive;

    @Column(name = "b_negative")
    private Integer bNegative;

    @Column(name = "ab_positive")
    private Integer abPositive;

    @Column(name = "ab_negative")
    private Integer abNegative;

    @Column(name = "o_positive")
    private Integer oPositive;

    @Column(name = "o_negative")
    private Integer oNegative;


}
