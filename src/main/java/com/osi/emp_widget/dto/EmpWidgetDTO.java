package com.osi.emp_widget.dto;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.dto
 * Organization   : OSI Digital Pvt Ltd.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpWidgetDTO {
    @Id
    private Integer id;

    private Integer empId;

    private Integer widgetCol;

    private Integer sequenceNumber;

    private String thumbnailUri;

    private Boolean isVisible;

    private Integer createdBy = 1;

    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    private Integer lastUpdatedBy = 1;

    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    private BigInteger version;

    private WidgetDTO widgetDTO;

    private WidgetSettingsDTO widgetSettingsDTO;
}
