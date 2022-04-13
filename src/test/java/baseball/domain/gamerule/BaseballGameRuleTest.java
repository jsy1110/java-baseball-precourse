package baseball.domain.gamerule;

import baseball.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameRuleTest {

    private GameRule baseballGameRule;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        baseballGameRule = appConfig.gameRule();
    }

    @Test
    void 룰_체크_OK() {
        assertThat(baseballGameRule.result("123", "456")).isEqualTo("낫싱");
        assertThat(baseballGameRule.result("456", "456")).isEqualTo("3스트라이크");
        assertThat(baseballGameRule.result("357", "273")).isEqualTo("2볼");
        assertThat(baseballGameRule.result("357", "375")).isEqualTo("2볼 1스트라이크");
        assertThat(baseballGameRule.result("987", "912")).isEqualTo("1스트라이크");
    }

    @Test
    void 룰_체크_FAIL() {
        assertThat(baseballGameRule.result("123", "456")).isNotEqualTo("3스트라이크");
        assertThat(baseballGameRule.result("987", "612")).isNotEqualTo("1스트라이크");
    }
}