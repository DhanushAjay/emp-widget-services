package com.osi.emp_widget.model;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 12:12 PM
 * Project        : com.osi.emp_widget.model
 * Organization   : OSI Digital Pvt Ltd.
 */

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
@Table(name = "osi_emp_widget")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "widget"})
public class EmpWidget {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) NOT NULL COMMENT 'Unique ID for activities'")
    private Integer id;

    @Column(name = "emp_id", columnDefinition = "int(11) NOT NULL COMMENT 'Employee id from osi_employee table'")
    private Integer empId;

    @Column(name = "widget_col", columnDefinition = "int(11) DEFAULT NULL")
    private Integer widgetCol;

    @Column(name = "seq_num", columnDefinition = "int(11) DEFAULT NULL")
    private Integer sequenceNumber;

    @Column(name = "thumbnail_uri", columnDefinition = "varchar(255) DEFAULT NULL")
    private String thumbnailUri;

    @Column(name = "is_visible", columnDefinition = "bit(1) DEFAULT NULL")
    @Type( type = "numeric_boolean")
    private Boolean isVisible;

    @Column(name = "created_by", columnDefinition = "int(11) NOT NULL DEFAULT '1'")
    private Integer createdBy = 1;

    @Column(name = "creation_date", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

    @Column(name = "last_updated_by", columnDefinition = "int(11) NOT NULL DEFAULT '1'")
    private Integer lastUpdatedBy = 1;

    @Column(name = "last_updated_date", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

    @Column(name = "version", columnDefinition = "bigint(8) DEFAULT NULL")
    private BigInteger version;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "widget_id")
    private Widget widget;

    @OneToOne(mappedBy = "empWidget", orphanRemoval = true)
    private EmpDashboard empDashboard;
}
