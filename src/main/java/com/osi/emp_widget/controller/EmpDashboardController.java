package com.osi.emp_widget.controller;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 01:52 PM
 * Project        : com.osi.emp_widget.controller
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.EmpDashboardDTO;
import com.osi.emp_widget.exceptions.*;
import com.osi.emp_widget.mapper.EmpDashboardMapper;
import com.osi.emp_widget.model.EmpDashboard;
import com.osi.emp_widget.service.EmpDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/EmpDashboard")
public class EmpDashboardController {

	@Autowired
	EmpDashboardService empDashboardService;

	@Autowired
	EmpDashboardMapper empDashboardMapper;

	/**
	 * Creates EmpDashboard
	 * @param empDashboardDTO
	 * @return "The given Emp Dashboard " + empDashboard.getId() + " has been saved "
	 * @throws EmpIdNullException
	 * @throws DashboardNameNullException
	 * @throws WidgetIDNullException
	 */
	@PostMapping("/saveEmpDashboard")
	public String addEmpDashboard ( @RequestBody EmpDashboardDTO empDashboardDTO ) throws EmpIdNullException, DashboardNameNullException, WidgetIDNullException {
		EmpDashboard empDashboard = empDashboardMapper.toEntity( empDashboardDTO )  ;
		return empDashboardService.addEmpDashboard( empDashboard );
	}

	/**
	 * Get EmpDashboard
	 * @param id
	 * @return EmpDashboardDTO
	 * @throws EmpDashboardNotFoundException
	 */
	@GetMapping("/getById/{id}")
	public EmpDashboardDTO getEmpDashboardById ( @PathVariable Integer id ) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardService.getEmpDashboardById( id );
		return empDashboardMapper.toDto( empDashboard );
	}

	/**
	 * Get EmpDashboard By widget Id
	 * @param widgetId
	 * @return EmpDashboardDTO
	 * @throws EmpDashboardNotFoundException
	 */
	@GetMapping("/getByWidgetId/{widgetId}")
	public EmpDashboardDTO getEmpDashboardByWidgetId ( @PathVariable Integer widgetId ) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardService.getEmpDashboardByWidgetId( widgetId );
		return empDashboardMapper.toDto( empDashboard );
	}

	/**
	 * Get All EmpDashboards
	 * @return List<EmpDashboardDTO>
	 */
	@GetMapping("/getAll")
	public List<EmpDashboardDTO> getAllEmpDashboards () {
		List<EmpDashboard> empDashboards = empDashboardService.getAllEmpDashboards();
		return empDashboardMapper.toDtoList( empDashboards );
	}

	/**
	 * Delete if Id exists
	 * @param id
	 * @return The given id has been deleted
	 */
	@DeleteMapping("/deleteById/{id}")
	public String deleteEmpDashboardById ( @PathVariable Integer id ) {
		return empDashboardService.deleteEmpDashboardById( id );
	}

	/**
	 * Delete by if widgetId exists
	 * @param id
	 * @return Given id has been deleted
	 */
	@DeleteMapping("/deleteIdByWidgetId/{id}")
	public String deleteEmpDashboardByWidgetId ( @PathVariable Integer id ) {
		return empDashboardService.deleteEmpDashboardByWidgetId( id );
	}

	/**
	 * Get EmpDashboard by EmpWidget Id
 	 * @param empWidgetId
	 * @return EmpDashboard
	 * @throws EmpDashboardNotFoundException
	 */
	@GetMapping("/getByEmpWidgetId/{empWidgetId}")
	public EmpDashboardDTO getEmpDashboardByEmpWidgetId(@PathVariable Integer empWidgetId) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardService.getEmpDashboardByEmpWidgetId(empWidgetId);
		return empDashboardMapper.toDto(empDashboard);
	}
}
