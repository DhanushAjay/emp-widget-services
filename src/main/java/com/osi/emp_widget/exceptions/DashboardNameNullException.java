package com.osi.emp_widget.exceptions;/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 3/6/2020 5:49 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class DashboardNameNullException extends Exception {
	private static final String MESSAGE = "Dashboard Name cannot be Null";

	public DashboardNameNullException () {
		super(MESSAGE);
	}
}
