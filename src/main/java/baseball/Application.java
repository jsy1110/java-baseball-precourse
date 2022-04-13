package baseball;

import baseball.view.GameView;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        GameView game = appConfig.gameView();

        while ("1".equals(game.playGame())) {

        }
    }
}
