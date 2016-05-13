package Labyrinth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Created by adm on 05.05.2016.
 */
public class MyLabyrinthFactory extends AbstractLabyrinthFactory{

    @Override
    public Labyrinth build() {

        Map pathList = new HashMap<String, Tunnel>();

        pathList.put("AB", new Tunnel(WayPoints.A,WayPoints.B));

        pathList.put("BD", new Tunnel(WayPoints.B,WayPoints.D));
        pathList.put("BH", new Tunnel(WayPoints.B,WayPoints.H));

        pathList.put("CH", new Tunnel(WayPoints.C,WayPoints.H));

        pathList.put("NK", new Tunnel(WayPoints.N,WayPoints.K));
        pathList.put("NR", new Tunnel(WayPoints.N,WayPoints.R));
        pathList.put("NM", new Tunnel(WayPoints.N,WayPoints.M));

        pathList.put("MR", new Tunnel(WayPoints.M,WayPoints.R));
        pathList.put("MP", new Tunnel(WayPoints.M,WayPoints.P));
        pathList.put("MF", new Tunnel(WayPoints.M,WayPoints.F));
        pathList.put("ML", new Tunnel(WayPoints.M,WayPoints.L));

        pathList.put("PR", new Tunnel(WayPoints.P,WayPoints.R));

        pathList.put("FE", new Tunnel(WayPoints.F,WayPoints.E));

       // pathList.put("EH", new Tunnel(WayPoints.E,WayPoints.H));

        return new Labyrinth(pathList,WayPoints.N,WayPoints.H);
    }
}
