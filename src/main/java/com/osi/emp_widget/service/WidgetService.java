package com.osi.emp_widget.service;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 05-06-2020 08:07 AM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetNameEmptyException;
import com.osi.emp_widget.model.Widget;

import java.util.List;

public interface WidgetService {

	String addWidget(Widget widget) throws WidgetNameEmptyException;

	List<Widget> getAllWidgets();

	Widget getWidgetById(Integer id) throws IdDoesNotExistException;

	String deleteWidgetById(Integer id) throws IdDoesNotExistException;
}