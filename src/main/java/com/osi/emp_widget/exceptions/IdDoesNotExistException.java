package com.osi.emp_widget.exceptions;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 03-06-2020 12:49 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class IdDoesNotExistException extends Exception {
    public static final String MESSAGE = "There is no widget with the given ID : ";
    public IdDoesNotExistException (Integer id) {
        super( MESSAGE.concat( String.valueOf( id ) ) );
    }
}
