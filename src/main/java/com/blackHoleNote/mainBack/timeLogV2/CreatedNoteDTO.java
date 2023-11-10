package com.blackHoleNote.mainBack.timeLogV2;

import lombok.Getter;

@Getter

public class CreatedNoteDTO {
    Long id;
    String tempId;

    public CreatedNoteDTO(Long id, String tempId) {
        this.id = id;
        this.tempId = tempId;
    }
}
