package com.osi.emp_widget.model;/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 6/6/2020 9:12 AM
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
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "osi_widget")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "empWidget", "empDashboard"})
public class Widget {
	@Id
	@Column(name = "id", columnDefinition = "int(11) NOT NULL COMMENT 'Unique ID for activities'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "preferences",columnDefinition = "varchar(2048) DEFAULT NULL")
	private String preferences;

	@Column(name = "action_uri", columnDefinition = "varchar(2048) DEFAULT NULL")
	private String actionUri;

	@Column(name = "created_by", columnDefinition = "int(11) NOT NULL DEFAULT '1'")
	private Integer createdBy = 1;

	@Column(name = "creation_date", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

	@Column(name = "last_updated_by", columnDefinition = "int(11) NOT NULL DEFAULT '1'")
	private Integer lastUpdatedBy = 1;

	@Column(name = "last_updated_date", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

	@Column(name = "is_active", columnDefinition = "bit(1) DEFAULT b'1' COMMENT '(1)Yes,(0)No'")
	@Type(type = "numeric_boolean")
	private Boolean isActive = true;

	@Column(name = "service_uri", columnDefinition = "varchar(1024) DEFAULT NULL")
	private String serviceUri;

	@Column(name = "version", columnDefinition = "bigint(8) DEFAULT NULL")
	private BigInteger version;

	@Column(name = "type", columnDefinition = "varchar(255) DEFAULT NULL")
	private String type;

	@OneToOne(mappedBy = "widget", orphanRemoval = true)
	private WidgetSettings widgetSettings;

	@OneToMany(mappedBy = "widget", cascade = CascadeType.ALL)
	private Set<EmpWidget> empWidget = new HashSet<>();

	@OneToMany(mappedBy = "widget", cascade = CascadeType.ALL)
	private Set<EmpDashboard> empDashboard = new HashSet<>();
}
