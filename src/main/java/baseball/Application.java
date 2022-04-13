package baseball;

import baseball.view.GameView;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        GameView game = appConfig.gameView();

        while (true) {
            if ("2".equals(game.playGame())) break;
        }
    }
}
