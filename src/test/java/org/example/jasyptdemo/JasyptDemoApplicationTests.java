package org.example.jasyptdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JasyptDemoApplicationTests {

    @Value("${spring.test.username}")
    private String username;

    @Value("${spring.test.password}")
    private String password;

    @Test
    void jasyptDecryptTest() {
        // 값이 null이 아니고, ENC()가 아닌 복호화된 값이어야 함
        assertNotNull(username, "Username should not be null");
        assertNotNull(password, "Password should not be null");

        // 실제 값이 ENC(...) 형태로 남아 있으면 안 됨
        assertFalse(username.startsWith("ENC("), "Username should be decrypted");
        assertFalse(password.startsWith("ENC("), "Password should be decrypted");

        System.out.printf("Decrypted Username: %s, Decrypted Password: %s%n", username, password);
    }
}
