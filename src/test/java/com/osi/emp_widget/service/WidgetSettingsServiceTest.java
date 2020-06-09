package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.model.WidgetSettings;
import com.osi.emp_widget.repository.WidgetSettingsRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class WidgetSettingsServiceTest {

    @InjectMocks
    private WidgetSettingsServiceImpl widgetSettingsServiceTest;

    @Mock
    WidgetSettingsRepository widgetSettingsRepositoryMock;


    private WidgetSettings expectedWidgetSettings;
    private WidgetSettings expectedWidgetSettings_2;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        expectedWidgetSettings = getExpectedWidgetSettings();
        expectedWidgetSettings_2 = getExpectedWidgetSettings_2();
    }

    @Test
    public void testAddWidget() throws Exception {
        String result = "Widget settings with ID :" + expectedWidgetSettings.getId() + "has been saved";
        Mockito.doReturn(result).when(widgetSettingsRepositoryMock).save(expectedWidgetSettings);
        Assertions.assertThat(widgetSettingsServiceTest.addWidgetSettings(expectedWidgetSettings)).isEqualTo(result);
    }

    @Test
    public void testGetWidgetSettingsById() throws IdDoesNotExistException {
        Mockito.when(widgetSettingsRepositoryMock.exists(1)).thenReturn(true);
        Mockito.when(widgetSettingsServiceTest.getWidgetSettingsById(1)).thenReturn(expectedWidgetSettings);
        Assertions.assertThat(widgetSettingsServiceTest.getWidgetSettingsById(1)).isEqualTo(expectedWidgetSettings);
    }

    @Test
    public void testGetWidgetSettingsByWidgetId() {
        Mockito.when(widgetSettingsRepositoryMock.getWidgetSettingsByWidget_Id(21)).thenReturn(expectedWidgetSettings);
        assertNotNull(widgetSettingsRepositoryMock.getWidgetSettingsByWidget_Id(21));
        Assertions.assertThat(widgetSettingsRepositoryMock.getWidgetSettingsByWidget_Id(21)).isEqualTo(expectedWidgetSettings);
    }

    @Test
    public void getAllWidgetSettings() {
        List<WidgetSettings> widgetSettingsList = new ArrayList<>();
        widgetSettingsList.add(expectedWidgetSettings);
        widgetSettingsList.add(expectedWidgetSettings_2);
        Mockito.when(widgetSettingsRepositoryMock.findAll()).thenReturn(widgetSettingsList);
        Assertions.assertThat(widgetSettingsRepositoryMock.findAll()).isEqualTo(widgetSettingsList);
    }

    @Test
    public void testDeleteWidgetSettingsById() {
        Mockito.when(widgetSettingsRepositoryMock.findOne(1)).thenReturn(expectedWidgetSettings);
        Mockito.when(widgetSettingsRepositoryMock.exists(expectedWidgetSettings.getId())).thenReturn(false);
        assertFalse(widgetSettingsRepositoryMock.exists(expectedWidgetSettings.getId()));
    }

    @Test
    public void testDeleteWidgetSettingsByWidgetId() {
        Mockito.when(widgetSettingsRepositoryMock.getWidgetSettingsByWidget_Id(21)).thenReturn(expectedWidgetSettings);
        Mockito.when(widgetSettingsRepositoryMock.exists(expectedWidgetSettings.getWidget().getId())).thenReturn(false);
        assertFalse(widgetSettingsRepositoryMock.exists(expectedWidgetSettings.getWidget().getId()));
    }

    private Widget getWidget() {
        Widget widget = new Widget();
        widget.setId(21);
        widget.setActionUri("http:/test");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private WidgetSettings getExpectedWidgetSettings() {

        WidgetSettings widgetSettings = new WidgetSettings();
        widgetSettings.setId(1);
        widgetSettings.setIsAutoRefreshed(true);
        widgetSettings.setCreatedBy(1);
        widgetSettings.setEnableSettings("Enable");
        widgetSettings.setWidget(getWidget());

        return widgetSettings;
    }

    private WidgetSettings getExpectedWidgetSettings_2() {

        WidgetSettings widgetSettings = new WidgetSettings();
        widgetSettings.setId(2);
        widgetSettings.setIsAutoRefreshed(true);
        widgetSettings.setCreatedBy(1);
        widgetSettings.setEnableSettings("Enable");
        widgetSettings.setWidget(getWidget());

        return widgetSettings;
    }


}
