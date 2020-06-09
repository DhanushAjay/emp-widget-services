package com.osi.emp_widget.dto;
/*
 * Created by     : Bhanu Padhire
 * Employee ID    : NS2066
 * Created  on    : 02-06-2020 11:07 AM
 * Project        : com.osi.emp_widget.dto
 * Organization   : OSI Digital Pvt Ltd.
 */

import lombok.*;

import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ViewDTO {
	//   'created_on': '2019-11-25T05:31:10.390Z',
	private Timestamp creationDate = new Timestamp( System.currentTimeMillis() );

	//'created_by': 'Admin',
	private Integer createdBy = 1;

	//'modified_on': '2019-11-25T05:31:10.390Z',
	private Timestamp lastUpdatedDate = new Timestamp( System.currentTimeMillis() );

	// 'id': 3,
	@Id
	private Integer id;

	// 'imageUrl': 'assets/osione1.png',
	private String thumbnailUri;

	//'title': 'Hours By Project',
	private String title;

	//    'name': 'Project',
	private String name;

	//'is_visible': true,
	private Boolean isVisible;

	//       'seq_num': 1
	private Integer sequenceNumber;

	private WidgetSettingsDTO widgetSettingsDTO;
}