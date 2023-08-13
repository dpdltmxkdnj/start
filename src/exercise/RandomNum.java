package exercise;

import java.util.Random;

public class RandomNum {
    private String[] randomNum;
    private String[] answer;
    private String answerStr;

    RandomNum(int num) throws Exception {

        if (num > 8) throw new Exception();

        randomNum = new String[10];
        answer = new String[num];
        answerStr = "";

        for (int i = 1; i < 10; i++) {
            randomNum[i - 1] = String.valueOf(i);
        }

        for (int i = 0; i < 9; i++) {
            int random = new Random().nextInt(9);
            String temp = randomNum[i];
            randomNum[i] = randomNum[random];
            randomNum[random] = temp;
        }

        for (int i = 0; i < num; i++) {

            answerStr += randomNum[i];
            answer[i] = randomNum[i];
        }
    }

    String[] getAnswer() {
        return answer;
    }

    String getAnswerStr() {
        return answerStr;
    }


}
