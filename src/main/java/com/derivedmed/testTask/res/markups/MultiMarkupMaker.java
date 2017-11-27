package com.derivedmed.testTask.res.markups;

public class MultiMarkupMaker implements MarkupMaker{
    Markup markup;
    public MultiMarkupMaker(Markup markup){
        this.markup=markup;
    }
    public Markup makeMarkup() {
        return new MultiMarkup(markup);
    }
}
