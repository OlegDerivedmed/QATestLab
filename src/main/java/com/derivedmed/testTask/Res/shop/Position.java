package com.derivedmed.testTask.Res.shop;

import com.derivedmed.testTask.Res.controllers.Mapper;

import java.util.List;

/**
 * It`s storage for position`s data. U can only set or get information about position.
 */
public class Position {
    /**
     * This const using in csv file creation in end of program
     *
     * @see Mapper#dataCreation(List)
     */
    private final int fieldscount = 6;
    private String name;
    private double price;
    private String type;
    private double amount;
    private String optional;
    private int count;
    private int sellCount;
    private int buyCount;
    private int sold;

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getFieldscount() {
        return fieldscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (Double.compare(position.price, price) != 0) return false;
        if (Double.compare(position.amount, amount) != 0) return false;
        if (count != position.count) return false;
        if (sellCount != position.sellCount) return false;
        if (buyCount != position.buyCount) return false;
        if (!name.equals(position.name)) return false;
        if (!type.equals(position.type)) return false;
        return optional.equals(position.optional);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + optional.hashCode();
        result = 31 * result + count;
        result = 31 * result + sellCount;
        result = 31 * result + buyCount;
        return result;
    }
}
