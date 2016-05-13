package AVLTree;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int quantity;
    public static int[] keys;
    public static String[] values;
    public static void main(String[] args) {

        //Cоздание экземпляра АВЛ-дерева
        AVL<Integer, String> avl = new  AVL<Integer,String>();

        //Ввод значений
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей: ");
        quantity=scanner.nextInt();
        if (quantity<1)
            throw new InputMismatchException("Invalid number of values");
        keys=new int[quantity];
        values=new String[quantity];
        System.out.println("Введите целочисленные ключи и значения построчно:");
        for (int i=0;i<quantity;i++){
            keys[i]=scanner.nextInt();
            values[i]=scanner.next();
        }

        //Вставка записей в дерево:
        for (int i=0;i<quantity;i++){
            avl.add(keys[i],values[i]);
        }
        //Вывод дерева на экран
        avl.print();

        //Вывод записей наимешьшего и наибольшего ключей
        System.out.print("Наибольший ключ и его запись: ");
        System.out.println(avl.maxKey()+" - "+(avl.get(avl.maxKey())));
        System.out.print("Наименьший ключ и его запись: ");
        System.out.println(avl.minKey()+" - "+avl.get(avl.minKey()));

        //Получение записи по ключу:
        System.out.println("\nВведите ключ записи, которую хотите прочитать: ");
        System.out.println(avl.get(scanner.nextInt()));

        //удаление записи по вводимому ключу
        System.out.println("\nВведите ключ записи, которую хотите удалить: ");
        avl.delete(scanner.nextInt());
        avl.print();
    }
}
