package Task1;
/*
Задание №1.
Заполните двумерный массив 10 на 10 случайными числами и выведите
максимальное, минимальное и среднее значение.
 */


public class Main {

    class MyRandom {

        /**
         * Генерирует случайное число в промежутке [0,101)
         * <p>
         * Данная генерация рандомных чисел работает на основе метода java.lang.System.nanoTime().
         * Далее идут различные преоразования, что бы нормализовать распределение чисел.
         *
         * @return результат генерации числа
         */
        private static int getRand() {
            int result = (int) System.nanoTime();
            result = result * 31 % 101;
            return result > 0 ? result : -1 * result;
        }

        /**
         * Генерирует случайное число в промежутке [0, end)
         *
         * @param end конец промежутка (не включая end)
         * @return результат генерации числа
         */
        private static int getRand(int end) {
            int result = (int) System.nanoTime();
            result = (result * 31 % 101) % end;
            return result > 0 ? result : -1 * result;
        }


        /**
         * Генерирует случайное число в промежутке [start, end)
         *
         * @param start начало промежутка
         * @param end   конец промежутка ( не включая end )
         * @return результат генерации числа
         */
        private static int getRand(int start, int end) {
            int result = (int) System.nanoTime();
            result = ((result * 31) % 101) % end;
            result = result > 0 ? result : -1 * result;
            if (result < start) {
                result += start;
            }
            return result;
        }
    }

    class Aggregation {
        /**
         * Преобразование двумерного массива в одномерный
         * @param array двумерный массив
         * @return одномерный массив
         */

        private static int[] toOneDimArr(int[][] array) {
            int lengthNewArr = 0;
            //данный цикл необходим в случае если изначальный массив зубчатый
            for (int[] ints : array) {
                lengthNewArr += ints.length;
            }

            int[] oneDimArr = new int[lengthNewArr];
            int count = 0;

            for (int[] ints : array) {
                for (int anInt : ints) {
                    oneDimArr[count] = anInt;
                    count++;
                }

            }
            return oneDimArr;
        }

        /**
         * Сортировка одномерного массива пузырьком
         * @param array массив для сортировки
         */
        private static void mySort(int[] array) {

            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;

                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        isSorted = false;

                        buf = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buf;
                    }
                }
            }
        }

        /**
         * Минимальный элемент массива
         * @param array массив, в котором будет происходить поиск минимального элемента
         * @return минимальный элемент
         */
        public static int min(int[][] array) {
            int[] oneDimArr = toOneDimArr(array);
            mySort(oneDimArr);
            return oneDimArr[0];
        }

        /**
         * Максимальный элемент массива
         * @param array массив, в котором будет происходить поиск максимального элемента
         * @return максимальный элемент
         */
        public static int max(int[][] array) {
            int[] oneDimArr = toOneDimArr(array);
            mySort(oneDimArr);
            return oneDimArr[oneDimArr.length - 1];
        }

        /**
         * Среднее значение всех элементов массива
         * @param array массив, для элементов которого находиться среднее значение
         * @return среднее значение
         */
        public static double avg(int[][] array) {
            int sum = 0;
            int[] oneDimArr = toOneDimArr(array);
            for (int num : oneDimArr) {
                sum += num;
            }
            return (1.0 * sum) / oneDimArr.length;
        }

    }



    public static void main(String[] args) {

        //Создаем пустой массив
        int[][] array = new int[10][10];

        //Заполняем массив array случайными числами
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = MyRandom.getRand();
            }
        }
        System.out.println(Aggregation.min(array));
        System.out.println(Aggregation.max(array));
        System.out.println(Aggregation.avg(array));
    }
}
