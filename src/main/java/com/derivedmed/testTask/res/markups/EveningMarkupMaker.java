package com.derivedmed.testTask.res.markups;

public class EveningMarkupMaker implements MarkupMaker {
    public Markup makeMarkup() {
        return new EveningMarkup();
    }
}
