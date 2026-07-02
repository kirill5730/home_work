public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumInRange(12, 5));
        System.out.println(checkSumInRange(3, 4));
        checkNumber(10);
        checkNumber(-3);
        checkNumber(0);
        System.out.println(isNegative(-5));
        System.out.println(isNegative(10));
        System.out.println(isNegative(0));
        print("Привет", 3);
        System.out.println(isLeap(2000));
        System.out.println(isLeap(1900));
        System.out.println(isLeap(2024));
        System.out.println(isLeap(2023));
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1 - arr1[i];
        }
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] arr2 = new int[100];
        int value = 1;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = value;
            value++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.print("... ");
        System.out.print(arr2[98] + " " + arr2[99]);
        System.out.println();
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();
        int n = 5;
        int[][] arr4 = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr4[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        int[] result = createArray(5, 7);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -3;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 17;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void print(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}