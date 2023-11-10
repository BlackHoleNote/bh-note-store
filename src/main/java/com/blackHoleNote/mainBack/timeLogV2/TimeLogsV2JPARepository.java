package com.blackHoleNote.mainBack.timeLogV2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeLogsV2JPARepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long id);
}