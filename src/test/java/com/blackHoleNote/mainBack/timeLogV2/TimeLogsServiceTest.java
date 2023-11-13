package com.blackHoleNote.mainBack.timeLogV2;

import com.blackHoleNote.mainBack.authV2.SimpleUserDto;
import com.blackHoleNote.mainBack.shared.Exception.ConflictException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimeLogsServiceTest {

    @InjectMocks
    private TimeLogsService timeLogsService;
    @Mock
    private TimeLogsV2JPARepository timeLogsV2JPARepository;

    @Test
    @DisplayName("서버에 저장된 버전과 save하고자 하는 버전이 같을때 정상 저장이 되고, 서버 버전 + 1을 반환함")
    void test_success_save() {
        // Given
        long userId = 1l;
        long noteId = 3l;
        long serverVersion = 2l;
        Note savedNote = new Note(noteId, userId, "", "", serverVersion);
        when(timeLogsV2JPARepository.findByIdAndUserId(any(), any())).thenReturn(Optional.of(savedNote));
        when(timeLogsV2JPARepository.save(any())).thenAnswer(invocation -> {
            Note note = (Note) Arrays.stream(invocation.getArguments()).findFirst().orElseThrow();
            return note;
        });

        // When
        var saveDTO = timeLogsService.save(new SaveNoteDTO(noteId, "", "", serverVersion), new SimpleUserDto(userId));

        // Then
        assertEquals(saveDTO, new SavedNoteDTO(noteId, serverVersion + 1));
    }

    @Test
    @DisplayName("저장할 버전이 서버의 버전보다 높을 경우, 클라이언트 정보가 최신이라고 판단하여 클라버전 + 1을 저장하고 반환함")
    void test_success_save_client_bigger_server() {
        // Given
        long userId = 1l;
        long noteId = 3l;
        long serverVersion = 2l;
        long clientVersion = 5l;
        Note savedNote = new Note(noteId, userId, "", "", serverVersion);
        when(timeLogsV2JPARepository.findByIdAndUserId(any(), any())).thenReturn(Optional.of(savedNote));
        when(timeLogsV2JPARepository.save(any())).thenAnswer(invocation -> {
            Note note = (Note) Arrays.stream(invocation.getArguments()).findFirst().orElseThrow();
            return note;
        });

        // When
        var saveDTO = timeLogsService.save(new SaveNoteDTO(noteId, "", "", clientVersion), new SimpleUserDto(userId));

        // Then
        assertEquals(saveDTO, new SavedNoteDTO(noteId, clientVersion + 1));
    }

    @Test
    @DisplayName("서버 버전이 클라이언트 버전보다 최신이라면 409 conflict발생")
    void test_fail_save_server_bigger_client() {
        // Given
        long userId = 1l;
        long noteId = 3l;
        long serverVersion = 5l;
        long clientVersion = 2l;
        Note savedNote = new Note(noteId, userId, "", "", serverVersion);
        when(timeLogsV2JPARepository.findByIdAndUserId(any(), any())).thenReturn(Optional.of(savedNote));

        // When, Then
        assertThrows(ConflictException.class, () -> timeLogsService.save(new SaveNoteDTO(noteId, "", "", clientVersion), new SimpleUserDto(userId)));
    }
}