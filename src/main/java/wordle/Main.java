package wordle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 동작하는 코드 만들기
        // user input
        GameMachine gameMachine = new GameMachine();

        String question = gameMachine.findQuestion();

        System.out.println(question);


//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            String inputData = br.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // 사용자로부터 입력 받는부분
        // 입력을 검증하는부분

        // 입력과 정답을 비교하는 부분
        // 결과 출력

        // 사용자로부터 입력 받기
        // String str = getUserInput();
        question = "asdfg";
        String answer = "azxgv";  // 사용자의 입력 값

        List<Result> results = GameMachine.compare(question, answer);
    }

}
