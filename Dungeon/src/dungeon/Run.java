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
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyMap map = new MyMap();

        while (!(map.checkWin(map.curRoom()))) {
            map.checkRoom(map.curRoom());

            map.nextRoom(map.curRoom());
        }
        System.out.println(map.curRoom().getDescription());
    }
}
