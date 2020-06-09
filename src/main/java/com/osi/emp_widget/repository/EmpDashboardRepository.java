package com.osi.emp_widget.repository;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 12:32 PM
 * Project        : com.osi.emp_widget.repository
 * Organization   : OSI Digital Pvt Ltd.
 */

import com.osi.emp_widget.model.EmpDashboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDashboardRepository extends CrudRepository<EmpDashboard, Integer > {
    EmpDashboard getEmpDashboardByWidget_Id ( Integer widgetId);
    void deleteByWidget_Id ( Integer widgetId);
    EmpDashboard getEmpDashboardByEmpWidget_Id(Integer empWidgetId);
}
