package com.osi.emp_widget.mapper;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.mapper
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.AllWidgetDTO;
import com.osi.emp_widget.model.Widget;
import org.mapstruct.*;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface WidgetMapper {

	@Mappings({@Mapping(target = "widgetSettingsDTO", source = "widgetSettings"),
			@Mapping(target = "empWidgetDTO", source = "empWidget"),
			@Mapping(target = "empDashboardDTO", source = "empDashboard")})
	AllWidgetDTO toDto (Widget widget );
	List<AllWidgetDTO> toDtoList( List<Widget> widgets );

	@Mappings({@Mapping(target = "widgetSettings",source = "widgetSettingsDTO"),
			@Mapping(target = "empWidget",source = "empWidgetDTO"),
			@Mapping(target = "empDashboard",source = "empDashboardDTO") })
	Widget toEntity ( AllWidgetDTO allWidgetDTO );
}
