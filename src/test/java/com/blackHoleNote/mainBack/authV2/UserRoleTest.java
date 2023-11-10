package com.blackHoleNote.mainBack.authV2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRoleTest {
    // TODO: enum을 string으로 바꿨을때 나오는 문자열을 테스트한다.
    @Test
    void testToString() {
        assertEquals("USER", UserRole.USER.toString());
        assertEquals("ADMIN", UserRole.ADMIN.toString());
        assertEquals("OP", UserRole.OP.toString());
    }
}