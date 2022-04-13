package baseball.domain.opponent;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerOpponent implements Opponent {

    @Override
    public String getInput() {
        String numberString = "";

        for (int i = 0; i < 3; i++) {
            numberString += getRandomNoDuplicate(numberString);
        }
        return numberString;
    }

    private String getRandomNoDuplicate(String numberString) {
        String number = "";
        do {
            number = String.valueOf(Randoms.pickNumberInRange(1, 9));
        } while (numberString.contains(number));

        return number;
    }
}
