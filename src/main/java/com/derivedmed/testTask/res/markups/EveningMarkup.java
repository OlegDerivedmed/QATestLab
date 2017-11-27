package com.derivedmed.testTask.res.markups;

public class EveningMarkup implements Markup {
    private final String NAME = "EveningMarkup";
    public double getMarkup(int count,double price) {
        return price * 1.08*count;
    }

    public String getNAME() {
        return NAME;
    }
}
