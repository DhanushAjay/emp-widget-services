package com.osi.emp_widget.controller;

import com.osi.emp_widget.dto.AllWidgetDTO;
import com.osi.emp_widget.exceptions.IdDoesNotExistException;
import com.osi.emp_widget.exceptions.WidgetNameEmptyException;
import com.osi.emp_widget.mapper.WidgetMapper;
import com.osi.emp_widget.model.Widget;
import com.osi.emp_widget.service.WidgetService;
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
public class WidgetControllerTest {
    @InjectMocks
    WidgetController widgetControllerTest;

    @Mock
    WidgetService widgetServiceMock;

    @Mock
    WidgetMapper widgetMapperMock;

    private AllWidgetDTO expectedWidgetDTO;
    private Widget expectedWidget;
    private List<Widget> widgetList = new ArrayList<>();
    private List<AllWidgetDTO> widgetDTOList = new ArrayList<>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        expectedWidget = getExpectedWidget();
        expectedWidgetDTO = getExpectedWidgetDTO();
    }

    @Test
    public void addWidget() throws WidgetNameEmptyException {
        String status = "Widget has been saved with id : " + expectedWidget.getId();
        Mockito.doReturn(expectedWidget).when(widgetMapperMock).toEntity(expectedWidgetDTO);
        Mockito.doReturn(status).when(widgetServiceMock).addWidget(expectedWidget);
        Assertions.assertThat(widgetControllerTest.createWidget(expectedWidgetDTO)).isEqualTo(status);
        widgetControllerTest.createWidget(expectedWidgetDTO);
    }

    @Test
    public void getWidgetById() throws IdDoesNotExistException {
        Mockito.doReturn(expectedWidget).when(widgetServiceMock).getWidgetById(1);
        Mockito.doReturn(expectedWidgetDTO).when(widgetMapperMock).toDto(expectedWidget);
        Assertions.assertThat(widgetControllerTest.getWidgetById(1)).isEqualTo(expectedWidgetDTO);
        widgetControllerTest.getWidgetById(1);
    }

    @Test
    public void getAllWidgets(){
        Mockito.doReturn(widgetDTOList).when(widgetMapperMock).toDtoList(widgetList);
        Mockito.doReturn(widgetList).when(widgetServiceMock).getAllWidgets();
        Assertions.assertThat(widgetControllerTest.getAllWidgets()).isEqualTo(widgetDTOList);
        widgetControllerTest.getAllWidgets();
    }

    @Test
    public void deleteWidgetById() throws IdDoesNotExistException {
        String status = "Widget with ID : " + expectedWidget.getId() + " has been deleted successfully";
        Mockito.doReturn(expectedWidget).when(widgetServiceMock).getWidgetById(1);
        Mockito.doReturn(status).when(widgetServiceMock).deleteWidgetById(1);
        Assertions.assertThat(widgetControllerTest.deleteWidgetById(1)).isEqualTo(status);
        widgetControllerTest.deleteWidgetById(1);
    }

    private Widget getExpectedWidget(){
        Widget widget = new Widget();
        widget.setId(1);
        widget.setActionUri("yes");
        widget.setIsActive(true);
        widget.setCreatedBy(123);
        widget.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widget.setLastUpdatedBy(124);
        widget.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widget.setName("lion");
        widget.setPreferences("no");
        widget.setServiceUri("yes");
        widget.setType("emp");
        widget.setVersion(BigInteger.ONE);

        Widget widget2 = new Widget();
        widget2.setId(2);
        widget2.setActionUri("no");
        widget2.setIsActive(true);
        widget2.setCreatedBy(124);
        widget2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widget2.setLastUpdatedBy(1234);
        widget2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widget2.setName("tiger");
        widget2.setPreferences("yes");
        widget2.setServiceUri("no");
        widget2.setType("emp");
        widget2.setVersion(BigInteger.ZERO);

        widgetList.add(widget);
        widgetList.add(widget2);
        return widget;
    }

    private AllWidgetDTO getExpectedWidgetDTO(){
        AllWidgetDTO widgetDTO = new AllWidgetDTO();
        widgetDTO.setId(1);
        widgetDTO.setActionUri("yes");
        widgetDTO.setIsActive(true);
        widgetDTO.setCreatedBy(123);
        widgetDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetDTO.setLastUpdatedBy(124);
        widgetDTO.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetDTO.setName("lion");
        widgetDTO.setPreferences("no");
        widgetDTO.setServiceUri("yes");
        widgetDTO.setType("emp");
        widgetDTO.setVersion(BigInteger.ONE);

        AllWidgetDTO widgetDTO2 = new AllWidgetDTO();
        widgetDTO2.setId(2);
        widgetDTO2.setActionUri("no");
        widgetDTO2.setIsActive(true);
        widgetDTO2.setCreatedBy(124);
        widgetDTO2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        widgetDTO2.setLastUpdatedBy(1234);
        widgetDTO2.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        widgetDTO2.setName("tiger");
        widgetDTO2.setPreferences("no");
        widgetDTO2.setServiceUri("yes");
        widgetDTO2.setType("emp");
        widgetDTO2.setVersion(BigInteger.ZERO);

        widgetDTOList.add(widgetDTO);
        widgetDTOList.add(widgetDTO2);
        return widgetDTO;
    }
}
