package com.blackHoleNote.mainBack.timeLogV2;

import com.blackHoleNote.mainBack.authV2.SimpleUserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimeLogsV2Controller {
    private final TimeLogsService timeLogsService;

    @PostMapping("/v2/note/save")
    public CreatedNoteDTO save(@RequestBody String body, @AuthenticationPrincipal SimpleUserDto userDto) {
        if (body == null) {
            throw new RuntimeException("body is null");
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SaveNoteDTO noteDto = objectMapper.readValue(body, SaveNoteDTO.class);
            CreatedNoteDTO createdNote = timeLogsService.save(noteDto, userDto);
            return createdNote;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("body is null");
    }

    @PostMapping("/v2/note/create")
    public CreatedNoteDTO create(@RequestBody String body, @AuthenticationPrincipal SimpleUserDto userDto) {
        if (body == null) {
            System.out.printf("body is null");
            throw new RuntimeException("body is null");
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CreateNoteDTO noteDto = objectMapper.readValue(body, CreateNoteDTO.class);
            CreatedNoteDTO createdNote = timeLogsService.save(noteDto, userDto);
            System.out.printf("%s will be %s", noteDto, createdNote);
            return createdNote;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.printf("note: %s, body: %s Enter", body);
        System.out.printf("test ============= =============\n");
        throw new RuntimeException("body is null");
    }

    @GetMapping("/v2/note/{noteId}")
    public String get(@PathVariable Long noteId) {
        System.out.printf("note: %s Enter", noteId);
        System.out.printf("test ============= =============\n");

        return "hello world";
    }

    @GetMapping("/v2/notes")
    public List<Note> getAll(@AuthenticationPrincipal SimpleUserDto userDto) {
        System.out.printf("user: %s", userDto);
        return timeLogsService.loadAllNotesOfUser(userDto);
    }
}
