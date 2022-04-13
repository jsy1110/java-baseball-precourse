package baseball.view;

import baseball.AppConfig;
import baseball.domain.gamerule.GameRule;
import baseball.domain.opponent.Opponent;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    static final String CONSOLE_TEXT = "숫자를 입력해주세요 : ";
    static final String END_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    static final String RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    static final String END = "3스트라이크";

    private final Opponent opponent;
    private final Player player;
    private final GameRule gameRule;

    public GameView(Opponent opponent, Player player, GameRule gameRule) {
        this.opponent = opponent;
        this.player = player;
        this.gameRule = gameRule;
    }

    public String playGame() throws IllegalArgumentException {
        String opponentNumber = opponent.getInput();
        System.out.println("opponentNumber = " + opponentNumber);
        String result = "";

        do {
            System.out.print(CONSOLE_TEXT);
            result = gameRule.result(opponentNumber, player.getNumber());
            System.out.println(result);
        } while (!result.equals(END));

        System.out.println(END_TEXT);
        return replay();
    }

    private String replay() {
        System.out.println(RE_GAME);
        String result = Console.readLine();
        if (!"1".contains(result) && !"2".contains(result)) {
            throw new IllegalArgumentException("사용자 Command 입력값에 오류가 있습니다.");
        }
        if ("2".contains(result)) {
            System.out.println("게임 종료");
        }
        return result;
    }

}
