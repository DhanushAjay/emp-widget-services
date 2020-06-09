package com.osi.emp_widget.repository;
/*
 * Created by     : Shiva Rao Sambu
 * Employee ID    : NS2064
 * Created  on    : 02-06-2020 12:40 PM
 * Project        : com.osi.emp_widget.repository
 * Organization   : OSI Digital Pvt Ltd.
 */

import com.osi.emp_widget.model.WidgetSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetSettingsRepository extends CrudRepository<WidgetSettings, Integer > {
    WidgetSettings getWidgetSettingsByWidget_Id ( Integer widgetId);
    void deleteByWidget_Id ( Integer widgetId);
}
