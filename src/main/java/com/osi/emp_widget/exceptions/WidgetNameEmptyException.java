package com.osi.emp_widget.exceptions;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 03-06-2020 12:16 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class WidgetNameEmptyException extends Exception{
    public static final String MESSAGE = "Widget Name cannot be empty";
    public WidgetNameEmptyException () {
        super( MESSAGE );
    }
}
