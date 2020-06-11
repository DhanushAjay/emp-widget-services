package com.osi.emp_widget.model;
/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 6/6/2020 10:30 AM
 * Project        : com.osi.emp_widget.model
 * Organization   : OSI Digital Pvt Ltd.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "osi_widget_settings")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "widget"})
public class WidgetSettings {
    @Id
    @Column( name = "id", nullable = false, columnDefinition = "int(11) NOT NULL COMMENT 'Unique ID for " +
            "activities'" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "is_auto_refreshed", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isAutoRefreshed = true;

    @Column( name = "is_movable", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isMovable = true;

    @Column( name = "is_closable", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isClosable = true;

    @Column( name = "is_minimizable", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isMinimizable = true;

    @Column( name = "is_maximizable", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isMaximizable = true;

    @Column( name = "is_resizable", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'" )
    @Type( type = "numeric_boolean" )
    private Boolean isResizable = true;

    @Column( name = "created_by", nullable = false, columnDefinition = "int(11) DEFAULT '1'" )
    private Integer createdBy = 1;

    @Column( name = "creation_date", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP" )
    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    @Column( name = "last_updated_by", nullable = false, columnDefinition = "int(11) DEFAULT '1'" )
    private Integer lastUpdatedBy = 1;

    @Column( name = "last_updated_date", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP " +
            "ON" + " UPDATE CURRENT_TIMESTAMP" )
    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    @Column( name = "version", columnDefinition = "bigint(8) DEFAULT NULL" )
    private BigInteger version;

    @Column( name = "enable_settings", columnDefinition = "varchar(255) DEFAULT NULL" )
    private String enableSettings;

    @Column( name = "refresh_interval_sec", columnDefinition = "int(8) DEFAULT NULL" )
    private Integer refreshIntervalSec;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "widget_id")
    private Widget widget;
}
