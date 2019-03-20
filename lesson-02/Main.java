
// Пользовательские исключения для удобства объединены абстрактным классом -
// это позволяет обобщить характер ошибки, не ссылаясь к конкретному классу и типу ошибки
abstract class MyArrayException extends Exception {
    protected MyArrayException(String message) { super(message); }
}

class MyArraySizeException extends MyArrayException {
    public MyArraySizeException() { super("uncorrect size of array"); }
}

class MyArrayDataException extends MyArrayException {
    public MyArrayDataException(int i, int j, String value) { super("uncorrect value in [" + i + ", " + j + "] " + value); }
}


public class Main {

    public static final int SIZE = 4;

    // Запуск тестов автоматизирован, чтобы не менять входные значения вручную какждый раз
    public static void main(String[] args) throws MyArrayException {
        for (int i = 0; i < SIZE; i++)
            System.out.println("test " + (i+1) + ". " + getResultTest(i));
    }

    // При прогоне тестов обрабатываем ошибку, чтобы не происходило преждевременного выхода из программы
    public static String getResultTest(int i) {
        try {
            String[][] arr = getArray(i);
            int result = arrayReader(arr);
            return "answer: " + result;
        } catch (MyArrayException e) {
            return e.getClass().getName() + ": " + e.getMessage(); // в сообщение выводится все, кроме стек-трейса
        }
    }

    // Различные наборы входных массивов для проверки
    public static String[][] getArray(int i) {
        String[][][] test = {
                new String[4][4], // MyArrayDataException [0]
                new String[4][3], // MyArraySizeException [1]
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}},  // success [2]
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", ""}},    // MyArrayDataException [3]
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15"}},        // MyArraySizeException [4]
        };
        return test[i];
    }

    // Выполняет чтение массива, либо генерирует соответствующие ошибки
    public static int arrayReader(String[][] input) throws MyArrayException {
        if (!checkSize(input))
            throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                try { sum += Integer.parseInt(input[i][j]); }
                catch(NumberFormatException e) { // Природа MyArrayDataException не более, чем неверный формат данных (ошибка приведения типов)
                    throw new MyArrayDataException(i, j, input[i][j]);
                    // в случае ошибки мы его перехватываем и генерируем уже свое исключение, но уточняем: какое значение его вызвало и где оно находится
                }
        return sum;
    }

    // Проверяет корректность размерности массива
    private static boolean checkSize(String[][] input) {
        if (input.length != SIZE)
            return false;
        for (int i = 0; i < SIZE; i++)
            if (input[i].length != SIZE)
                return false;
        return true;
    }
}