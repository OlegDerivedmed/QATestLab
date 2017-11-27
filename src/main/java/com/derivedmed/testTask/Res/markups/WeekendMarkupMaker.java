package com.derivedmed.testTask.Res.markups;

public class WeekendMarkupMaker implements MarkupMaker {
    public Markup makeMarkup() {
        return new WeekendMarkup();
    }
}
