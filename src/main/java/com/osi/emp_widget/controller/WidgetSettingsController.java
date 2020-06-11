package com.osi.emp_widget.controller;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 01:52 PM
 * Project        : com.osi.emp_widget.controller
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.WidgetSettingsDTO;
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.mapper.WidgetSettingsMapper;
import com.osi.emp_widget.model.WidgetSettings;
import com.osi.emp_widget.service.WidgetSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/WidgetSettings")
public class WidgetSettingsController {
	@Autowired
	WidgetSettingsService widgetSettingsService;

	@Autowired
	WidgetSettingsMapper widgetSettingsMapper;

	/**
	 * Creates WidgetSettings
	 * @param widgetSettingsDTO
	 * @return "Widget settings with ID :" + widgetSettings.getId() + "has been saved"
	 * @throws Exception
	 */
	@PostMapping("/saveWidgetSettings")
	public String createWidgetSettings ( @RequestBody WidgetSettingsDTO widgetSettingsDTO ) throws Exception {
		WidgetSettings widgetSettings = widgetSettingsMapper.toEntity( widgetSettingsDTO )    ;
		return widgetSettingsService.addWidgetSettings( widgetSettings );
	}

	/**
	 * Get WidgetSettings
	 * @param id
	 * @return WidgetSettingsDTO
	 * @throws IdDoesNotExistException
	 */
	@GetMapping("/getById/{id}")
	public WidgetSettingsDTO getWidgetSettingsById ( @PathVariable Integer id ) throws IdDoesNotExistException {
		WidgetSettings widgetSettings = widgetSettingsService.getWidgetSettingsById( id );
        return widgetSettingsMapper.toDto( widgetSettings );
	}

	/**
	 * Get WidgetSettings by Widget Id
	 * @param widgetId
	 * @return WidgetSettingsDTO
	 * @throws IdDoesNotExistException
	 */
	@GetMapping("/getByWidgetId/{widgetId}")
	public WidgetSettingsDTO getWidgetSettingsByWidgetId ( @PathVariable Integer widgetId ) throws IdDoesNotExistException {
		WidgetSettings widgetSettings =  widgetSettingsService.getWidgetSettingsByWidgetId( widgetId );
        return widgetSettingsMapper.toDto( widgetSettings );
	}

	/**
	 * Get All WidgetSettings
	 * @return List<WidgetSettingsDTO>
	 */
	@GetMapping("/getAll")
	public List<WidgetSettingsDTO> getAllWidgetSettings () {
		List<WidgetSettings> widgetSettings = widgetSettingsService.getAllWidgetSettings();
        return widgetSettingsMapper.toDtoList( widgetSettings );
	}

	/**
	 * Delete if Id exists
	 * @param id
	 * @return The given id has been deleted
	 * @throws IdDoesNotExistException
	 */
	@DeleteMapping("/deleteById/{id}")
	public String deleteWidgetSettingsById ( @PathVariable Integer id ) throws IdDoesNotExistException {
		return widgetSettingsService.deleteWidgetSettingsById( id );
	}

	/**
	 * Delete by if widget Id exists
	 * @param id
	 * @return Given id has been deleted
	 * @throws IdDoesNotExistException
	 */
	@DeleteMapping("/deleteIdByWidgetId/{id}")
	public String deleteWidgetSettingsByWidgetId ( @PathVariable Integer id ) throws IdDoesNotExistException {
		return widgetSettingsService.deleteWidgetSettingsByWidgetId( id );
	}
}



