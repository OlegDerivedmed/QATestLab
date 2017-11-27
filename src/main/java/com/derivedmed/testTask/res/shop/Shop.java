package com.derivedmed.testTask.res.shop;

import com.derivedmed.testTask.res.controllers.Mapper;
import com.derivedmed.testTask.res.controllers.MarkupController;
import com.derivedmed.testTask.res.controllers.TimeController;
import com.derivedmed.testTask.res.markups.Markup;

import java.io.*;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * Our Shop. Shop has "catalouge" as List of positions, shop needs to know what time is now to do right markup and
 * etc.
 * Shop has some statistics like boughtcount, soldcount, proceed, boughtprice.
 */
public class Shop {
    private List<Position> positions; //catalouge
    private GregorianCalendar universeTime; // current date
    private int boughtCount;
    private int soldCount;
    private int proceeds;
    private int boughtPrice;

    public int getBoughtCount() {
        return boughtCount;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public GregorianCalendar getUniverseTime() {
        return universeTime;
    }

    /**
     * Constructor getting current time.
     *
     * @param gc
     */
    public Shop(GregorianCalendar gc) {
        final String fullFilename = TimeController.PATH + "task.csv";
        universeTime = gc;
        Mapper mapper = Mapper.getInstance(fullFilename);
        positions = mapper.getPositions();
    }

    /**
     * Buying position if needs.
     */
    public void buyPosition() {
        for (Position position : positions) {
            if (position.getCount() < 10) {
                position.setCount(position.getCount() + 1500);
                boughtCount += 1500;
                position.setBuyCount(position.getBuyCount() + 1500);
                boughtPrice += position.getPrice() * 1500;
            }
        }
    }

    /**
     * It is deal between customer and shop.
     * Customer selling request. Map is list of positions and it`s count that customer need to buy.
     * Markup sets via {@link MarkupController}.
     *
     * @param tobuylist
     */
    public void sellPositions(Map<Position, Integer> tobuylist) {
        System.out.println(universeTime.getTime());
        System.out.println("Продано: ");
        for (Map.Entry<Position, Integer> tobuy : tobuylist.entrySet()) {
            for (Position position : positions) {
                Position p = tobuy.getKey();
                int count = tobuy.getValue();
                if (p.equals(position)) {
                    if (count <= position.getCount()) {
                        position.setCount(position.getCount() - count);
                        Markup markup = new MarkupController().getMarkup(universeTime, count);
                        double soldPrice = markup.getMarkup(count, position.getPrice());
                        position.setSold(position.getSold() + count);
                        proceeds += soldPrice - (position.getPrice() * count);
                        soldCount += count;
                        System.out.println(position.getName() + ", количество : " + count + ", цена продажи :" + soldPrice + ", наценка : " + markup.getNAME());
                    } else {
                        System.out.println("Извините, товар закончился");
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * Creating report about shop`s work.
     */
    public void createReport() {
        final String fullFilename = TimeController.PATH + "report.txt";
        try (FileWriter fileWriter = new FileWriter(new File(fullFilename));) {
            for (Position position : positions) {
                fileWriter.write("Position name: " + position.getName() + ", sold: " + position.getSold() + ", bought: " + position.getBuyCount());
                fileWriter.write(System.getProperty("line.separator"));
            }
            fileWriter.write("Proceeds : " + proceeds);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.write("BoughtPrice : " + boughtPrice);
        } catch (IOException e) {
            System.out.println("Cant create or find file");
        }
    }
}
