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
}
