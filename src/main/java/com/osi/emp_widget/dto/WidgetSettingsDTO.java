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

import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WidgetSettingsDTO {
    @Id
    private Integer id;

    private Boolean isAutoRefreshed = true;

    private Boolean isMovable = true;

    private Boolean isClosable = true;

    private Boolean isMinimizable = true;

    private Boolean isMaximizable = true;

    private Boolean isResizable = true;

    private Integer createdBy = 1;

    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    private Integer lastUpdatedBy = 1;

    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    private BigInteger version;

    private String enableSettings;

    private Integer refreshIntervalSec;

    private WidgetDTO widgetDTO;
}
