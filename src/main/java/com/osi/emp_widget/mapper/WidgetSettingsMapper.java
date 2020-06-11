package com.osi.emp_widget.mapper;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:10 AM
 * Project        : com.osi.emp_widget.mapper
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.WidgetSettingsDTO;
import com.osi.emp_widget.model.WidgetSettings;
import org.mapstruct.*;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface WidgetSettingsMapper {
	@Mappings({@Mapping(target = "widgetDTO", source = "widget")})
	WidgetSettingsDTO toDto ( WidgetSettings widgetSettings );
	List<WidgetSettingsDTO> toDtoList( List<WidgetSettings> widgetSettings );

	@Mappings({@Mapping(target = "widget", source = "widgetDTO")})
	WidgetSettings toEntity ( WidgetSettingsDTO widgetSettingsDTO );
}
