package com.osi.emp_widget.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.dto
 * Organization   : OSI Digital Pvt Ltd.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpDashboardDTO {
    @Id
    private Integer id;

    private Integer empId;

    private String dashboardName;

    private String title;

    private String dashboardDesc;

    private String filters;

    private Integer createdBy = 1;

    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    private Integer lastUpdatedBy = 1;

    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    private BigInteger version;

    private WidgetDTO widgetDTO;

    private WidgetSettingsDTO widgetSettingsDTO;

    private EmpWidgetDTO empWidgetDTO;
}
