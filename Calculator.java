import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Submit math question: ");
        String mathQuestion = input.nextLine();

        String[] questionArray = mathQuestion.split("[/*\\-+]");

        int answer = 0;

        if (mathQuestion.contains("/")) {
            answer = (Integer.parseInt(questionArray[0].trim()) / Integer.parseInt(questionArray[1].trim()));
        } else if (mathQuestion.contains("*")) {
            answer = (Integer.parseInt(questionArray[0].trim()) * Integer.parseInt(questionArray[1].trim()));
        } else if (mathQuestion.contains("-")) {
            answer = (Integer.parseInt(questionArray[0].trim()) - Integer.parseInt(questionArray[1].trim()));
        } else if (mathQuestion.contains("+")) {
            answer = (Integer.parseInt(questionArray[0].trim()) + Integer.parseInt(questionArray[1].trim()));
        } else {
            System.out.println("Operator is invalid or missing.");
        }
        System.out.println("The answer is: " + answer);
    }
}