package baseball;

import baseball.domain.gamerule.BaseballGameRule;
import baseball.domain.gamerule.GameRule;
import baseball.domain.opponent.ComputerOpponent;
import baseball.domain.opponent.Opponent;
import baseball.domain.player.KeyboardPlayer;
import baseball.domain.player.Player;
import baseball.view.GameView;

public class AppConfig {

    public GameView gameView() {
        return new GameView(opponent(), player(), gameRule());
    }

    public GameRule gameRule() {
        return new BaseballGameRule();
    }

    public Opponent opponent() {
        return new ComputerOpponent();
    }

    public Player player() {
        return new KeyboardPlayer();
    }

}
