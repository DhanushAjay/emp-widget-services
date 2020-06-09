package com.osi.emp_widget.mapper;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 10:45 AM
 * Project        : com.osi.emp_widget.mapper
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.EmpWidgetDTO;
import com.osi.emp_widget.dto.ViewDTO;
import com.osi.emp_widget.model.EmpWidget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface EmpWidgetMapper {
    @Mappings({@Mapping(target = "widgetDTO",source = "widget"),
            @Mapping(target = "widgetSettingsDTO", source = "widget")})
    EmpWidgetDTO toDto ( EmpWidget empWidget );
    List<EmpWidgetDTO> toDtoList( List<EmpWidget> empWidgets );

    @Mappings({@Mapping(target = "widget",source = "widgetDTO")})
    EmpWidget toEntity ( EmpWidgetDTO empWidgetDTO );

    @Mappings({@Mapping(target = "title", source = "empDashboard.title"),
            @Mapping(target = "name", source = "widget.name"),
            @Mapping(target = "widgetSettingsDTO", source = "widget")})
    ViewDTO toViewDto (EmpWidget empWidget );
}


