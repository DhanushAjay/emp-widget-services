package com.osi.emp_widget.mapper;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 10:36 AM
 * Project        : com.osi.emp_widget.mapper
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.osi.emp_widget.dto.EmpDashboardDTO;
import com.osi.emp_widget.model.EmpDashboard;
import org.mapstruct.*;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")

public interface EmpDashboardMapper {

    @Mappings({@Mapping(target = "widgetDTO", source = "widget"),
            @Mapping(target = "widgetSettingsDTO", source = "widget")})
    EmpDashboardDTO toDto ( EmpDashboard empDashboard );
    List<EmpDashboardDTO> toDtoList( List<EmpDashboard> empDashboards );

    @Mappings({@Mapping(target = "widget",source = "widgetDTO"),
            @Mapping(target = "empWidget",source = "empWidgetDTO")})
    EmpDashboard toEntity ( EmpDashboardDTO empDashboardDTO );
}
