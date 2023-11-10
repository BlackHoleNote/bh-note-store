package com.blackHoleNote.mainBack.note.Note;

import com.blackHoleNote.mainBack.note.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class WriteNoteServiceTest {
//    @InjectMocks
    UpdateNoteService updateNoteService;

    @Test
    @DisplayName("글 작성 커맨드를 날리면 저장에 성공한 이벤트까지의 커서를 돌려준다. 추가로 커서 전까지 노트 생성에 대한 결과가 있다면 tempId에 매칭되는 noteId도 포함되어있어야한다.")
    void test1() {
//        doAnswer((invocation -> {
//            Object arg = invocation.getArgument(0);
//            NoteAction action = (NoteAction) arg;
//            action.setId(1L);
//            return null;
//        })).when(repository).saveAction(any());
//
//        ArrayList<NoteActionDTO> noteActionDTOS = new ArrayList<>();
//        NoteUpdateResult result = updateNoteService.update(noteActionDTOS);
//
//        assertEquals(result.cursor(), 0);
//        assertEquals(result.idMap(), new HashMap<Long, Long>(){{put(0L, 0L);}});
    }
}
//    @Test
//    fun `글 작성을 했을때 반환한 id로 저장한 값에 대한 조회가 가능함`() {
//        val writeNoteId = writeNoteService.write("test")
//        assert(writeNoteService.findById(writeNoteId) == "test")
//    }
//
//    @Test
//    fun `새로운 파일 제목이 들어오면 새로운 글 생성이 가능함`() {
//        val title = "test"
//        val id = writeNoteService.createNote(title)
////        Mockito.verify(repository, times(1)).createNote(any(), any())
//    }
//
//    @Test
//    fun `기존에 생성된 파일 제목으로 새로운 글 생성을 시도하면 잘못된 요청오류를 반환한다`() {
//        val title = "test"
//        Mockito.`when`(repository.getAll())
//                .thenReturn(listOf())
//                .thenReturn(listOf(Note(0, title)))
//
//        assertDoesNotThrow { writeNoteService.createNote(title) }
//        assertThrows<BadRequestException> { writeNoteService.createNote(title) }
//    }
//
//    @Test
//    fun `파일의 확장자가 md가 아닌 경우 md로 변환한다`() {
//        val title = "test.png"
//
//
//        assertDoesNotThrow { writeNoteService.createNote(title) }
//
//        // TODO: - 이런방식으로 mock Test를 하지말고 createNote의 result를 어떤 DataClass로 만들어서 반환하도록 만들면 좋겠음
//        Mockito.verify(repository).save(argThat<Note> {
//                print(it.title)
//        return@argThat true
//        })
//    }
//
//    @Test
//    fun `파일 제목의 확장자가 md인 경우 그대로 생성된다`() {
//        val title = "test.md"
//        val id = writeNoteService.createNote(title)
//    }
//
//    @Test
//    fun `현재 작업한 범위까지 저장을 하는 경우 작업한 범위와 diff 정보가 필요함`() {
////        val noteID =
//    }
//
//    // TODO: - 지금 시간과 다른 시간정보를 가진 데이터가 들어왔을경우
//    @Test
//    // TODO: - 나중에
//    // TODO: - 네트워크가 끊겻다가 다시 붙을때를 대비해서 새로 작업을 해야함
//    fun `여러 인덱스로 함께저장`() {
//
//    }
//}
