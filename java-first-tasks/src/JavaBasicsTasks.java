import java.util.Arrays;
import java.util.Scanner;

public class JavaBasicsTasks {
    private static final double METER_PER_INCH = 0.00254;

    private static String convertInchesToMeters(int inputVal) {
        return (double) inputVal + "inch is " + (inputVal * METER_PER_INCH) + " meters.";
    }

    private static String compareTwoNumbers(int firstNumb, int secondNumb) {
        int[] arr = {firstNumb, secondNumb};
        for (int i = 0, y = arr.length - 1; i < arr.length; i++, y--) {
            if (arr[i] > arr[y]) return String.valueOf("><".charAt(i));
        }
        return "=";
    }

    private static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private static void findSquareCubeAndFourthPower(int inputNumber) {
        // Simple solution:
       /* for (int it : new int[] { 2, 3, 4 }) {
            System.out.println(inputNumber+"^"+it+" is "+ (int) Math.pow(inputNumber, it));
        }*/
        for (int len : new int[]{2, 3, 4}) {
            int sum = 1;
            int[] arr = new int[len];
            Arrays.fill(arr, inputNumber);
            for (int n : arr) {
                sum *= n;
            }
            System.out.println(inputNumber + "^" + len + " is " + sum);
        }
    }

    private static String determineStudentGrade(int score) {
        if (score < 60 || score > 100) return "Score is out of scope";
        int[] rates = {70, 80, 90, 100};
        for (int i = 0; i < rates.length; i++) {
            if (score <= rates[i]) return String.valueOf("DCBA".charAt(i));
        }
        return "Can't find grade";
    }

    private static int getIntegerFromInputConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input integer");
        while (true) {
            String text = scanner.nextLine().trim();
            if (text.matches("[0-9]+")) return Integer.parseInt(text);
            System.out.println("Wrong input. Please try again");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Project");
        while (true) {
            System.out.println("Select one of option:");
            System.out.println("a - convert meters to inch, b - compare two numbers, c - find square cube and fourth power");
            System.out.println("d - find the sum of numbers, e - determine student's grade, f - exit");
            String inputTxt = sc.nextLine().trim();
            int inputInt = 0;
            switch (inputTxt.toLowerCase()) {
                case "a":
                    inputInt = getIntegerFromInputConsole();
                    System.out.println(convertInchesToMeters(inputInt));
                    break;
                case "b":
                    System.out.println("Input first number");
                    inputInt = getIntegerFromInputConsole();
                    System.out.println("Input second number");
                    int secondNumber = getIntegerFromInputConsole();
                    System.out.println(compareTwoNumbers(inputInt, secondNumber));
                    break;
                case "c":
                    inputInt = getIntegerFromInputConsole();
                    findSquareCubeAndFourthPower(inputInt);
                    break;
                case "d":
                    String text = "";
                    System.out.println("Input only numbers or not number to exit from input mode");
                    while (true) {
                        System.out.println("Input desired number");
                        inputTxt = sc.nextLine().trim();
                        if (!inputTxt.matches("[0-9]+")) break;
                        text += text.isEmpty() ? inputTxt : " " + inputTxt;
                    }
                    if (!text.isEmpty()) {
                        String[] inputArr = text.split(" ");
                        int[] numbers = new int[inputArr.length];
                        for (int i = 0; i < inputArr.length; i++) {
                            numbers[i] = Integer.parseInt(inputArr[i]);
                        }
                        System.out.println(findSumOfDigits(numbers));
                    } else {
                        System.out.println("No number has input");
                    }
                    break;
                case "e":
                    System.out.println("Input score");
                    inputInt = getIntegerFromInputConsole();
                    System.out.println(determineStudentGrade(inputInt));
                    break;
                case "f":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Wrong command. Please try again");
            }
        }
    }
}