package PerformanceTests;

public class ArrayWorks {

    public static void invert(int array[]){
        for (int i=0;i<array.length/2;i++)
        {
            int tmp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=tmp;
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        //условие выхода из рекурсии
        if (start >= end)
            return;
        int i = start, j = end;
        //разделение массива на две половины
        int current = i - (i - j) / 2;
        //циклическое сравнение элементов из двух половин массива
        while (i < j) {
            while (i < current && (array[i] <= array[current])) {
                i++;
            }
            while (j > current && (array[current] <= array[j])) {
                j--;
            }
            //перестановка
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                //установка нового разделителя
                if (i == current)
                    current = j;
                else if (j == current)
                    current = i;
            }
        }
        //рекурсия
        quickSort(array, start, current);
        //обратная рекурсия
        quickSort(array, current+1, end);
    }
}
