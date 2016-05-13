package PerformanceTests;

import java.util.Arrays;
import java.util.Random;

public class Caller {
    public static void main(String[] args) {
        int[] Ar;
        Random random = new Random();
        long startTime, time;


        System.out.println("Array of 10 elements: ");
        Ar = new int[10];
        for (int i=0;i<Ar.length;i++)
            Ar[i]=random.nextInt(1000)-500;
        System.out.print("Worst case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Normal scenario: ");
        ArrayWorks.invert(Ar);
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Best case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);


        System.out.println("\nArray of 100 elements: ");
        Ar = new int[100];
        for (int i=0;i<Ar.length;i++)
            Ar[i]=random.nextInt(1000)-500;
        System.out.print("Worst case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Normal scenario: ");
        ArrayWorks.invert(Ar);
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Best case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);


        System.out.println("\nArray of 1000 elements: ");
        Ar = new int[1000];
        for (int i=0;i<Ar.length;i++)
            Ar[i]=random.nextInt(1000)-500;
        System.out.print("Worst case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Normal scenario: ");
        ArrayWorks.invert(Ar);
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);

        System.out.print("Best case scenario: ");
        startTime=System.nanoTime();
        ArrayWorks.quickSort(Ar,0,Ar.length-1);
        time=System.nanoTime()-startTime;
        System.out.println(time);
    }
}

