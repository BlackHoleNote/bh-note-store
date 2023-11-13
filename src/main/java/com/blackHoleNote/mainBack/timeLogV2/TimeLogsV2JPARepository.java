package com.blackHoleNote.mainBack.timeLogV2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimeLogsV2JPARepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long id);
    Optional<Note> findByIdAndUserId(Long id, Long userId);
}