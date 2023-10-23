package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static String answerStr;
    private static List<Integer> numberList;


    /**
     * 유저로부터 문자열을 입력받는다.
     */
    public static boolean inputAnswerStr() {
        System.out.print("숫자를 입력해주세요 : ");
        answerStr = Console.readLine();

        if(isUserInputValidate()){
            changeStrToNumList();
            return true;
        }
        return false;
    }

    /**
     * 문자열에 들어있는 숫자를 뽑아 숫자 리스트 형태로 변환하여 numberList에 저장한다.
     *
     */
    private static void changeStrToNumList() {
        numberList = new ArrayList<>();
        // 유저의 입력을 숫자 리스트로 변환
        for (int i = 0; i < answerStr.length(); i++) {
            numberList.add(answerStr.charAt(i) - '0');
        }
    }

    /**
     * 유저가 입력한 문자열이 올바르면 true return
     *
     * @return 유저가 입력한 문자열이 올바르면 true 아니면 false
     */
    private static boolean isUserInputValidate() {
        return (isUserInputAllNumbers() && answerStr.length() == Application.numberCount);
    }

    /**
     * 유저가 입력한 문장열이 모두 숫자로 이루어졌으면 true return
     *
     * @return 유저가 입력한 문자열이 모두 숫자이면 true 아니면 false
     */
    private static boolean isUserInputAllNumbers(){
        for (int i = 0; i < answerStr.length(); i++) {
            if (!Character.isDigit(answerStr.charAt(i))) return false;
        }
        return true;
    }

    public static String getAnswerStr(){
        return answerStr;
    }

    public static List<Integer> getNumberList() {
        return numberList;
    }
}
