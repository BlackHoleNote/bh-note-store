package com.blackHoleNote.mainBack.timelog.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//class UpdateTimeLogServiceTest {
//    @InjectMocks
//    private UpdateTimeLogService updateTimeLogService;
//    @Mock
//    private TimeLogsRepository timeLogsRepository;
//
//    public UpdateTimeLogServiceTest(UpdateTimeLogService updateTimeLogService) {
////        this.updateTimeLogService = updateTimeLogService;
////    }
//
//    @BeforeEach
//    void setUp() {
////        updateTimeLogService = new UpdateTimeLogService(timeLogsRepository);
//    }
//
//    @AfterEach
//    void tearDown() {
////        updateTimeLogService = null;
//    }
//
//    // TODO: TempTimeLog의 previousVersion이 TimeLogs의 version과 같으면 TempTimeLogs의 contents를 이용해서 새로운 TimeLogs를 만들어야한다
//    @Test
//    void test_TempTimeLogRebaseTest() {
//        // given
//        LinkedHashMap<Long, TimeLog> newContents = new LinkedHashMap<>();
//        TimeLogs timeLogs = new TimeLogs(1L, 0L, 1L, "beforetitle", LocalDateTime.now(), null);
//        TempTimeLogs tempTimeLog = new TempTimeLogs(0L, 1L, 1L, "newtitle", LocalDateTime.now(), newContents);
//        when(timeLogsRepository.findById(0L)).thenReturn(Optional.of(timeLogs));
//        when(timeLogsRepository.save(timeLogs)).thenReturn(new TimeLogs(1L, 1L, 2L, "newtitle", LocalDateTime.now(), newContents));
//
//        // when
//        TimeLogs newTimeLog = updateTimeLogService.rebaseBy(tempTimeLog);
//
//        // then
//        assertEquals(newTimeLog.getContents(), newContents);
//        assertEquals(newTimeLog.getVersion(), 2L);
//    }
//}