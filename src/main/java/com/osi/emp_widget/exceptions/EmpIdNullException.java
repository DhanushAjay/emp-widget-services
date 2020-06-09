package com.osi.emp_widget.exceptions;/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 3/6/2020 5:43 PM
 * Project        : com.osi.emp_widget.exceptions
 * Organization   : OSI Digital Pvt Ltd.
 */

public class EmpIdNullException extends Exception {
	private static final String MESSAGE ="Employee Id cannot be null";
	public EmpIdNullException(){
		super( MESSAGE );
	}
}
