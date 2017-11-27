package com.derivedmed.testTask.Res.controllers;

import com.derivedmed.testTask.Res.markups.*;
import com.derivedmed.testTask.Res.markups.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Controller for {@link Markup}.
 * It knows which markup needs to be returned.
 *
 */
public class MarkupController {
    /**
     * Returns markup depends on conditions.
     *
     * @param gc
     * @param count
     * @return
     */
    public Markup getMarkup(GregorianCalendar gc, int count) {
        Markup markup;
        markup = new StandartMarkupMaker().makeMarkup();
        if (gc.get(Calendar.HOUR_OF_DAY) >= 18 && gc.get(Calendar.HOUR_OF_DAY) < 20) {
            markup = new EveningMarkupMaker().makeMarkup();
        }else {
            if (gc.get(Calendar.DAY_OF_WEEK) == 1 || gc.get(Calendar.DAY_OF_WEEK) == 7) {
                markup = new WeekendMarkupMaker().makeMarkup();
            }
        }
        if (count > 2) {
            markup = new MultiMarkupMaker(markup).makeMarkup();
        }
        return markup;
    }
}
