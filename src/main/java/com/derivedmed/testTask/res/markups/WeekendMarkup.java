package com.derivedmed.testTask.res.markups;

public class WeekendMarkup implements Markup {
    private final String NAME = "WeekendMarkup";
    public double getMarkup(int count, double price) {
        return price * 1.15 * count;
    }

    public String getNAME() {
        return NAME;
    }
}
