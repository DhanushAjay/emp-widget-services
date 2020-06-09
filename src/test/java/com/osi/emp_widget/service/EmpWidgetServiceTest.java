package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.*;
import com.osi.emp_widget.model.EmpWidget;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.repository.EmpWidgetRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class EmpWidgetServiceTest {
    @InjectMocks
    private EmpWidgetServiceImpl empWidgetServiceTest;
    @Mock
    EmpWidgetRepository empWidgetRepositoryMock;
    private EmpWidget exceptedEmpWidget;
    private EmpWidget exceptedEmpWidget_2;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        exceptedEmpWidget = getExpectedEmpWidget();
        exceptedEmpWidget_2 = getExpectedEmpWidget_2();
    }


    @Test
    public void testAddEmpWidget() throws EmpIdNullException, WidgetIDNullException {
        String result = "The given Emp Widget " + exceptedEmpWidget.getId() + " has been saved ";
        Mockito.when(empWidgetRepositoryMock.save(exceptedEmpWidget)).thenReturn(exceptedEmpWidget);
        assertThat(empWidgetServiceTest.addEmpWidget(exceptedEmpWidget)).isEqualTo(result);

    }

    @Test
    public void testGetEmpWidgetById() throws EmpWidgetNotFoundException {
        Mockito.when(empWidgetRepositoryMock.findOne(1)).thenReturn(exceptedEmpWidget);
        Mockito.when(empWidgetServiceTest.getEmpWidgetById(1)).thenReturn(exceptedEmpWidget);
        assertThat(empWidgetServiceTest.getEmpWidgetById(1)).isEqualTo(exceptedEmpWidget);
    }

    @Test
    public void testGetAllWidgets() {
        List<EmpWidget> empWidgetList = new ArrayList<>();
        empWidgetList.add(exceptedEmpWidget);
        empWidgetList.add(exceptedEmpWidget_2);
        Mockito.when(empWidgetRepositoryMock.findAll()).thenReturn(empWidgetList);
        Mockito.when(empWidgetServiceTest.getAllEmpWidgets()).thenReturn(empWidgetList);
        assertThat(empWidgetServiceTest.getAllEmpWidgets()).isEqualTo(empWidgetList);
    }

    @Test
    public void testDeleteEmpWidgetById() {
        Mockito.when(empWidgetRepositoryMock.findOne(1)).thenReturn(exceptedEmpWidget);
        Mockito.when(empWidgetRepositoryMock.exists(exceptedEmpWidget.getId())).thenReturn(false);
        assertFalse(empWidgetRepositoryMock.exists(exceptedEmpWidget.getId()));
    }

    @Test
    public void testGetEmpWidgetByWidgetId() {
        Mockito.when(empWidgetRepositoryMock.getEmpWidgetByWidget_Id(12)).thenReturn(exceptedEmpWidget);
        assertNotNull(empWidgetRepositoryMock.getEmpWidgetByWidget_Id(12));
        assertThat(empWidgetRepositoryMock.getEmpWidgetByWidget_Id(12)).isEqualTo(exceptedEmpWidget);
    }

    @Test
    public void testDeleteEmpWidgetByWidgetId() {
        Mockito.when(empWidgetRepositoryMock.getEmpWidgetByWidget_Id(12)).thenReturn(exceptedEmpWidget);
        Mockito.when(empWidgetRepositoryMock.exists(exceptedEmpWidget.getWidget().getId())).thenReturn(false);
        assertFalse(empWidgetRepositoryMock.exists(exceptedEmpWidget.getWidget().getId()));
    }

    private Widget getExpectedWidget() {
        Widget widget = new Widget();
        widget.setId(12);
        widget.setActionUri("http:/osius");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private EmpWidget getExpectedEmpWidget() {
        EmpWidget empWidget = new EmpWidget();
        empWidget.setId(1);
        empWidget.setEmpId(11);
        empWidget.setIsVisible(true);
        empWidget.setWidget(getExpectedWidget());
        return empWidget;
    }

    private EmpWidget getExpectedEmpWidget_2() {
        EmpWidget empWidget = new EmpWidget();
        empWidget.setId(2);
        empWidget.setEmpId(22);
        empWidget.setIsVisible(true);
        empWidget.setWidget(getExpectedWidget());
        return empWidget;
    }

}
