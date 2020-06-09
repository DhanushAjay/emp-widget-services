package com.osi.emp_widget.exceptions;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 03-06-2020 01:52 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class WidgetIDRequiredException extends Exception {
    private static final String MESSAGE = "Widget settings requires Widget ID";

    public WidgetIDRequiredException () {
        super(MESSAGE);
    }
}
