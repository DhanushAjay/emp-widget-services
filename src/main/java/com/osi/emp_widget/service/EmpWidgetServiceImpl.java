package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpWidgetNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.model.EmpWidget;
import com.osi.emp_widget.repository.EmpWidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.isNull;

/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 01:33 PM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
@Service
public class EmpWidgetServiceImpl implements EmpWidgetService{

	@Autowired
	EmpWidgetRepository empWidgetRepository;

	/**
	 * Creates a new EmpWidget
	 * @param empWidget
	 * @return given Emp Widget id has been saved
	 * @throws EmpIdNullException
	 * @throws WidgetIDNullException
	 */
	@Override
	public String addEmpWidget ( EmpWidget empWidget ) throws EmpIdNullException, WidgetIDNullException {
		if (isNull( empWidget.getEmpId() ))
			throw new EmpIdNullException();
		if (isNull( empWidget.getWidget() ) || isNull( empWidget.getWidget().getId()))
			throw new WidgetIDNullException();
		empWidgetRepository.save( empWidget );
		return "The given Emp Widget "+ empWidget.getId()+" has been saved ";
	}

	/**
	 * Get EmpWidget by given id
	 * @param id
	 * @return EmpWidget
	 * @throws EmpWidgetNotFoundException
	 */
	@Override
	public EmpWidget getEmpWidgetById ( Integer id ) throws EmpWidgetNotFoundException {
		EmpWidget empWidget = empWidgetRepository.findOne( id );
		if ( empWidget !=null )
			return empWidget;
		else
			throw new EmpWidgetNotFoundException( "No Id found with that Emp Widget" );
	}

	/**
	 * Get EmpWidget by given widget_id
	 * @param widgetId
	 * @return EmpWidget
	 * @throws EmpWidgetNotFoundException
	 */
	@Override
	@Transactional
	public EmpWidget getEmpWidgetByWidgetId ( Integer widgetId ) throws EmpWidgetNotFoundException {
		EmpWidget empWidget = empWidgetRepository.getEmpWidgetByWidget_Id( widgetId );
		if ( empWidget !=null )
			return empWidget;
		else
			throw new EmpWidgetNotFoundException( "No Id found with that Emp Widget" );
	}

	/**
	 * Get All EmpWidget
	 * @return List<EmpWidget>
	 */
	@Override
	public List<EmpWidget> getAllEmpWidgets (){
		return (List<EmpWidget>) empWidgetRepository.findAll();
	}

	/**
	 * Delete EmpWidget record based on id if exists
	 * @param id
	 * @return given id has been deleted
	 */
	@Override
	public String deleteEmpWidgetById ( Integer id ) {
        EmpWidget empWidget = empWidgetRepository.findOne( id );
        if ( empWidget != null ) {
            empWidgetRepository.delete( id );
            return "The given id:" + id + "has been deleted";
        }else
            return "The given id:"+ id +"is not present";
	}

	/**
	 * Delete EmpWidget record based on widget_id if exists
	 * @param widgetId
	 * @return given id has been deleted
	 */
	@Override
	@Transactional
	public String deleteEmpWidgetByWidgetId ( Integer widgetId ) {
        EmpWidget empWidget = empWidgetRepository.getEmpWidgetByWidget_Id( widgetId );
        if ( empWidget !=null ) {
            empWidgetRepository.deleteByWidget_Id( widgetId );
            return "The given id:" + empWidget.getId() + "has been deleted";
        }else
            return "The given id:"+ widgetId +"is not present";
	}
}
