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
public class Map {

    private Room[][] map;
    private int xSize, ySize;

    public Map(int xSize,int ySize) {
        map = new Room[xSize][ySize];
        this.xSize = xSize;
        this.ySize = ySize;

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                map[i][j] = new Room();
            }
        }
    }

    public Room getRoom(int x,int y) {
        return map[x][y];
    }

    public void fillMap() {
        Room room1 = map[0][0];
        Room room2 = map[0][1];
        Room room3 = map[0][2];
        Room room4 = map[0][3];
        Room room5 = map[1][0];
        Room room6 = map[1][1];
        Room room7 = map[1][2];
        Room room8 = map[1][3];
        Room room9 = map[2][0];
        Room room10 = map[2][1];
        Room room11 = map[2][2];
        Room room12 = map[2][3];

        room1.setSouth(room5);
        room1.setEast(room2);

        room2.setSouth(room6);
        room2.setEast(room3);

        room3.setEast(room4);

        room4.setSouth(room8);

        room5.setSouth(room9);
        room5.setEast(room6);

        room6.setNorth(room2);
        room6.setSouth(room10);

        room7.setNorth(room3);
        room7.setSouth(room11);
        room7.setWest(room6);

        room8.setSouth(room12);
        room8.setEast(room7);

        room9.setNorth(room5);

        room10.setWest(room9);

        room11.setNorth(room7);
        room11.setWest(room10);

        room12.setWin(true);
    }
}
