package com.osi.emp_widget.controller;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 03-06-2020 11:36 AM
 * Project        : com.osi.emp_widget.controller
 * Organization   : OSI Digital Pvt Ltd.
 */

import com.osi.emp_widget.dto.AllWidgetDTO;
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetNameEmptyException;
import com.osi.emp_widget.mapper.WidgetMapper;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/Widget")
public class WidgetController {

	@Autowired
	WidgetService widgetService;

	@Autowired
	WidgetMapper widgetMapper;

	/**
	 * Creates widget
	 * @param allWidgetDTO
	 * @return "Widget has been saved with id : " + widget.getId()
	 * @throws WidgetNameEmptyException
	 */
	@PostMapping("/saveWidget")
	public String createWidget ( @RequestBody AllWidgetDTO allWidgetDTO ) throws WidgetNameEmptyException {
		Widget widget = widgetMapper.toEntity( allWidgetDTO )  ;
		return widgetService.addWidget( widget );
	}

	/**
	 * Get Widget
	 * @param id
	 * @return AllWidgetDTO
	 * @throws IdDoesNotExistException
	 */
	@GetMapping("/getById/{id}")
	public AllWidgetDTO getWidgetById ( @PathVariable Integer id ) throws IdDoesNotExistException {
		Widget widget = widgetService.getWidgetById( id );
        return widgetMapper.toDto( widget );
	}

	/**
	 * Get All Widgets
	 * @return List<AllWidgetDTO>
	 */
	@GetMapping("/getAll")
	public List<AllWidgetDTO> getAllWidgets () {
		List<Widget> widgets = widgetService.getAllWidgets();
        return widgetMapper.toDtoList( widgets );
	}

	/**
	 * Delete if Id exists
	 * @param id
	 * @return The given  id has been deleted
	 * @throws IdDoesNotExistException
	 */
	@DeleteMapping("/deleteById/{id}")
	public String deleteWidgetById ( @PathVariable Integer id ) throws IdDoesNotExistException {
		return widgetService.deleteWidgetById( id );
	}
}
