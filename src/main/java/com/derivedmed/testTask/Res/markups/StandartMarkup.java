package com.derivedmed.testTask.Res.markups;

public class StandartMarkup implements Markup {
    private final String NAME = "StandartMarkup";

    public double getMarkup(int count, double price) {
        return price * 1.1 * count;
    }

    public String getNAME() {
        return NAME;
    }

}
