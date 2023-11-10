package com.blackHoleNote.mainBack.timeLogV2;

import com.blackHoleNote.mainBack.authV2.SimpleUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TimeLogsService {
    private final TimeLogsV2JPARepository timeLogsJPARepository;

    public TimeLogsService(TimeLogsV2JPARepository timeLogsJPARepository) {
        this.timeLogsJPARepository = timeLogsJPARepository;
    }

    public CreatedNoteDTO save(CreateNoteDTO noteDto, SimpleUserDto userDto) {
        Note note;

        if (noteDto.id() != null) {
            note = timeLogsJPARepository.save(new Note(userDto.getId(), noteDto.title(), noteDto.contents()));
        } else {
            throw new RuntimeException("id is not null");
        }
        return new CreatedNoteDTO(note.getId(), noteDto.id());
    }

    public CreatedNoteDTO save(SaveNoteDTO noteDTO, SimpleUserDto userDto) {
        Note note = timeLogsJPARepository.save(new Note(noteDTO.id(), userDto.getId(), noteDTO.title(), noteDTO.contents()));
        return new CreatedNoteDTO(note.getId(), null);
    }
    public List<Note> loadAll() {
        return timeLogsJPARepository.findAll();
    }

    public List<Note> loadAllNotesOfUser(SimpleUserDto userDto) {
        return timeLogsJPARepository.findAllByUserId(userDto.getId());
    }
    public Optional<Note> load(Long noteId) {
        return timeLogsJPARepository.findById(noteId);
    }
}
