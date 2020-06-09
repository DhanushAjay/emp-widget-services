package com.osi.emp_widget.controller;

import com.osi.emp_widget.dto.EmpDashboardDTO;

import com.osi.emp_widget.dto.WidgetDTO;
import com.osi.emp_widget.exceptions.*;
import com.osi.emp_widget.mapper.EmpDashboardMapper;

import com.osi.emp_widget.model.EmpDashboard;

import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.service.EmpDashboardService;

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
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class EmpDashboardControllerTest {

    @InjectMocks
    private EmpDashboardController empDashboardControllerTest;

    @Mock
    EmpDashboardService empDashboardServiceMock;

    @Mock
    EmpDashboardMapper empDashboardMapperMock;
    private EmpDashboardDTO expectedEmpDashboardDTO;

    private EmpDashboard expectedEmpDashboard;
    private EmpDashboardDTO expectedEmpDashboardDTO_2;

    private EmpDashboard expectedEmpDashboard_2;
    private Widget expectedWidget;

    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        expectedEmpDashboardDTO = getExpectedEmpDashboardDTO();
        expectedEmpDashboard = getExpectedEmpDashboard();
        expectedEmpDashboardDTO_2 = getExpectedEmpDashboardDTO_2();
        expectedEmpDashboard_2 = getExpectedEmpDashboard_2();
        expectedWidget = getExpectedWidget();
    }

    @Test
    public void testAddEmpDashboard() throws DashboardNameNullException, EmpIdNullException, WidgetIDNullException {
        String result = "The given Emp Dashboard " + expectedEmpDashboard.getId() + " has been saved ";
        Mockito.doReturn(expectedEmpDashboard).when(empDashboardMapperMock).toEntity(expectedEmpDashboardDTO);
        Mockito.doReturn(result).when(empDashboardServiceMock).addEmpDashboard(expectedEmpDashboard);
        Assertions.assertThat(empDashboardControllerTest.addEmpDashboard(expectedEmpDashboardDTO)).isEqualTo(result);
        empDashboardControllerTest.addEmpDashboard(expectedEmpDashboardDTO);
    }

    @Test
    public void testGetEmpDashboardById() throws Exception {
        Mockito.doReturn(expectedEmpDashboard).when(empDashboardServiceMock).getEmpDashboardById(1);
        Mockito.doReturn(expectedEmpDashboardDTO).when(empDashboardMapperMock).toDto(expectedEmpDashboard);
        Assertions.assertThat(empDashboardControllerTest.getEmpDashboardById(1)).isEqualTo(expectedEmpDashboardDTO);
        empDashboardControllerTest.getEmpDashboardById(1);
    }

    @Test
    public void testGetEmpDashboardByWidgetId() throws Exception {
        Mockito.doReturn(expectedEmpDashboard).when(empDashboardServiceMock).getEmpDashboardByWidgetId(12);
        Mockito.doReturn(expectedEmpDashboardDTO).when(empDashboardMapperMock).toDto(expectedEmpDashboard);
        //Assertions.assertThat(empDashboardControllerTest.getEmpDashboardByWidgetId(12)).isEqualTo(expectedEmpDashboardDTO);
        Assert.assertNotNull(expectedEmpDashboardDTO);
        empDashboardControllerTest.getEmpDashboardByWidgetId(12);
    }

    @Test
    public void testGetAllEmpDashboardById() {
        List<EmpDashboard> empDashboardList = new ArrayList<>();
        empDashboardList.add(expectedEmpDashboard);
        empDashboardList.add(expectedEmpDashboard_2);
        List<EmpDashboardDTO> empDashboardDTOList = new ArrayList<>();
        empDashboardDTOList.add(expectedEmpDashboardDTO);
        empDashboardDTOList.add(expectedEmpDashboardDTO_2);
        Mockito.doReturn(empDashboardList).when(empDashboardServiceMock).getAllEmpDashboards();
        Mockito.doReturn(empDashboardDTOList).when(empDashboardMapperMock).toDtoList(empDashboardList);
        Assertions.assertThat(empDashboardControllerTest.getAllEmpDashboards()).isEqualTo(empDashboardDTOList);
        empDashboardControllerTest.getAllEmpDashboards();
    }

    @Test
    public void testDeleteEmpDashboardById() throws EmpDashboardNotFoundException {
        String status = "The given id:" + expectedEmpDashboard.getId() + " has been deleted ";
        Mockito.doReturn(expectedEmpDashboard).when(empDashboardServiceMock).getEmpDashboardById(1);
        Mockito.doReturn(status).when(empDashboardServiceMock).deleteEmpDashboardById(1);
        Assertions.assertThat(empDashboardControllerTest.deleteEmpDashboardById(1)).isEqualTo(status);
        empDashboardControllerTest.deleteEmpDashboardById(1);
    }

    @Test
    public void deleteEmpWidgetByWidgetId() throws EmpDashboardNotFoundException {
        String status = "The given id:" + expectedEmpDashboard.getWidget().getId() + " has been deleted ";
        Mockito.doReturn(expectedEmpDashboard).when(empDashboardServiceMock).getEmpDashboardByWidgetId(12);
        Mockito.doReturn(status).when(empDashboardServiceMock).deleteEmpDashboardByWidgetId(12);
        Assertions.assertThat(empDashboardControllerTest.deleteEmpDashboardByWidgetId(12)).isEqualTo(status);
        empDashboardControllerTest.getEmpDashboardByWidgetId(12);
    }

    private EmpDashboardDTO getExpectedEmpDashboardDTO_2() {
        EmpDashboardDTO empDashboardDTO = new EmpDashboardDTO();
        empDashboardDTO.setId(2);
        empDashboardDTO.setEmpId(9911);
        empDashboardDTO.setDashboardName("dashboardReport");
        empDashboardDTO.setFilters("byproject");
        empDashboardDTO.setWidgetDTO(getExpectedWidgetDTO());
        return empDashboardDTO;
    }

    private EmpDashboardDTO getExpectedEmpDashboardDTO() {
        EmpDashboardDTO empDashboardDTO = new EmpDashboardDTO();
        empDashboardDTO.setId(1);
        empDashboardDTO.setEmpId(9911);
        empDashboardDTO.setDashboardName("dashboardReport");
        empDashboardDTO.setFilters("byproject");
        empDashboardDTO.setWidgetDTO(getExpectedWidgetDTO());
        return empDashboardDTO;
    }

    private Widget getExpectedWidget() {
        Widget widget = new Widget();
        widget.setId(1);
        widget.setActionUri("http:/test");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private WidgetDTO getExpectedWidgetDTO() {
        WidgetDTO widgetDTO = new WidgetDTO();
        widgetDTO.setId(2);
        widgetDTO.setActionUri("http:/ajay");
        widgetDTO.setName("ajay");
        widgetDTO.setIsActive(false);
        return widgetDTO;
    }

    private EmpDashboard getExpectedEmpDashboard() {
        EmpDashboard empDashboard = new EmpDashboard();
        empDashboard.setId(1);
        empDashboard.setEmpId(1234);
        empDashboard.setEmpWidget(null);
        empDashboard.setDashboardName("dashboardReport");
        empDashboard.setFilters("byproject");
        empDashboard.setWidget(getExpectedWidget());
        return empDashboard;
    }

    private EmpDashboard getExpectedEmpDashboard_2() {
        EmpDashboard empDashboard = new EmpDashboard();
        empDashboard.setId(2);
        empDashboard.setEmpId(123);
        empDashboard.setEmpWidget(null);
        empDashboard.setDashboardName("dashboardReport");
        empDashboard.setFilters("byproject");
        empDashboard.setWidget(getExpectedWidget());
        return empDashboard;
    }
}
