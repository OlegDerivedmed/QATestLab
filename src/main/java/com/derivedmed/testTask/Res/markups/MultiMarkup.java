package com.derivedmed.testTask.Res.markups;

public class MultiMarkup implements Markup {
    private final String NAME = "MultiMarkup";
    private Markup markup;

    public MultiMarkup(Markup markup) {
        this.markup = markup;
    }

    public double getMarkup(int count, double price) {
        return markup.getMarkup(2, price) + (count - 2) * 1.07 * price;
    }

    public String getNAME() {
        return NAME;
    }
}
