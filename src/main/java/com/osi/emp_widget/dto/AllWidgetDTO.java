package com.osi.emp_widget.dto;
/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 3/6/2020 5:49 PM
 * Project        : com.osi.emp_widget.dto
 * Organization   : OSI Digital Pvt Ltd.
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllWidgetDTO {
    @Id
    private Integer id;

    private String name;

    private String preferences;

    private String actionUri;

    private Integer createdBy = 1;

    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    private Integer lastUpdatedBy = 1;

    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    private Boolean isActive = true;

    private String serviceUri;

    private BigInteger version;

    private String type;

    private WidgetSettingsDTO widgetSettingsDTO;

    private Set<EmpWidgetDTO> empWidgetDTO = new HashSet<>();

    private Set<EmpDashboardDTO> empDashboardDTO = new HashSet<>();
}
