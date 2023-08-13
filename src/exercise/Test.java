package exercise;


import java.util.Scanner;


public class Test {


    public static void main(String[] args) {
        int out = 0;
        RandomNum randomNum1 = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("몇개의 숫자로 게임을 할것인가?");

        int num = Integer.parseInt(scanner.nextLine());

        try {
            randomNum1 = new RandomNum(num);

        } catch (Exception e) {
            System.out.println("10보다 작은 값을 넣으시오.");
            return;
        }

        System.out.println(randomNum1.getAnswerStr());

        String[] answer = randomNum1.getAnswer();
        String answerStr = randomNum1.getAnswerStr();


        while (out != 3) {
            int strike = 0, ball = 0;

            System.out.printf("%d개의 숫자번호를 입력하시오.(1~9)%n", num);
            String response = scanner.nextLine();

            if (response.length() != num) continue;

            String[] responseArr = response.split("");

            for (int i = 0; i < num; i++) {
                if (answer[i].equals(responseArr[i])) {
                    strike++;
                } else if (answerStr.indexOf(responseArr[i]) != -1) {
                    ball++;
                }
            }

            if (strike == 0 && ball == 0) out++;

            System.out.printf("%d스트라이크 %d볼 %d아웃 %n", strike, ball, out);

            if (out == 3) {
                System.out.println("3아웃 끝!");
            }

            if (strike == num) {
                System.out.println("성공!");
                break;
            }
        }


    }
}