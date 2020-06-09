package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.DashboardNameNullException;
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpDashboardNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.model.EmpDashboard;
import com.osi.emp_widget.repository.EmpDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.isNull;

/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 12:41 PM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
@Service
public class EmpDashboardServiceImpl implements EmpDashboardService {

	@Autowired
	EmpDashboardRepository empDashboardRepository;

	/**
	 * Creates a new EmpDashboard
	 * @param empDashboard
	 * @return given Emp Dashboard id
	 * @throws EmpIdNullException
	 * @throws DashboardNameNullException
	 * @throws WidgetIDNullException
	 */
	@Override
	public String addEmpDashboard ( EmpDashboard empDashboard ) throws EmpIdNullException, DashboardNameNullException, WidgetIDNullException {
		if ( isNull( empDashboard.getEmpId() ) )
			throw new EmpIdNullException();
		if ( isNull( empDashboard.getDashboardName() ) )
			throw new DashboardNameNullException();
		if ( isNull( empDashboard.getWidget() ) || isNull( empDashboard.getWidget().getId() ) )
			throw new WidgetIDNullException();
		empDashboardRepository.save( empDashboard );
		return "The given Emp Dashboard " + empDashboard.getId() + " has been saved ";
	}

	/**
	 * Get EmpDashboard by given id
	 * @param id
	 * @return EmpDashboard
	 * @throws EmpDashboardNotFoundException
	 */
	@Override
	public EmpDashboard getEmpDashboardById ( Integer id ) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardRepository.findOne( id );
		if ( empDashboard != null )
			return empDashboard;
		else
			throw new EmpDashboardNotFoundException( "No Id found with that Emp dashboard" );
	}

	/**
	 * Get EmpDashboard by given widget_id
	 * @param widgetId
	 * @return EmpDashboard
	 * @throws EmpDashboardNotFoundException
	 */
	@Override
	@Transactional
	public EmpDashboard getEmpDashboardByWidgetId ( Integer widgetId ) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardRepository.getEmpDashboardByWidget_Id( widgetId );
		if ( empDashboard != null )
			return empDashboard;
		else
			throw new EmpDashboardNotFoundException( "No Id found with that Emp dashboard" );
	}

	/**
	 * GetAll EmpDashboard
	 * @return List<EmpDashboard>
	 */
	@Override
	public List<EmpDashboard> getAllEmpDashboards () {
		return (List<EmpDashboard>) empDashboardRepository.findAll();
	}

	/**
	 * Deletes EmpDashboard record if given id exists
	 * @param id
	 * @return The given id has been deleted
	 */
	@Override
	public String deleteEmpDashboardById ( Integer id ) {
		EmpDashboard empDashboard = empDashboardRepository.findOne( id );
		if ( empDashboard != null ) {
			empDashboardRepository.delete( id );
			return "The given id:" + id + " has been deleted ";
		} else
			return "The given id:" + id + " is not present";
	}

	/**
	 * Deletes EmpDashboard record if given widget_id exists
	 * @param widgetId
	 * @return Given id has been deleted
	 */
	@Override
	@Transactional
	public String deleteEmpDashboardByWidgetId ( Integer widgetId ) {
		EmpDashboard empDashboard = empDashboardRepository.getEmpDashboardByWidget_Id( widgetId );
		if ( empDashboard != null ) {
			empDashboardRepository.deleteByWidget_Id( widgetId );
			return "The given id:" + empDashboard.getId() + " has been deleted ";
		} else
			return "The given id:" + widgetId + " is not present";
	}

	/**
	 * Get EmpDashboard if EmpWidget Id exists
	 * @param empWidgetId
	 * @return EmpDashboard
	 * @throws EmpDashboardNotFoundException
	 */
	@Override
	public EmpDashboard getEmpDashboardByEmpWidgetId(Integer empWidgetId) throws EmpDashboardNotFoundException {
		EmpDashboard empDashboard = empDashboardRepository.getEmpDashboardByEmpWidget_Id(empWidgetId);
		if ( empDashboard != null)
			return empDashboard;
		else
			throw new EmpDashboardNotFoundException( "No Id found with that Emp dashboard" );
	}
}
