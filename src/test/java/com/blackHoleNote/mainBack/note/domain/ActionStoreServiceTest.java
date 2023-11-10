package com.blackHoleNote.mainBack.note.domain;

import com.blackHoleNote.mainBack.note.domain.actions.CreateNoteActionDTO;
import com.blackHoleNote.mainBack.note.domain.actions.CreateNoteActionResult;
import com.blackHoleNote.mainBack.note.domain.actions.NoteActionDTO;
import com.blackHoleNote.mainBack.note.domain.actions.NoteActionResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ActionStoreServiceTest {
//    @Mock
    @Autowired
    ActionStoreService actionStoreService;

    // A클라에서 추가하는 내용이 반영되고
    // 그 사이에 B클라에서 작업을 한 내용이 서버로 도착함
    // ssss -> aaaa -> bbbb 그런데 bbbb는 ssss로 작업을 한 diff고, aaaa는 ssss로 작업을 한 diff임 update -> add로 변경됨, line은 하나씩 땡겨짐
//    @Test
//    @DisplayName("이미 생성된 노트가 있고, A클라에서 해당 노트에 대해서 작업을 진행한 후 서버에 저장을 한 이후, B클라에서는 아직 반영되지 않은 내용으로 작업을 했을때 A클라의 작업 사항으로 rebase해서 반환해야한다.")
//    void storeActions() {
        // given
//        doAnswer((invocation -> {
//            Object arg = invocation.getArgument(0);
//            CreateNoteAction action = (CreateNoteAction) arg;
//            return null;
//        })).when(repository).saveAction(any());

//        // when
//        ArrayList<NoteActionDTO> noteActionDTOs = new ArrayList<>();
//        noteActionDTOs.add(new CreateNoteActionDTO(0L, 0L, 0L, "Hello world!"));
//        Long resultQuery = actionStoreService.storeActions(noteActionDTOs, 0L);
//
//        // then
//        assertThat(resultQuery).isEqualTo(1L);
//    }

    // 생성에 대한 결과를 어떻게 반환해주는거냐?
    // ID랑 매칭시켜서?
    // Create결과 - tempId - realId
    // update결과 - realId - cursor
    // delete결과 - realId
//    @Test
//    @DisplayName("CreateNoteActionDTO를 인풋으로 받으면 생성된 노트 ID에 대한 결과를 쿼리 Result로 반환받아야한다")
//    void test1() {
//        // given
//        CreateNoteActionDTO createNoteActionDTO = new CreateNoteActionDTO(0L, 0L, 0L, "Hello world!");
//
//        // when
//        NoteActionResult resultDTO = actionStoreService.storeActions(new ArrayList<>() {{
//            add(createNoteActionDTO);
//        }}, 0L);
//
//        // then
//        assertThat(resultDTO.getCreateNoteActionResults()).isEqualTo(new ArrayList<>() {{
//            add(new CreateNoteActionResult(1L, 0L));
//        }});
//    }
}