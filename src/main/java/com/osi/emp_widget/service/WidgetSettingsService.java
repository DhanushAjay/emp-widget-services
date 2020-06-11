package com.osi.emp_widget.service;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 05-06-2020 08:07 AM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.model.WidgetSettings;

import java.util.List;

public interface WidgetSettingsService {

	String addWidgetSettings(WidgetSettings WidgetSettings) throws Exception;

	WidgetSettings getWidgetSettingsById(Integer id) throws IdDoesNotExistException;

	WidgetSettings getWidgetSettingsByWidgetId(Integer widgetId) throws IdDoesNotExistException;

	String deleteWidgetSettingsById(Integer id) throws IdDoesNotExistException;

	String deleteWidgetSettingsByWidgetId(Integer widgetId) throws IdDoesNotExistException;

	List<WidgetSettings> getAllWidgetSettings();
}