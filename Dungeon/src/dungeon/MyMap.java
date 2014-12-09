/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Ebbe
 */
public class MyMap {

    private Map map;

    public MyMap() {
        map = new Map(4, 3);

        map.getRoom(0,0).setSouth(map.getRoom(1,0));
        map.getRoom(0,0).setEast(map.getRoom(0,1));

        map.getRoom(0,1).setSouth(map.getRoom(1,1));
        map.getRoom(0,1).setEast(map.getRoom(0,2));

        map.getRoom(0,2).setEast(map.getRoom(0,3));

        map.getRoom(0,3).setSouth(map.getRoom(1,3));

        map.getRoom(1,0).setSouth(map.getRoom(2,0));
        map.getRoom(1,0).setEast(map.getRoom(1,1));

        map.getRoom(1,1).setNorth(map.getRoom(0,1));
        map.getRoom(1,1).setSouth(map.getRoom(2,1));

        map.getRoom(1,2).setNorth(map.getRoom(0,2));
        map.getRoom(1,2).setSouth(map.getRoom(2,2));
        map.getRoom(1,2).setWest(map.getRoom(1,1));

        map.getRoom(1,3).setSouth(map.getRoom(2,3));
        map.getRoom(1,3).setEast(map.getRoom(1,2));
        
        map.getRoom(2,0).setNorth(map.getRoom(1,0));
        
        map.getRoom(2,1).setWest(map.getRoom(2,0));
        
        map.getRoom(2,2).setNorth(map.getRoom(1,2));
        map.getRoom(2,2).setWest(map.getRoom(2,1));
        
        map.getRoom(2,3).setWin(true);

    }

}
