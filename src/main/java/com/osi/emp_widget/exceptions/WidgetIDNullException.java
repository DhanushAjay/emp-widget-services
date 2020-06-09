package com.osi.emp_widget.exceptions;/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 3/6/2020 5:53 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class WidgetIDNullException extends Exception {
	private static final String MESSAGE = "Widget ID cannot be Null";
	public WidgetIDNullException(){
		super(MESSAGE);
	}
}
