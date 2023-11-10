package com.blackHoleNote.mainBack.timelog.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TimeLogsControllerTest {

    @Autowired
    MockMvc mvc;
//@Test
//    void Hell() throws Exception {
//mvc.perform(post("/note/create").content("{\"id\":0,\"previousVersion\":0,\"title\":\"\",\"lastUpdatedTime\":1692950803377.0129,\"contents\":[{\"id\":0,\"lastUpdatedTime\":1692950803377.012,\"type\":\"temp\",\"text\":\"\"}],\"version\":0}").accept("application/json"))
//                .andExpect(jsonPath("$.title").value("Hello"))
//                .andExpect(jsonPath("$.lastUpdatedTime").value("1692950803377.0129"))
//        ;
//    }
}