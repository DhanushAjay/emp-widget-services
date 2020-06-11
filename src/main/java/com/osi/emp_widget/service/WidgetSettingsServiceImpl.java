package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetIDRequiredException;
import com.osi.emp_widget.model.WidgetSettings;
import com.osi.emp_widget.repository.WidgetSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 01:37 PM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
@Service
public class WidgetSettingsServiceImpl implements WidgetSettingsService {

	@Autowired
	WidgetSettingsRepository widgetSettingsRepository;

	/**
	 * Creates a new WidgetSettings
	 * @param widgetSettings
	 * @return  Id has been saved
	 * @throws WidgetIDRequiredException
	 */
	@Override
	public String addWidgetSettings ( WidgetSettings widgetSettings ) throws WidgetIDRequiredException {
		try {
			widgetSettingsRepository.save( widgetSettings );
		} catch ( DataIntegrityViolationException e ) {
			throw new WidgetIDRequiredException();
		}
		return "Widget settings with ID :" + widgetSettings.getId() + "has been saved";
	}

	/**
	 * Get WidgetSettings by id
	 * @param id
	 * @return WidgetSettings
	 * @throws IdDoesNotExistException
	 */
	@Override
	public WidgetSettings getWidgetSettingsById ( Integer id ) throws IdDoesNotExistException {
		if ( !widgetSettingsRepository.exists( id ) ) {
			throw new IdDoesNotExistException( id );
		}
		return widgetSettingsRepository.findOne( id );
	}

	/**
	 * Get WidgetSettings by widget_id
	 * @param widgetId
	 * @return WidgetSettings
	 * @throws IdDoesNotExistException
	 */
	@Override
	@Transactional
	public WidgetSettings getWidgetSettingsByWidgetId ( Integer widgetId ) throws IdDoesNotExistException {
		WidgetSettings widgetSettings = widgetSettingsRepository.getWidgetSettingsByWidget_Id( widgetId );
		if ( widgetSettings != null )
			return widgetSettings;
		else
			throw new IdDoesNotExistException( widgetId );
	}

	/**
	 * Delete WidgetSettings based on id if exists
	 * @param id
	 * @return id has been deleted successfully
	 * @throws IdDoesNotExistException
	 */
	@Override
	public String deleteWidgetSettingsById ( Integer id ) throws IdDoesNotExistException {
		if ( !widgetSettingsRepository.exists( id ) ) {
			throw new IdDoesNotExistException( id );
		}
		widgetSettingsRepository.delete( id );
		return "Widget Settings with ID : " + id + " has been deleted successfully";
	}

	/**
	 * Delete WidgetSettings based on widget_id if exists
	 * @param widgetId
	 * @return id has been deleted
	 * @throws IdDoesNotExistException
	 */
	@Override
	@Transactional
	public String deleteWidgetSettingsByWidgetId ( Integer widgetId ) throws IdDoesNotExistException {
		WidgetSettings widgetSettings = widgetSettingsRepository.getWidgetSettingsByWidget_Id( widgetId );
		if ( widgetSettings != null ) {
			widgetSettingsRepository.deleteByWidget_Id( widgetId );
			return "The given id:" + widgetSettings.getId() + "has been deleted";
		} else
			throw new IdDoesNotExistException( widgetId );
	}

	/**
	 * Get all WidgetSettings
	 * @return List<WidgetSettings>
	 */
	@Override
	public List<WidgetSettings> getAllWidgetSettings () {
		return (List<WidgetSettings>) widgetSettingsRepository.findAll();
	}
}
