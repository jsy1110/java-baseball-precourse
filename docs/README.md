# 숫자 야구 게임
## 개발 환경
- IDE: IntelliJ IDEA (Community Edition)
- OS: Window 10 Education
- Language : JAVA8
- Build : Gradle
- Test : Junit5

## 기능 요구 사항
1. 유효한 입력값은 1에서 9까지 서로 다른 수로 이루어진 3자리수이다. 이외의 입력값은 나올 수 없다.
2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
3. 해당 프로그램에서는 상대방의 역할은 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의수 3자리를 선택한다.
4. 플레이어는 입력값을 이용해 2의 규칙으로 힌트를 얻고, 컴퓨터가 선택한 3자리 숫자를 정확히 맞추는 것을 목표로 한다.
5. 플레이어가 숫자를 정확히 맞추면 게임이 종료된다. 게임 종료 후에는 다시 시작하거나 완전히 종료할 수 있다.
6. 플레이어가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 애플리케이션은 종료된다.

## MVC 모델링
1. View, Controller 역할은 GameView 에서 한다.
2. 도메인 역할은 `Player, Opponent, GameRule` 3가지로 나눈다.
- 각각의 도메인은 Interface로 만들어 확장에 열려있다. (OCP)
- AppConfig를 통해 객체간 의존성을 주입한다. (DI)


## 구현 기능
### Main
- AppConfig를 통해 객체를 생성하고 의존성을 주입한다. (Singleton 패턴)
- `GameView.gameplay()` 를 통해 게임을 시작하고, 게임 종료 후 다시 시작하거나 완전히 종료한다.

### View
- 생성자를 통해 객체 생성 시점에 필요한 객체를 주입 받는다. (Player, Opponent, GameRule)
- `playGame()` : 전체 게임의 흐름을 제어한다.
- `replay()` : 재경기 여부를 결정한다.
- 게임 흐름 : Opponent 값 생성 -> (Player 값 입력 -> 결과 확인) 반복 -> 재경기 or 프로그램 종료

### Config
- AppConfig 클래스를 통해 각 객체 별 의존성 주입 관계를 정의한다.

### 도메인
1. Opponent (Interface) -> ComputerOpponent
- `getInput()` : 상대편의 숫자를 받아온다.
- 해당 프로그램의 대전상대는 컴퓨터이며, `pickNumberInRange()` 메서드를 활용하여 3자리 값을 받아온다.
> 만약 대전 상대를 사람으로 변경하더라도 Opponent 인터페이스를 상속 받는 UserOpponent 클래스를 새롭게 정의하고,
> AppConfig에서 주입 클래스만 수정하여 변경할 수 있다. (View 수정X)
2. Player (Interface) -> KeyboardPlayer
- `getNumber()` : 플레이어의 숫자를 받아온다.
- `validate(String input)` : 플레이어의 입력값을 검증한다. 입력값에 오류가 있는 경우 IllegalArgumentException 발생 후 종료된다.
- 해당 프로그램에서는 `readLine()` 메서드를 이용하여 플레이어의 숫자를 키보드를 통해 입력 받는다.
> 만약 플레이어 입력 방식을 Mouse click 등으로 변경하더라도 Player 인터페이스를 상속 받는 MousePlayer 클래스를 새롭게 정의하고,
> AppConfig에서 주입 클래스만 수정하여 변경할 수 있다. (View 수정X)
3. GmaeRule (Interface) -> BaseballGameRule
- `String result(String opponent, String user)` : Player와 Opponent의 숫자를 비교하는 룰이 적용된 judge 메서드를 이용하여 결과를 리턴한다.
- `getStrike(String opponent, String user)` : Player와 Opponent의 숫자를 비교하여 스트라이크 개수를 카운트 한다.
- `getBall(String opponent, String user)` : Player와 Opponent의 숫자를 비교하여 볼 개수를 카운트 한다.
- `String judge(int strike, int ball)` : 위에서 계산한 스트라이크와 볼 개수를 이용하여 판정 결과를 만든다.
> 만약 Baseball 룰이 아닌 다른 Soccer 룰로 변경하더라도 GameRule을 상속 받는 SoccerGameRule 클래스를 새롭게 정의하고,
> AppConfig에서 주입 클래스만 수정하여 변경할 수 있다. (View 수정X)

## Test
1. 과제 최소 통과 조건인 ApplicationTest 의 `게임종료_후_재시작()`, `예외_테스트()` 는 기본으로 통과해야한다.
2. 

