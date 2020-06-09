package com.osi.emp_widget.service;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 05-06-2020 08:07 AM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpWidgetNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.model.EmpWidget;

import java.util.List;

public interface EmpWidgetService {

	String addEmpWidget(EmpWidget empWidget) throws EmpIdNullException, WidgetIDNullException;

	EmpWidget getEmpWidgetById(Integer id) throws EmpWidgetNotFoundException;

	EmpWidget getEmpWidgetByWidgetId(Integer widgetId) throws EmpWidgetNotFoundException;

	List<EmpWidget> getAllEmpWidgets();

	String deleteEmpWidgetById(Integer id);

	String deleteEmpWidgetByWidgetId(Integer widgetId);
}