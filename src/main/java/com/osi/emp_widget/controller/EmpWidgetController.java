package com.osi.emp_widget.controller;
/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 3/6/2020 12:24 PM
 * Project        : com.osi.emp_widget.controller
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.EmpWidgetDTO;
import com.osi.emp_widget.dto.ViewDTO;
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpWidgetNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.mapper.EmpWidgetMapper;
import com.osi.emp_widget.model.EmpWidget;
import com.osi.emp_widget.service.EmpWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/EmpWidget")
public class EmpWidgetController {

	@Autowired
	EmpWidgetService empWidgetService;

	@Autowired
	EmpWidgetMapper empWidgetMapper;

	/**
	 * Creates EmpWidget
	 * @param empWidgetDTO
	 * @return "The given Emp Widget "+ empWidget.getId()+" has been saved "
	 * @throws EmpIdNullException
	 * @throws WidgetIDNullException
	 */
	@PostMapping("/saveEmpWidget")
	public String createEmpWidget ( @RequestBody EmpWidgetDTO empWidgetDTO ) throws EmpIdNullException, WidgetIDNullException {
		EmpWidget empWidget = empWidgetMapper.toEntity( empWidgetDTO )  ;
		return empWidgetService.addEmpWidget( empWidget );
	}

	/**
	 * Get EmpWidget
	 * @param id
	 * @return EmpWidgetDTO
	 * @throws EmpWidgetNotFoundException
	 */
	@GetMapping("/getById/{id}")
	public EmpWidgetDTO getEmpWidgetById ( @PathVariable Integer id ) throws EmpWidgetNotFoundException {
		EmpWidget empWidget = empWidgetService.getEmpWidgetById( id );
        return empWidgetMapper.toDto( empWidget );
	}

	/**
	 * Get EmpWidget by widget Id
	 * @param widgetId
	 * @return EmpWidgetDTO
	 * @throws EmpWidgetNotFoundException
	 */
	@GetMapping("/getByWidgetId/{widgetId}")
	public EmpWidgetDTO getEmpWidgetByWidgetId ( @PathVariable Integer widgetId ) throws EmpWidgetNotFoundException {
		EmpWidget empWidget = empWidgetService.getEmpWidgetByWidgetId( widgetId );
        return empWidgetMapper.toDto( empWidget );
	}

	/**
	 * Get All EmpWidgets
	 * @return List<EmpWidgetDTO>
	 */
	@GetMapping("/getAll")
	public List<EmpWidgetDTO> getAllEmpWidgets(){
		List<EmpWidget> empWidgets =  empWidgetService.getAllEmpWidgets();
        return empWidgetMapper.toDtoList( empWidgets );
	}

	/**
	 * Delete if Id exists
	 * @param id
	 * @return The given id has been deleted
	 */
	@DeleteMapping("/deleteById/{id}")
	public String deleteEmpWidgetById ( @PathVariable Integer id ) {
		return empWidgetService.deleteEmpWidgetById( id );
	}

	/**
	 * Delete by if widget Id exists
	 * @param id
	 * @return Given id has been deleted
	 */
	@DeleteMapping("/deleteIdByWidgetId/{id}")
	public String deleteEmpWidgetByWidgetId ( @PathVariable Integer id ) {
		return empWidgetService.deleteEmpWidgetByWidgetId( id );
	}

	/**
	 * Get Widget Settings by Widget Id
	 * @param id
	 * @return ViewDTO
	 * @throws EmpWidgetNotFoundException
	 */
	@GetMapping("/getWidgetSettingsById/{id}")
	public ViewDTO getWidgetSettingsById (@PathVariable Integer id ) throws EmpWidgetNotFoundException {
		EmpWidget empWidget = empWidgetService.getEmpWidgetById( id );
        return empWidgetMapper.toViewDto( empWidget );
	}
}
