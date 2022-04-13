package baseball.domain.opponent;

import baseball.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class ComputerOpponentTest {

    private Opponent opponent;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        opponent = appConfig.opponent();
    }

    @Test
    void 컴퓨터_입력값_범위체크_OK() {
        Assertions.assertThat(opponent.getInput()).isStrictlyBetween("111","999");
    }

    @Test
    void 컴퓨터_입력값_중복체크_OK() {
        char[] chars = opponent.getInput().toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        Assertions.assertThat(opponent.getInput().length()).isEqualTo(set.size());
    }


}