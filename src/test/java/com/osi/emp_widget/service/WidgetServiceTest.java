package com.osi.emp_widget.service;

import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetNameEmptyException;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.repository.WidgetRepository;
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

@RunWith(SpringRunner.class)
public class WidgetServiceTest {

    @InjectMocks
    private WidgetServiceImpl widgetServiceTest;

    @Mock
    WidgetRepository widgetRepositoryMock;

    private Widget expectedWidget;
    private Widget expectedWidget_2;

    @Before
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
        expectedWidget = getExpectedWidget();
        expectedWidget_2 = getExpectedWidget_2();
    }

    @Test
    public void testAddWidget() throws WidgetNameEmptyException {
        String result=  "Widget has been saved with id : " + expectedWidget.getId();
        Mockito.when(widgetRepositoryMock.save(expectedWidget)).thenReturn(expectedWidget);
        Assertions.assertThat(widgetServiceTest.addWidget(expectedWidget)).isEqualTo(result);
    }

    @Test
    public void testGetWidgetById() throws IdDoesNotExistException {
        Mockito.when(widgetRepositoryMock.exists(1)).thenReturn(true);
        Mockito.when(widgetServiceTest.getWidgetById(1)).thenReturn(expectedWidget);
        Assertions.assertThat(widgetServiceTest.getWidgetById(1)).isEqualTo(expectedWidget);
    }

    @Test
    public  void getAllWidgets(){
        List<Widget> widgetList=new ArrayList<>();
        widgetList.add(expectedWidget);
        widgetList.add(expectedWidget_2);
        Mockito.when(widgetRepositoryMock.findAll()).thenReturn(widgetList);
        Mockito.when(widgetServiceTest.getAllWidgets()).thenReturn(widgetList);
        Assertions.assertThat(widgetServiceTest.getAllWidgets()).isEqualTo(widgetList);
    }
    @Test
    public void testDeleteEmpDashBoardById(){
        Mockito.when(widgetRepositoryMock.findOne(1)).thenReturn(expectedWidget);
        Mockito.when(widgetRepositoryMock.exists(expectedWidget.getId())).thenReturn(false);
        assertFalse(widgetRepositoryMock.exists(expectedWidget.getId()));
    }

    private Widget getExpectedWidget() {
        Widget widget = new Widget();
        widget.setId(1);
        widget.setActionUri("http:/osius");
        widget.setName("bhanu");
        widget.setIsActive(true);
        return widget;
    }

    private Widget getExpectedWidget_2() {
        Widget widget = new Widget();
        widget.setId(2);
        widget.setActionUri("http:/osi");
        widget.setName("ajay");
        widget.setIsActive(true);
        return widget;
    }

}
