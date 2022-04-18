package com.example.pfe.controller;

import com.example.pfe.dto.DeviceDto;
import com.example.pfe.repositories.deviceRepository;
import com.example.pfe.services.DeviceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class DeviceControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper =new ObjectMapper();
    ObjectWriter objectWriter =objectMapper.writer();

    @Mock
    private deviceRepository deviceRepository;
    @Mock
    private DeviceService deviceService;
    @InjectMocks
    DeviceController deviceController;

    DeviceDto device1=new DeviceDto("1","TV","ON","1ere","bedroom");
    DeviceDto device2=new DeviceDto("2","PS5","ON","1ere","bedroom");
    DeviceDto device3=new DeviceDto("3","RADIO","ON","1ere","bedroom");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(deviceController).build();
        List<DeviceDto> clients= new ArrayList<>(Arrays.asList(device1,device2,device3));
    }
    @Test
    void getAll() throws Exception {
        List<DeviceDto> alldevice= new ArrayList<>(Arrays.asList(device1,device2,device3));
        Mockito.when(deviceService.getALL()).thenReturn(alldevice);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/device/")

                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(3)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$" ,hasSize(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].nom",is("RADIO")))

                .andDo(MockMvcResultHandlers.print()).andReturn()
        ;
    }

    @Test
    void create() throws Exception {
//        DeviceDto cltsave =new DeviceDto(63L,"cltsave@gmail.com","065853671741","cltsave",12,"homme",true);

        Mockito.when(deviceService.create(device1)).thenReturn(device1);
        String content =objectWriter.writeValueAsString(device1);
        MockHttpServletRequestBuilder mockReq =MockMvcRequestBuilders.post("/device/")

                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockReq)
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$",notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nom",is("TV")))
                .andDo(MockMvcResultHandlers.print()).andReturn()
        ;
    }

    @Test
    void delete() throws Exception {
        Mockito.when(deviceService.delete(device1.getId())).thenReturn(Boolean.TRUE);
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/device/1")

                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())

                .andExpect(MockMvcResultMatchers.jsonPath("$",is(Boolean.TRUE)))
                .andDo(MockMvcResultHandlers.print()).andReturn()
        ;
    }

    @Test
    void update() throws Exception {
//        DeviceDto updated =new DeviceDto(1L,"cltsave@gmail.com","065853671741","cltsave",12,"homme",true);
        DeviceDto updated=new DeviceDto("1","TVupdated","ON","1ere","bedroom");
        Mockito.when(deviceService.update(updated,updated.getId())).thenReturn(updated);
        String content =objectWriter.writeValueAsString(updated);
        MockHttpServletRequestBuilder mockReq =MockMvcRequestBuilders.put("/device/1")

                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockReq)
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$",notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nom",is("TVupdated")))
                .andDo(MockMvcResultHandlers.print()).andReturn()
        ;

    }


    @Test
    void getById() throws Exception {
        Mockito.when(deviceService.getById(device1.getId())).thenReturn(device1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/device/1")

                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nom",is("TV")))
                .andDo(MockMvcResultHandlers.print()).andReturn()
        ;
    }
}