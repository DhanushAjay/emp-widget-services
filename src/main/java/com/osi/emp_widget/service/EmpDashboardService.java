package com.osi.emp_widget.service;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 05-06-2020 08:07 AM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.exceptions.DashboardNameNullException;
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpDashboardNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.model.EmpDashboard;

import java.util.List;

public interface EmpDashboardService {
	String addEmpDashboard(EmpDashboard empDashboard) throws EmpIdNullException, DashboardNameNullException, WidgetIDNullException;

	EmpDashboard getEmpDashboardById(Integer id) throws EmpDashboardNotFoundException;

	EmpDashboard getEmpDashboardByWidgetId(Integer widgetId) throws EmpDashboardNotFoundException;

	List<EmpDashboard> getAllEmpDashboards();

	String deleteEmpDashboardById(Integer id);

	String deleteEmpDashboardByWidgetId(Integer widgetId);

	EmpDashboard getEmpDashboardByEmpWidgetId(Integer empWidgetId) throws EmpDashboardNotFoundException;
}