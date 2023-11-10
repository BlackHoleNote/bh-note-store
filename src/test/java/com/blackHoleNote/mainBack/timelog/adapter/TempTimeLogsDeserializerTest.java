package com.blackHoleNote.mainBack.timelog.adapter;

import com.blackHoleNote.mainBack.timelog.domain.TempTimeLogs;
import com.blackHoleNote.mainBack.timelog.domain.TimeLogs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempTimeLogsDeserializerTest {
    @Test
    void test() throws Exception {
        String sut = "{\"id\":0,\"previousVersion\":0,\"title\":\"test\",\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"contents\":[{\"id\":1,\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"type\":\"temp\",\"loggedTime\":\"2023-08-25T04:12:54Z\",\"text\":\"hi\"},{\"id\":2,\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"type\":\"temp\",\"loggedTime\":\"2023-08-25T04:12:54Z\",\"text\":\"hi\"},{\"id\":0,\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"type\":\"temp\",\"loggedTime\":\"2023-08-25T04:12:54Z\",\"text\":\"hi\"},{\"id\":10,\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"type\":\"temp\",\"loggedTime\":\"2023-08-25T04:12:54Z\",\"text\":\"hi\"},{\"id\":8,\"lastUpdatedTime\":\"2023-08-25T04:12:54Z\",\"type\":\"temp\",\"loggedTime\":\"2023-08-25T04:12:54Z\",\"text\":\"hi\"}],\"version\":0}";
        ObjectMapper objectMapper = new ObjectMapper();
        TempTimeLogs timeLogs = objectMapper.readValue(sut, TempTimeLogs.class);
        System.out.println(timeLogs);
    }

    @Test
    void serializeTest() throws Exception {
        TimeLogs timeLogs = TimeLogs.empty();
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
        String result = objectMapper.writeValueAsString(timeLogs);
        System.out.println(result);
    }
}