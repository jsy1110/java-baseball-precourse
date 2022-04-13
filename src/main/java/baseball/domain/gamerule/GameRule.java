package baseball.domain.gamerule;

public interface GameRule {

    /**
     * opponent와 user의 입력값을 비교하여 룰을 적용한다.
     * @param opponent 입력값
     * @param user 입력값
     * @return 적용된 룰의 결과값
     */
    String result(String opponent, String user);

}
