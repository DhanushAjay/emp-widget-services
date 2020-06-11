package com.osi.emp_widget.dto;/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.dto
 * Organization   : OSI Digital Pvt Ltd.
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class WidgetDTO {
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
	@JsonIgnore
	private Set<EmpWidgetDTO> empWidgetDTO = new HashSet<>();
	@JsonIgnore
	private Set<EmpDashboardDTO> empDashboardDTO = new HashSet<>();
}
