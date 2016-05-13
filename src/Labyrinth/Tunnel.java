package Labyrinth;

public class Tunnel {
    //Поля класса
    private WayPoints firstPoint;
    private WayPoints secondPoint;
    private Colors color;

    //Конструктор создает коридор зеленого цвета
    public Tunnel(WayPoints firstPoint, WayPoints secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        color=Colors.GREEN;
    }

    //Метод для сравненияя двух обьектов типа Tunnel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tunnel)) return false;

        Tunnel tunnel = (Tunnel) o;

        if ((getFirstPoint() != tunnel.getFirstPoint()) || (getFirstPoint() != tunnel.getSecondPoint())) return false;
        if ((getSecondPoint() != tunnel.getSecondPoint()) || (getSecondPoint() != tunnel.getFirstPoint())) return false;
        return getColor() == tunnel.getColor();

    }

    //Метод для получения хэш-кода объекта класса Tunnel
    @Override
    public int hashCode() {
        int result = getFirstPoint() != null ? getFirstPoint().hashCode() : 0;
        result = 31 * result + (getSecondPoint() != null ? getSecondPoint().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        return result;
    }

    //Установка желтого цвета
    public void setYellow() {
        if(color==Colors.GREEN)
            this.color = Colors.YELLOW;
    }

    //Установка красного цвета
    public void setRed() {
        if(color==Colors.YELLOW)
            this.color = Colors.RED;
    }

    //Методы доступа к инкапсулированным полям класса
    public WayPoints getFirstPoint() {
        return firstPoint;
    }

    public WayPoints getSecondPoint() {
        return secondPoint;
    }

    public Colors getColor() {
        return color;
    }
}
