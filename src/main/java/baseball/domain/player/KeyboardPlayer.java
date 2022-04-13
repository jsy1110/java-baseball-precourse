package baseball.domain.player;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardPlayer implements Player {

    @Override
    public String getNumber() throws IllegalArgumentException {
        String input = Console.readLine();

        validate(input);

        return input;
    }

    private void validate(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다.");
        }

        if (number < 111 || number > 999) throw new IllegalArgumentException("입력한 예측값의 범위에 오류가 있습니다.");
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) ||
                input.charAt(1) == input.charAt(0) || input.charAt(1) == input.charAt(2) ||
                input.charAt(2) == input.charAt(0) || input.charAt(2) == input.charAt(1) )  throw new IllegalArgumentException("입력한 예측값에 중복이 있습니다.");
    }
}
