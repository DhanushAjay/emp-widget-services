package com.osi.emp_widget.controller;

import com.osi.emp_widget.dto.WidgetSettingsDTO;
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.mapper.WidgetSettingsMapper;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.model.WidgetSettings;
import com.osi.emp_widget.service.WidgetSettingsService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class WidgetSettingsControllerTest {
    @InjectMocks
    private WidgetSettingsController widgetSettingsControllerTest;

    @Mock
    WidgetSettingsService widgetSettingsServiceMock;

    @Mock
    WidgetSettingsMapper widgetSettingsMapperMock;

    private WidgetSettingsDTO expectedWidgetSettingsDTO;
    private WidgetSettings expectedWidgetSettings;
    private List<WidgetSettings> listWidgetSettings = new ArrayList<>();
    private List<WidgetSettingsDTO> listWidgetSettingsDTO = new ArrayList<>();

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        expectedWidgetSettingsDTO = getExpectedWidgetSettingsDTO();
        expectedWidgetSettings = getExpectedWidgetSettings();
    }

    @Test
    public void createWidgetSettings() throws Exception {
        String status = "Employee Settings with ID :" + expectedWidgetSettings.getId() + "has been saved";
        Mockito.doReturn(expectedWidgetSettings).when(widgetSettingsMapperMock).toEntity(expectedWidgetSettingsDTO);
        Mockito.doReturn(status).when(widgetSettingsServiceMock).addWidgetSettings(expectedWidgetSettings);
        Assertions.assertThat(widgetSettingsControllerTest.createWidgetSettings(expectedWidgetSettingsDTO)).isEqualTo(status);
        widgetSettingsControllerTest.createWidgetSettings(expectedWidgetSettingsDTO);

    }

    @Test
    public void getWidgetSettingsById() throws IdDoesNotExistException {
        Mockito.doReturn(expectedWidgetSettings).when(widgetSettingsServiceMock).getWidgetSettingsById(1);
        Mockito.doReturn(expectedWidgetSettingsDTO).when(widgetSettingsMapperMock).toDto(expectedWidgetSettings);
        Assertions.assertThat(widgetSettingsControllerTest.getWidgetSettingsById(1)).isEqualTo(expectedWidgetSettingsDTO);
        widgetSettingsControllerTest.getWidgetSettingsById(1);
    }

    @Test
    public void getAllWidgetSettings() {
        Mockito.doReturn(listWidgetSettings).when(widgetSettingsServiceMock).getAllWidgetSettings();
        Mockito.doReturn(listWidgetSettingsDTO).when(widgetSettingsMapperMock).toDtoList(listWidgetSettings);
        Assertions.assertThat(widgetSettingsControllerTest.getAllWidgetSettings()).isEqualTo(listWidgetSettingsDTO);
        widgetSettingsControllerTest.getAllWidgetSettings();
    }

    @Test
    public void getWidgetSettingsByWidgetId() throws IdDoesNotExistException {
        Mockito.doReturn(expectedWidgetSettings).when(widgetSettingsServiceMock).getWidgetSettingsByWidgetId(12);
        Mockito.doReturn(expectedWidgetSettingsDTO).when(widgetSettingsMapperMock).toDto(expectedWidgetSettings);
        Assertions.assertThat(widgetSettingsControllerTest.getWidgetSettingsByWidgetId(12)).isEqualTo(expectedWidgetSettingsDTO);
        widgetSettingsControllerTest.getWidgetSettingsByWidgetId(12);
    }

    @Test
    public void deleteWidgetSettingsById() throws IdDoesNotExistException {

        String status = "Widget Settings with ID :  " + expectedWidgetSettings.getId() + "  has been deleted successfully";
        Mockito.doReturn(expectedWidgetSettings).when(widgetSettingsServiceMock).getWidgetSettingsById(1);
        Mockito.doReturn(status).when(widgetSettingsServiceMock).deleteWidgetSettingsById(1);
        Assertions.assertThat(widgetSettingsControllerTest.deleteWidgetSettingsById(1)).isEqualTo(status);
        widgetSettingsControllerTest.deleteWidgetSettingsById(1);
    }

    @Test
    public void deleteWidgetSettingsByWidgetId() throws IdDoesNotExistException {
        String status = "The given id " + expectedWidgetSettings.getWidget().getId() + "has been deleted ";
        Mockito.doReturn(expectedWidgetSettings).when(widgetSettingsServiceMock).getWidgetSettingsByWidgetId(12);
        Mockito.doReturn(status).when(widgetSettingsServiceMock).deleteWidgetSettingsByWidgetId(12);
        Assertions.assertThat(widgetSettingsControllerTest.deleteWidgetSettingsByWidgetId(12)).isEqualTo(status);
        widgetSettingsControllerTest.deleteWidgetSettingsByWidgetId(12);
    }

    private Widget getExpectedWidget() {

        Widget widget = new Widget();
        widget.setId(12);
        widget.setActionUri("http:/osius");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private WidgetSettingsDTO getExpectedWidgetSettingsDTO() {

        WidgetSettingsDTO widgetSettingsDTO = new WidgetSettingsDTO();
        widgetSettingsDTO.setId(1);
        widgetSettingsDTO.setCreatedBy(123);
        widgetSettingsDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetSettingsDTO.setLastUpdatedBy(1234);
        widgetSettingsDTO.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetSettingsDTO.setVersion(BigInteger.ONE);
        widgetSettingsDTO.setIsAutoRefreshed(true);
        widgetSettingsDTO.setEnableSettings("no");
        widgetSettingsDTO.setIsClosable(true);
        widgetSettingsDTO.setIsMaximizable(true);
        widgetSettingsDTO.setIsMinimizable(true);
        widgetSettingsDTO.setIsMovable(true);
        widgetSettingsDTO.setIsResizable(true);
        widgetSettingsDTO.setRefreshIntervalSec(1);

        WidgetSettingsDTO widgetSettingsDTO2 = new WidgetSettingsDTO();
        widgetSettingsDTO2.setId(2);
        widgetSettingsDTO2.setCreatedBy(125);
        widgetSettingsDTO2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetSettingsDTO2.setLastUpdatedBy(1235);
        widgetSettingsDTO2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetSettingsDTO2.setVersion(BigInteger.ZERO);
        widgetSettingsDTO2.setIsAutoRefreshed(true);
        widgetSettingsDTO2.setEnableSettings("yes");
        widgetSettingsDTO2.setIsClosable(true);
        widgetSettingsDTO2.setIsMaximizable(true);
        widgetSettingsDTO2.setIsMinimizable(true);
        widgetSettingsDTO2.setIsMovable(true);
        widgetSettingsDTO2.setIsResizable(true);
        widgetSettingsDTO2.setRefreshIntervalSec(2);

        listWidgetSettingsDTO.add(widgetSettingsDTO);
        listWidgetSettingsDTO.add(widgetSettingsDTO2);
        return widgetSettingsDTO;
    }

    private WidgetSettings getExpectedWidgetSettings() {

        WidgetSettings widgetSettings = new WidgetSettings();
        widgetSettings.setId(1);
        widgetSettings.setCreatedBy(123);
        widgetSettings.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetSettings.setLastUpdatedBy(1234);
        widgetSettings.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetSettings.setVersion(BigInteger.ONE);
        widgetSettings.setIsAutoRefreshed(true);
        widgetSettings.setEnableSettings("no");
        widgetSettings.setIsClosable(true);
        widgetSettings.setIsMaximizable(true);
        widgetSettings.setIsMinimizable(true);
        widgetSettings.setIsMovable(true);
        widgetSettings.setIsResizable(true);
        widgetSettings.setRefreshIntervalSec(1);
        widgetSettings.setWidget(getExpectedWidget());

        WidgetSettings widgetSettings2 = new WidgetSettings();
        widgetSettings2.setId(2);
        widgetSettings2.setCreatedBy(125);
        widgetSettings2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetSettings2.setLastUpdatedBy(1235);
        widgetSettings2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetSettings2.setVersion(BigInteger.ZERO);
        widgetSettings2.setIsAutoRefreshed(true);
        widgetSettings2.setEnableSettings("yes");
        widgetSettings2.setIsClosable(true);
        widgetSettings2.setIsMaximizable(true);
        widgetSettings2.setIsMinimizable(true);
        widgetSettings2.setIsMovable(true);
        widgetSettings2.setIsResizable(true);
        widgetSettings2.setRefreshIntervalSec(2);
        widgetSettings2.setWidget(getExpectedWidget());
        listWidgetSettings.add(widgetSettings);
        listWidgetSettings.add(widgetSettings2);
        return widgetSettings;
    }
}
