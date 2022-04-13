package baseball.domain.gamerule;

public class BaseballGameRule implements GameRule
{
    private int strike = 0;
    private int ball = 0;

    @Override
    public String result(String opponent, String user) {
        if (opponent.equals(user)) {
            return "3스트라이크";
        }

        strike = getStrike(opponent, user);
        ball = getBall(opponent, user);

        return judge(strike, ball);
    }

    private int getStrike(String opponent, String user) {
        int count = 0;
        if (opponent.charAt(0) == user.charAt(0))    count++;
        if (opponent.charAt(1) == user.charAt(1))    count++;
        if (opponent.charAt(2) == user.charAt(2))    count++;

        return count;
    }

    private int getBall(String opponent, String user) {
        int count = 0;
        if (opponent.charAt(0) == user.charAt(1) || opponent.charAt(0) == user.charAt(2))    count++;
        if (opponent.charAt(1) == user.charAt(0) || opponent.charAt(1) == user.charAt(2))    count++;
        if (opponent.charAt(2) == user.charAt(0) || opponent.charAt(2) == user.charAt(1))    count++;

        return count;
    }

    private String judge(int strike, int ball) {
        if (strike == 0 && ball == 0)   return "낫싱";
        return strike == 0 ? ball + "볼" : ball + "볼 " + strike + "스트라이크";
   }
}
