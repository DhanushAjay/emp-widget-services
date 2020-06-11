package com.osi.emp_widget.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.model
 * Organization   : OSI Digital Pvt Ltd.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "osi_emp_dashboard")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "empWidget"})
public class EmpDashboard {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "int(11) COMMENT 'Unique ID for activities'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_id",nullable = false, columnDefinition = "int(11) COMMENT 'Employee id from osi_employee " +
            "table'")
    private Integer empId;

    @Column(name = "dashboard_name", nullable = false)
    private String dashboardName;

    @Column(name = "title", columnDefinition = "varchar(255) DEFAULT NULL")
    private String title;

    @Column(name = "dashboard_desc", columnDefinition = "varchar(255) DEFAULT NULL")
    private String dashboardDesc;

    @Column(name = "filters", columnDefinition = "varchar(2048) DEFAULT NULL")
    private String filters;

    @Column(name = "created_by", columnDefinition = "int(11) NOT NULL DEFAULT '1'")
    private Integer createdBy = 1;

    @Column(name = "creation_date", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    @Column(name = "last_updated_by", nullable = false, columnDefinition = "int(11) DEFAULT '1'")
    private Integer lastUpdatedBy = 1;

    @Column(name = "last_updated_date", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" )
    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    @Column(name = "version", columnDefinition = "bigint(8) DEFAULT NULL")
    private BigInteger version;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "widget_id")
    private Widget widget;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "emp_widget_id")
    private EmpWidget empWidget;
}
