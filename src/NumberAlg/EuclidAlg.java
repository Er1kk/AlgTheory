package NumberAlg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EuclidAlg {
    public static int a,b;

    public static void main(String[] args) {
        System.out.println("Введите два натуральных числа:");
        Scanner scanner = new Scanner(System.in);
        //Ввод чисел
        a=scanner.nextInt();
        b=scanner.nextInt();
        //Проверка корректности ввода
        if ((b<=0)||(a<=0)){
            System.out.println("Некорректные числа");
            throw new InputMismatchException();
        }
        //Большее число ставится вперед
        if (b>a){
            int tmp=a;
            a=b;
            b=tmp;
        }
        int result = calculate(a,b);
        System.out.println("НОД: "+result);

        if (result!=1){
            System.out.println("Числа - не взаимно простые");
            System.out.println("Число "+a+" - не простое");
            if (isPrime(b)==true)
                System.out.println("Число "+b+" - простое");
            else
                System.out.println("Число "+b+" - не простое");

        } else {
            System.out.println("Числа - взаимно простые");
            if (isPrime(a)==true)
                System.out.println("Число "+a+" - простое");
            else
                System.out.println("Число "+a+" - не простое");
            if (isPrime(b)==true)
                System.out.println("Число "+b+" - простое");
            else
                System.out.println("Число "+b+" - не простое");
        }

    }

    //рекурсивная рализация алгоритма Эвклида
    public static int calculate(int a, int b){
        //условие выхода из рекурсии
        if(b==0){
            return a;
        }
        //а приссваивается значение остатка от деления его на b, после чего происходит рекурсивный вызов
        a=a%b;
        return calculate(b,a);
    }

    //определяет, является ли число простым
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }
}
