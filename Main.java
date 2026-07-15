class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {

    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr == null || arr.length != 4) {
            throw new MyArraySizeException("Неверный размер массива: ожидается 4 строки, получено " + (arr == null ? "null" : arr.length));
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new MyArraySizeException("Неверный размер строки " + i + ": ожидается 4 столбца, получено " + (arr[i] == null ? "null" : arr[i].length));
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String cell = arr[i][j];
                try {
                    sum += Integer.parseInt(cell);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: значение \"" + cell + "\" не является числом");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] goodArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] badDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "oops", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            int result = sumArray(goodArray);
            System.out.println("Сумма (хороший массив): " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = sumArray(badDataArray);
            System.out.println("Сумма (массив с ошибкой данных): " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = sumArray(wrongSizeArray);
            System.out.println("Сумма (неверный размер): " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        System.out.println("\n--- Проверка ArrayIndexOutOfBoundsException ---");
        int[] numbers = {10, 20, 30};
        try {
            int value = numbers[5];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}