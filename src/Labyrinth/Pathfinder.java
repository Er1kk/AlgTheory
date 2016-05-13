package Labyrinth;

/**
 * Created by adm on 05.05.2016.
 */
public class Pathfinder {
    public static boolean moved=true;
    public static void main(String[] args) {
        //создание нового лабиринта с помошью фабрики
        AbstractLabyrinthFactory myLabyrinthFactory = new MyLabyrinthFactory();
        Labyrinth labyrinth = myLabyrinthFactory.build();

        System.out.println("Trying to build path between "+labyrinth.getStartPoint()+" and "+labyrinth.getFinishPoint());

        //Итеративный вызов метода move
        while (labyrinth.getCurrentPoint()!=labyrinth.getFinishPoint()){
            moved=labyrinth.move();
            //Если не смог походить - флагу передастся false
            if(moved==false){
                System.out.println("Finish point unreachable!");
                break;
            }
        }

        //Если дошел до финиша - флаг остается true
        if (moved==true){
            System.out.println("Finish point reached!");
        }
    }
}
