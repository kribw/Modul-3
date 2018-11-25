import java.util.Scanner;

public class BeanMachine {
    private static int jump;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Submit amount of balls: ");
        int balls = input.nextInt();
        System.out.print("Submit amount of tracks: ");
        int trackAmount = input.nextInt();

        jump = trackAmount - 1;
        int[] track = new int[trackAmount];

        for (int i = 0; i < balls; i++) {
            int index = getPathForOneBall();
            track[index]++;
            System.out.println();
        }
        System.out.println();
        printResult(track);
    }

    private static int getPathForOneBall() {
        int path = 0;
        for (int i = 0; i < jump; i++) {
            boolean left = (Math.random() < 0.5);
            if (left) {
                System.out.print("L");
            } else {
                System.out.print("R");
                path++;
            }
        }
        return path;
    }

    private static void printResult(int[] slots) {
        for (int i = max(slots); i > 0; i--) {
            for (int j = 0; j < slots.length; j++) {
                if (slots[j] >= i) {
                    System.out.print(" 0\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        for (int index = 0; index < slots.length; index++) {
            System.out.print("|" + index + "|\t");
        }
    }

    private static int max(int[] slots) {
        int maxIndex = 0;
        for (int index = 0; index < slots.length; index++) {
            if (slots[index] > maxIndex) {
                maxIndex = slots[index];
            }
        }
        return maxIndex;
    }
}