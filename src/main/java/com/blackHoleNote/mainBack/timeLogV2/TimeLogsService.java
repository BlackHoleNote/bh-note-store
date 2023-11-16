package com.blackHoleNote.mainBack.timeLogV2;

import com.blackHoleNote.mainBack.authV2.SimpleUserDto;
import com.blackHoleNote.mainBack.shared.Exception.ConflictException;
import com.blackHoleNote.mainBack.shared.Exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeLogsService {
    private final TimeLogsV2JPARepository timeLogsJPARepository;

    public TimeLogsService(TimeLogsV2JPARepository timeLogsJPARepository) {
        this.timeLogsJPARepository = timeLogsJPARepository;
    }

    public CreatedNoteDTO create(CreateNoteDTO noteDto, SimpleUserDto userDto) {
        Note note;

        if (noteDto.id() != null) {
            note = timeLogsJPARepository.save(new Note(userDto.getId(), noteDto.title(), noteDto.contents()));
        } else {
            throw new RuntimeException("id is not null");
        }
        return new CreatedNoteDTO(note.getId(), noteDto.id());
    }

    public SavedNoteDTO save(SaveNoteDTO noteDTO, SimpleUserDto userDto) {
        Note headNote = timeLogsJPARepository.findByIdAndUserId(noteDTO.id(), userDto.getId()).orElseThrow(NotFoundException::new);
        if (noteDTO.version() < headNote.getVersion()) {
            StringBuilder sb = new StringBuilder();
            sb.append("version must be sync : ");
            sb.append(headNote.getVersion());
            throw new ConflictException(sb.toString());
        }
        long newVersion = noteDTO.version() + 1l;
        Note note = timeLogsJPARepository.save(new Note(noteDTO.id(), userDto.getId(), noteDTO.title(), noteDTO.contents(), newVersion));
        return new SavedNoteDTO(note.getId(), newVersion);
    }
    public List<Note> loadAll() {
        return timeLogsJPARepository.findAll();
    }

    public List<Note> loadAllNotesOfUser(SimpleUserDto userDto) {
        return timeLogsJPARepository.findAllByUserId(userDto.getId());
    }
    public Note load(Long noteId, SimpleUserDto userDto) {
        return timeLogsJPARepository.findByIdAndUserId(noteId, userDto.getId()).orElseThrow(NotFoundException::new);
    }
}
