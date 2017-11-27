package com.derivedmed.testTask.Res.markups;

public class EveningMarkupMaker implements MarkupMaker {
    public Markup makeMarkup() {
        return new EveningMarkup();
    }
}
