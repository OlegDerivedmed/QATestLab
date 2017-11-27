package com.derivedmed.testTask.Res.controllers;

import com.derivedmed.testTask.Res.customer.Customer;
import com.derivedmed.testTask.Res.shop.Position;
import com.derivedmed.testTask.Res.shop.Shop;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * It is "main" class of emulation. Emulation tied up on time.
 */
public class TimeController {
    private List<Position> data;
    private static final Date startDate = new Date();
    private GregorianCalendar gc;
    private int daysCount;
    private int hoursCount;

    public List<Position> getData() {
        return data;
    }

    /**
     * This is emulation. In start of it we getting current date, then creating our shop.
     * Outer cycle ends when will the month path. Every iteration of this cycle means that an hour has passed.
     * We need to check what time is it now, to know is shop works or not. Also we need to buy positions which ended
     * in the end of work day.
     * Then we have random count of customers every hour. When customer comes shop doing sell, and customer doing buy.
     * To buy something he need to know what he can buy and price.
     * Transaction must be on shop`s side, so customer can only "send request" to shop.
     * @throws IOException
     */
    public void startEmulaiton() throws IOException {
        gc = new GregorianCalendar();
        gc.setTime(startDate);
        Shop shop = new Shop(gc);
        while (daysCount < 30) {
            // check workhours
            if (gc.get(Calendar.HOUR_OF_DAY) < 8 || gc.get(Calendar.HOUR_OF_DAY) >= 21) {
                if (gc.get(Calendar.HOUR_OF_DAY) == 21) {
                    shop.buyPosition();
                }
                timeAdd();
                continue;
            }
            for (int i = 0; i <1+(int)(Math.random()*10); i++) {
                Customer customer = new Customer();
                shop.sellPositions(customer.buy(shop.getPositions()));
            }
            timeAdd();
        }
        shop.getInformation();
        data = shop.getPositions();
        System.out.println(shop.getBoughtCount());
        System.out.println(shop.getSoldCount());
    }

    /**
     * This method is day`s and hour`s couter.
     */
    private void timeAdd() {
        gc.add(Calendar.HOUR, 1);
        hoursCount++;
        if (hoursCount % 24 == 0) {
            daysCount++;
        }
    }

}
