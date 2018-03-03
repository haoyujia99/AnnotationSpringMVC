package com.hao.controller.springmvc;

import com.google.gson.Gson;
import com.hao.BaseTestSupport;
import com.hao.enums.GenderEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * com.hao.controller.springmvc
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 16:11
 */
public class UserMVCControllerTest extends BaseTestSupport {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockmvc;

    @Before
    public void setup() {
        this.mockmvc = webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @Transactional
    public void save() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("name", "a");
        map.put("age", "12");
        map.put("gender", GenderEnum.MALE.getValue());
        map.put("birthday", "2018-06-02");

        Gson gson = new Gson();
        MockHttpServletRequestBuilder mockMvcBuilder = post("/mvc/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(map));
        mockmvc.perform(mockMvcBuilder).andExpect(status().isOk()).andDo(print());
    }

    @Test
    @Transactional
    public void deleteById() throws Exception {

        MockHttpServletRequestBuilder mockMvcBuilder = delete("/mvc/delete/1");
        mockmvc.perform(mockMvcBuilder).andExpect(status().isOk()).andDo(print());
    }

    @Test
    @Transactional
    public void update() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "a");
        map.put("age", "12");
        map.put("gender", GenderEnum.MALE.getValue());
        map.put("birthday", "2018-06-02");

        Gson gson = new Gson();
        MockHttpServletRequestBuilder mockMvcBuilder = put("/mvc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(map));
        mockmvc.perform(mockMvcBuilder).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void findById() throws Exception {

        MockHttpServletRequestBuilder mockMvcBuilder = get("/mvc/find/1");
        mockmvc.perform(mockMvcBuilder).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void findAll() throws Exception {

        MockHttpServletRequestBuilder mockMvcBuilder = get("/mvc/find");
        mockmvc.perform(mockMvcBuilder).andExpect(status().isOk()).andDo(print());
    }
}