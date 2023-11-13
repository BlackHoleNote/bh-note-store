package com.blackHoleNote.mainBack.note.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
class NoteControllerTest {
    @Autowired
    MockMvc mockMvc;
//    @Test
//    void get(String s) {
//    }

//    @Test
//    void post() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/v1/notePost")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"title2\": \"제목?\"}"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(jsonPath("$.title").value("Hello"))
//                .andExpect(content().string("Hello World!"))
//                .andDo(print());
//    }

    // A클라에서 추가하는 내용이 반영되고
    // 그 사이에 B클라에서 작업을 한 내용이 서버로 도착함
    // ssss -> aaaa -> bbbb 그런데 bbbb는 ssss로 작업을 한 diff고, aaaa는 ssss로 작업을 한 diff임 ㅕㅔㅇㅁ
//    @Test
//    @DisplayName("다형성을 가지는 List<NoteActionDTO>를 잘 deserialize하는지 테스트")
//    void post2() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/v1/noteActionUpdate")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("[{\"actionType\": \"createNoteAction\", \"userId\": 1, \"tempNoteId\": 0, \"notes\": \"제목?\"}, {\"actionType\": \"updateNoteAction\", \"noteId\": 0, \"contents\": \"제목?\", \"line\": 0}]"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(jsonPath("$[0]").value(new CreateNoteActionDTO(0L, 0L, 1L, "제목?")))
//                .andDo(print());
//    }

//    @Test
//    @DisplayName("자바 controller post 테스트")
//    void post3() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/v1/noteActionUpdateTest")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("[\"제목?\"]"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(print());
//    }
}