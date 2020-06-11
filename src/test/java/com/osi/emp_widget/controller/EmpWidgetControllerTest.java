package com.osi.emp_widget.controller;


import com.osi.emp_widget.dto.EmpWidgetDTO;
import com.osi.emp_widget.dto.ViewDTO;
import com.osi.emp_widget.dto.WidgetDTO;
import com.osi.emp_widget.dto.WidgetSettingsDTO;
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.EmpWidgetNotFoundException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.mapper.EmpWidgetMapper;
import com.osi.emp_widget.model.EmpWidget;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.service.EmpWidgetService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
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
public class EmpWidgetControllerTest {
    @InjectMocks
    private EmpWidgetController empWidgetControllerTest;

    @Mock
    EmpWidgetService empWidgetServiceMock;

    @Mock
    EmpWidgetMapper empWidgetMapperMock;

    private EmpWidgetDTO expectedEmpWidgetDTO;
    private EmpWidget expectedEmpWidget;
    private Widget expectedWidget;
    private WidgetDTO expectedWidgetDTO;
    private ViewDTO expectedViewDTO;
    private List<EmpWidget> empWidgetList = new ArrayList<>();
    private List<EmpWidgetDTO> empWidgetDTOList = new ArrayList<>();

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        expectedEmpWidgetDTO = getExpectedEmpWidgetDTO();
        expectedEmpWidget = getExpectedEmpWidget();
        expectedWidget = getExpectedWidget();
        expectedWidgetDTO = getExpectedWidgetDTO();
        expectedViewDTO = getExpectedViewDTO();
    }

    @Test
    public void createEmpWidget() throws EmpIdNullException, WidgetIDNullException {
        String status = "The given Emp Widget "+ expectedEmpWidget.getId() +" has been saved ";
        Mockito.doReturn(expectedEmpWidget).when(empWidgetMapperMock).toEntity(expectedEmpWidgetDTO);
        Mockito.doReturn(status).when(empWidgetServiceMock).addEmpWidget(expectedEmpWidget);
        Assertions.assertThat(empWidgetControllerTest.createEmpWidget(expectedEmpWidgetDTO)).isEqualTo(status);
        empWidgetControllerTest.createEmpWidget(expectedEmpWidgetDTO);
    }

    @Test
    public void getEmpWidgetById() throws EmpWidgetNotFoundException {
        Mockito.doReturn(expectedEmpWidget).when(empWidgetServiceMock).getEmpWidgetById(1);
        Mockito.doReturn(expectedEmpWidgetDTO).when(empWidgetMapperMock).toDto(expectedEmpWidget);
        Assertions.assertThat(empWidgetControllerTest.getEmpWidgetById(1)).isEqualTo(expectedEmpWidgetDTO);
        empWidgetControllerTest.getEmpWidgetById(1);
    }

    @Test
    public void getAllEmpWidgets(){
        Mockito.doReturn(empWidgetList).when(empWidgetServiceMock).getAllEmpWidgets();
        Mockito.doReturn(empWidgetDTOList).when(empWidgetMapperMock).toDtoList(empWidgetList);
        Assertions.assertThat(empWidgetControllerTest.getAllEmpWidgets()).isEqualTo(empWidgetDTOList);
        empWidgetControllerTest.getAllEmpWidgets();
    }

    @Test
    public void getEmpWidgetByWidgetId() throws EmpWidgetNotFoundException {
        Mockito.doReturn(expectedEmpWidget).when(empWidgetServiceMock).getEmpWidgetByWidgetId(12);
        Mockito.doReturn(expectedEmpWidgetDTO).when(empWidgetMapperMock).toDto(expectedEmpWidget);
        Assertions.assertThat(empWidgetControllerTest.getEmpWidgetByWidgetId(12)).isEqualTo(expectedEmpWidgetDTO);
        empWidgetControllerTest.getEmpWidgetByWidgetId(12);
    }

    @Test
    public void deleteEmpWidgetById() throws EmpWidgetNotFoundException {
        String status = "The given id:" + expectedEmpWidget.getId() + "has been deleted";
        Mockito.doReturn(expectedEmpWidget).when(empWidgetServiceMock).getEmpWidgetById(1);
        Mockito.doReturn(status).when(empWidgetServiceMock).deleteEmpWidgetById(1);
        Assertions.assertThat(empWidgetControllerTest.deleteEmpWidgetById(1)).isEqualTo(status);
        empWidgetControllerTest.deleteEmpWidgetById(1);
    }

    @Test
    public void deleteEmpWidgetByWidgetId() throws EmpWidgetNotFoundException {
        String status = "The given id:" + expectedEmpWidget.getWidget().getId() + "has been deleted";
        Mockito.doReturn(expectedEmpWidget).when(empWidgetServiceMock).getEmpWidgetByWidgetId(12);
        Mockito.doReturn(status).when(empWidgetServiceMock).deleteEmpWidgetByWidgetId(12);
        Assertions.assertThat(empWidgetControllerTest.deleteEmpWidgetByWidgetId(12)).isEqualTo(status);
        empWidgetControllerTest.deleteEmpWidgetByWidgetId(12);
    }

    @Test
    public void getWidgetSettingsById() throws EmpWidgetNotFoundException {
        Mockito.doReturn(expectedEmpWidget).when(empWidgetServiceMock).getEmpWidgetById(Mockito.anyInt());
        Mockito.doReturn(expectedViewDTO).when(empWidgetMapperMock).toViewDto(expectedEmpWidget);
        Assert.assertNotNull(expectedViewDTO);
        Assertions.assertThat(empWidgetControllerTest.getWidgetSettingsById(expectedEmpWidget.getId())).isEqualTo(expectedViewDTO);
        empWidgetControllerTest.getWidgetSettingsById(expectedEmpWidget.getId());
    }

    private Widget getExpectedWidget(){
        Widget widget = new Widget();
        widget.setId(12);
        widget.setActionUri("yes");
        widget.setIsActive(true);
        widget.setCreatedBy(123);
        return widget;
    }
    private WidgetDTO getExpectedWidgetDTO(){
        WidgetDTO widgetDTO = new WidgetDTO();
        widgetDTO.setId(1);
        widgetDTO.setActionUri("no");
        widgetDTO.setIsActive(false);
        widgetDTO.setCreatedBy(124);
        return widgetDTO;
    }

    private ViewDTO getExpectedViewDTO(){
        ViewDTO viewDTO = new ViewDTO();
        viewDTO.setId(15);
        viewDTO.setCreatedBy(123);
        viewDTO.setIsVisible(true);
        viewDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
        viewDTO.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        viewDTO.setName("ajay");
        viewDTO.setSequenceNumber(1);
        viewDTO.setThumbnailUri("img.uri");
        viewDTO.setTitle("project 1");
        viewDTO.setWidgetSettingsDTO(getExpectedWidgetSettingsDTO());
        return viewDTO;
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
        return widgetSettingsDTO;
    }

    private EmpWidget getExpectedEmpWidget() {
        EmpWidget empWidget = new EmpWidget();
        empWidget.setCreatedBy(123);
        empWidget.setCreationDate(new Timestamp(System.currentTimeMillis()));
        empWidget.setEmpId(3332);
        empWidget.setId(1);
        empWidget.setLastUpdatedBy(124);
        empWidget.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        empWidget.setSequenceNumber(1);
        empWidget.setThumbnailUri("img.url");
        empWidget.setVersion(BigInteger.ONE);
        empWidget.setIsVisible(true);
        empWidget.setWidgetCol(2);
        empWidget.setWidget(getExpectedWidget());

        EmpWidget empWidget2 = new EmpWidget();
        empWidget2.setCreatedBy(124);
        empWidget2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        empWidget2.setEmpId(1332);
        empWidget2.setId(2);
        empWidget2.setLastUpdatedBy(125);
        empWidget2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        empWidget2.setSequenceNumber(2);
        empWidget2.setThumbnailUri("png.url");
        empWidget2.setVersion(BigInteger.ZERO);
        empWidget2.setIsVisible(true);
        empWidget2.setWidgetCol(3);

        empWidgetList.add(empWidget);
        empWidgetList.add(empWidget2);
        return empWidget;
    }

    private EmpWidgetDTO getExpectedEmpWidgetDTO() {
        EmpWidgetDTO empWidgetDTO = new EmpWidgetDTO();
        empWidgetDTO.setCreatedBy(123);
        empWidgetDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
        empWidgetDTO.setEmpId(12);
        empWidgetDTO.setId(1);
        empWidgetDTO.setLastUpdatedBy(124);
        empWidgetDTO.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        empWidgetDTO.setSequenceNumber(1);
        empWidgetDTO.setThumbnailUri("img.url");
        empWidgetDTO.setVersion(BigInteger.ONE);
        empWidgetDTO.setIsVisible(true);
        empWidgetDTO.setWidgetCol(2);
        empWidgetDTO.setWidgetDTO(getExpectedWidgetDTO());

        EmpWidgetDTO empWidgetDTO2 = new EmpWidgetDTO();
        empWidgetDTO2.setCreatedBy(124);
        empWidgetDTO2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        empWidgetDTO2.setEmpId(13);
        empWidgetDTO2.setId(2);
        empWidgetDTO2.setLastUpdatedBy(125);
        empWidgetDTO2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        empWidgetDTO2.setSequenceNumber(2);
        empWidgetDTO2.setThumbnailUri("png.url");
        empWidgetDTO2.setVersion(BigInteger.ZERO);
        empWidgetDTO2.setIsVisible(true);
        empWidgetDTO2.setWidgetCol(3);

        empWidgetDTOList.add(empWidgetDTO);
        empWidgetDTOList.add(empWidgetDTO2);
        return empWidgetDTO;
    }
}
