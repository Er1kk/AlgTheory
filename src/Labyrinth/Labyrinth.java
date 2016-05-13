package Labyrinth;

import java.util.*;

public class Labyrinth {
    //Список ребер лабиринта в виде карты со строковым ключем
    private Map<String, Tunnel> pathList;
    //начальная точка лабиринта
    private WayPoints startPoint;
    //конечная точка лабиринта
    private WayPoints finishPoint;
    //текущая вершина
    private WayPoints currentPoint;

    //Конструктор создает лабиринт со списком ребер и текущей вершиной, равной начальной.
    public Labyrinth(Map<String,Tunnel> pathList, WayPoints startPoint, WayPoints finishPoint) {
        this.pathList = pathList;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
        currentPoint=startPoint;
    }

    //Метод move ищет сначала зеленый коридор от текущей вершины, а если не найдет - желтый.
    //Возвращает true если удалост сделать ход, и false - если нет.
    public boolean move(){
        for (Tunnel tunnel : pathList.values()){
            if (tunnel.getFirstPoint() == currentPoint)
                if (tunnel.getColor() == Colors.GREEN) {
                    tunnel.setYellow();
                    System.out.print("GREEN MOVE: \t");
                    return moveTo(tunnel.getSecondPoint());
                }
            if (tunnel.getSecondPoint() == currentPoint)
                if (tunnel.getColor() == Colors.GREEN) {
                    tunnel.setYellow();
                    System.out.print("GREEN MOVE: \t");
                    return moveTo(tunnel.getFirstPoint());
                }
        }

        for (Tunnel tunnel : pathList.values()){
            if (tunnel.getFirstPoint() == currentPoint)
                if (tunnel.getColor() == Colors.YELLOW) {
                    tunnel.setRed();
                    System.out.print("YELLOW MOVE:\t");
                    return moveTo(tunnel.getSecondPoint());
                }
            if (tunnel.getSecondPoint() == currentPoint)
                if (tunnel.getColor() == Colors.YELLOW) {
                    tunnel.setRed();
                    System.out.print("YELLOW MOVE:\t");
                    return moveTo(tunnel.getFirstPoint());
                }
        }

        return false;
    }

    //Вспомогательный метод для улучшения читаемости кода
    private boolean moveTo(WayPoints point){
        System.out.println(currentPoint+" -> "+point);
        currentPoint=point;
        return true;
    }

    //Методы доступа к инкапсулированным полям класса
    public WayPoints getStartPoint() {
        return startPoint;
    }

    public WayPoints getFinishPoint() {
        return finishPoint;
    }

    public WayPoints getCurrentPoint() {
        return currentPoint;
    }
}
