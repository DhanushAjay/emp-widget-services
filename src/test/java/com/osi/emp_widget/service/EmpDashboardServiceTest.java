package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.DashboardNameNullException;
import com.osi.emp_widget.exceptions.EmpDashboardNotFoundException;
import com.osi.emp_widget.exceptions.EmpIdNullException;
import com.osi.emp_widget.exceptions.WidgetIDNullException;
import com.osi.emp_widget.model.EmpDashboard;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.repository.EmpDashboardRepository;
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

public class EmpDashboardServiceTest {

    @InjectMocks
    private EmpDashboardServiceImpl empDashboardServiceTest;
    @Mock
    EmpDashboardRepository empDashboardRepositoryMock;
    private EmpDashboard expectedEmpDashboard;
    private EmpDashboard expectedEmpDashboard2;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        expectedEmpDashboard = getExpectedEmpDashboard();
        expectedEmpDashboard2 = getExpectedEmpDashboard2();
    }

    @Test
    public void testAddEmpDashboard() throws DashboardNameNullException, EmpIdNullException, WidgetIDNullException {
        String result = "The given Emp Dashboard " + expectedEmpDashboard.getId() + " has been saved ";
        Mockito.doReturn(result).when(empDashboardRepositoryMock).save(expectedEmpDashboard);
        Assertions.assertThat(empDashboardServiceTest.addEmpDashboard(expectedEmpDashboard)).isEqualTo(result);
    }

    @Test
    public void testGetEmpDashboardById() throws EmpDashboardNotFoundException {
        Mockito.when(empDashboardRepositoryMock.findOne(1)).thenReturn(expectedEmpDashboard);
        Mockito.when(empDashboardServiceTest.getEmpDashboardById(1)).thenReturn(expectedEmpDashboard);
        Assertions.assertThat(empDashboardServiceTest.getEmpDashboardById(1)).isEqualTo(expectedEmpDashboard);
    }

    @Test
    public void testGetEmpDashboardByWidgetId() throws EmpDashboardNotFoundException {
        Mockito.when(empDashboardRepositoryMock.getEmpDashboardByWidget_Id(12)).thenReturn(expectedEmpDashboard);
        assertNotNull(empDashboardServiceTest.getEmpDashboardByWidgetId(12));
        Assertions.assertThat(empDashboardServiceTest.getEmpDashboardByWidgetId(12)).isEqualTo(expectedEmpDashboard);
    }

    @Test
    public void testGetAllEmpDashboards() {
        List<EmpDashboard> empDashboardList = new ArrayList<>();
        empDashboardList.add(expectedEmpDashboard);
        empDashboardList.add(expectedEmpDashboard2);
        Mockito.when(empDashboardRepositoryMock.findAll()).thenReturn(empDashboardList);
        Assertions.assertThat(empDashboardRepositoryMock.findAll()).isEqualTo(empDashboardList);
    }

    @Test
    public void testDeleteEmpDashBoardById() {
        Mockito.when(empDashboardRepositoryMock.findOne(1)).thenReturn(expectedEmpDashboard);
        assertFalse(Boolean.parseBoolean(empDashboardServiceTest.deleteEmpDashboardById(1)));
    }

    @Test
    public void testDeleteEmpDashboardByWidgetId() {
        Mockito.when(empDashboardRepositoryMock.getEmpDashboardByWidget_Id(12)).thenReturn(expectedEmpDashboard);
        assertFalse(Boolean.parseBoolean(empDashboardServiceTest.deleteEmpDashboardByWidgetId(12)));
    }

    private Widget getWidget() {
        Widget widget = new Widget();
        widget.setId(12);
        widget.setActionUri("http:/test");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private EmpDashboard getExpectedEmpDashboard2() {
        EmpDashboard empDashboard = new EmpDashboard();
        empDashboard.setEmpId(321);
        empDashboard.setId(1);
        empDashboard.setEmpWidget(null);
        empDashboard.setDashboardName("dashboardReport");
        empDashboard.setFilters("byproject");
        empDashboard.setWidget(getWidget());
        return empDashboard;
    }

    private EmpDashboard getExpectedEmpDashboard() {
        EmpDashboard empDashboard = new EmpDashboard();
        empDashboard.setEmpId(123);
        empDashboard.setId(2);
        empDashboard.setEmpWidget(null);
        empDashboard.setDashboardName("dashboardReport");
        empDashboard.setFilters("byproject");
        empDashboard.setWidget(getWidget());
        return empDashboard;
    }

}
