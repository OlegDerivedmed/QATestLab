package com.derivedmed.testTask.res.markups;

public class WeekendMarkupMaker implements MarkupMaker {
    public Markup makeMarkup() {
        return new WeekendMarkup();
    }
}
