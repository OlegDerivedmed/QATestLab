package com.derivedmed.testTask.Res.markups;

public class MultiMarkupMaker implements MarkupMaker{
    Markup markup;
    public MultiMarkupMaker(Markup markup){
        this.markup=markup;
    }
    public Markup makeMarkup() {
        return new MultiMarkup(markup);
    }
}
