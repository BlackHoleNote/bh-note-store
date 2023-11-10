package com.blackHoleNote.mainBack.authV2;

import com.blackHoleNote.mainBack.timeLogV2.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Long> {
    Optional<User> findByOauthId(String oauthId);
}