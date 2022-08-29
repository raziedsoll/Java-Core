package Task2;

/*
Задание №2.
Отсортируйте массив с учетом дубликатов. Реализовать тесты.
*/

//В данной задаче я реализовал алгоритм QuickSort

import java.util.Arrays;

public class Main {

    static class MySort {
        /**
         * Метод sort используется для сортировки массива целых чисел. В ходе выполнения метода sort,
         * будет вызван метод quickSort, который реализует алгоритм быстрой сортировки.
         * @param array массив для сортировки.
         */
        static void sort(int[] array) {
            assert array != null;
            quickSort(array, 0, array.length - 1);
        }


        /**
         * Перегруженная версия метода sort. Позволяет сортировать определенную
         * часть массива (с fromIndex и до конца массива).В ходе выполнения метода sort,
         * будет вызван метод quickSort, который реализует алгоритм быстрой сортировки.
         * @param array массив для сортировки.
         * @param fromIndex начиная с этого индекса элементы будут участвовать в сортировке.
         */
        static void sort(int[] array, int fromIndex) {
            assert array != null;
            assert fromIndex >= 0;
            quickSort(array, fromIndex, array.length-1);
        }

        /**
         * Перегруженная версия метода sort. Позволяет сортировать определенную часть массива.
         * В ходе выполнения метода sort, будет вызван метод quickSort,
         * который реализует алгоритм быстрой сортировки.
         * @param array массив для сортировки.
         * @param fromIndex начиная с этого индекса элементы будут участвовать в сортировке.
         * @param toIndex конечный индекс элементов, который учасвствуют в сортировке.
         */

        static void sort(int[] array, int fromIndex, int toIndex) {
            assert array != null;
            assert fromIndex >= 0 && toIndex <= array.length - 1;
            quickSort(array, fromIndex, toIndex);
        }




        private static void quickSort(int[] array, int low, int high) {
            //Так как метод quickSort можно вызвать на прямую из метода main, эти assert я решил оставить
            assert array != null;
            assert low >= 0 && high <= array.length - 1;

            if (low >= high || array.length == 0) {
                return;
            }

            //Выбираем опорный элемент
            int supElement = array[low + (high - low) / 2];

            // делим на подмассивы, который больше и меньше опорного элемента
            int i = low;
            int j = high;

            while (i <= j) {
                while (array[i] < supElement) {
                    i++;
                }

                while (array[j] > supElement) {
                    j--;
                }

                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            // Используется рекурсия для сортировки левой и правой части
            if (low < j)
                quickSort(array, low, j);
            if (high > i)
                quickSort(array, i, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        MySort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
