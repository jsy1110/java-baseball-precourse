package baseball.domain.player;


import baseball.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class KeyboardPlayerTest {

    private Player player;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        player = appConfig.player();
    }

    @Test
    void 값체크_OK() {
        userInputTest("369");

        assertThat(player.getNumber()).isEqualTo("369");
    }

    @Test
    void validation_자리수_FAIL() throws Exception {
        userInputTest("3695");

        assertThrows(IllegalArgumentException.class, () -> {
            player.getNumber();
        });
    }

    @Test
    void validation_음수_FAIL() throws Exception {
        userInputTest("-15");

        assertThrows(IllegalArgumentException.class, () -> {
            player.getNumber();
        });
    }

    @Test
    void validation_문자입력_FAIL() throws Exception {
        userInputTest("ABC");

        assertThrows(IllegalArgumentException.class, () -> {
            player.getNumber();
        });
    }

    private void userInputTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
    }

}