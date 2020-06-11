package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetNameEmptyException;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 01:36 PM
 * Project        : com.osi.emp_widget.service
 * Organization   : OSI Digital Pvt Ltd.
 */
@Service
public class WidgetServiceImpl implements WidgetService {

	@Autowired
	WidgetRepository widgetRepository;

	/**
	 * Create a new Widget
	 * @param widget
	 * @return Widget has been saved with id
	 * @throws WidgetNameEmptyException
	 */
	@Override
	public String addWidget ( Widget widget ) throws WidgetNameEmptyException {
		try {
			widgetRepository.save( widget );
		} catch ( DataIntegrityViolationException e ) {
			throw new WidgetNameEmptyException();
		}
		return "Widget has been saved with id : " + widget.getId();
	}

	/**
	 * Get all Widgets
	 * @return List<Widget>
	 */
	@Override
	public List<Widget> getAllWidgets () {
		return (List<Widget>) widgetRepository.findAll();
	}

	/**
	 * Get Widget by given id
	 * @param id
	 * @return Widget
	 * @throws IdDoesNotExistException
	 */

	@Override
	public Widget getWidgetById ( Integer id ) throws IdDoesNotExistException {
		if ( !widgetRepository.exists( id ) ) {
			throw new IdDoesNotExistException( id );
		}
		return widgetRepository.findOne( id );
	}

	/**
	 * Delete Widget record based on id if exists
	 * @param id
	 * @return given id has been deleted successfully
	 * @throws IdDoesNotExistException
	 */
	@Override
	public String deleteWidgetById ( Integer id ) throws IdDoesNotExistException {
		if ( !widgetRepository.exists( id ) ) {
			throw new IdDoesNotExistException( id );
		}
		widgetRepository.delete( id );
		return "Widget with ID : " + id + " has been deleted successfully";
	}

}
