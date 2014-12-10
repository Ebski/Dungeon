/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author Ebbe
 */
public class MyMap {

    private Map map;
    private Room cur;

    public MyMap() {
        map = new Map(4, 3);
        cur = map.getRoom(0, 0);

        map.getRoom(0, 0).setSouth(map.getRoom(0, 1));
        map.getRoom(0, 0).setEast(map.getRoom(1, 0));
        map.getRoom(0, 0).setDescription("Room 0.0");

        map.getRoom(1, 0).setSouth(map.getRoom(1, 1));
        map.getRoom(1, 0).setEast(map.getRoom(2, 0));
        map.getRoom(1, 0).setDescription("Room 1.0");

        map.getRoom(2, 0).setEast(map.getRoom(3, 0));
        map.getRoom(2, 0).setDescription("Room 2.0");

        map.getRoom(3, 0).setSouth(map.getRoom(3, 1));
        map.getRoom(3, 0).setDescription("Room 3.0");

        map.getRoom(0, 1).setSouth(map.getRoom(0, 2));
        map.getRoom(0, 1).setEast(map.getRoom(1, 1));
        map.getRoom(0, 1).setDescription("Room 0.1");

        map.getRoom(1, 1).setNorth(map.getRoom(1, 0));
        map.getRoom(1, 1).setSouth(map.getRoom(1, 2));
        map.getRoom(1, 1).setDescription("Room 1.1");

        map.getRoom(2, 1).setNorth(map.getRoom(2, 0));
        map.getRoom(2, 1).setSouth(map.getRoom(2, 2));
        map.getRoom(2, 1).setWest(map.getRoom(1, 1));
        map.getRoom(2, 1).setDescription("Room 2.1");

        map.getRoom(3, 1).setSouth(map.getRoom(3, 2));
        map.getRoom(3, 1).setWest(map.getRoom(2, 1));
        map.getRoom(3, 1).setDescription("Room 3.1");

        map.getRoom(0, 2).setNorth(map.getRoom(0, 1));
        map.getRoom(0, 2).setDescription("Room 0.2");

        map.getRoom(1, 2).setWest(map.getRoom(0, 2));
        map.getRoom(1, 2).setDescription("Room 1.2");

        map.getRoom(2, 2).setNorth(map.getRoom(2, 1));
        map.getRoom(2, 2).setWest(map.getRoom(1, 2));
        map.getRoom(2, 2).setDescription("Room 2.2");

        map.getRoom(3, 2).setWin(true);
        map.getRoom(3, 2).setDescription("YOU WIN");
    }

    public void checkRoom(Room room) {
        if ((!room.isWin())) {
            System.out.println("In this room you can go ");
            System.out.println(room.getDescription());

            if (!(room.getNorth() == null)) {
                System.out.println("North");
            }
            if (!(room.getSouth() == null)) {
                System.out.println("South");
            }
            if (!(room.getEast() == null)) {
                System.out.println("East");
            }
            if (!(room.getWest() == null)) {
                System.out.println("West");
            }

            System.out.println("Type the first letter of the direction you want to go");
        } else {
            System.out.println("You are through the maze. YOU WIN");
        }

    }

    public Room nextRoom(Room room) {
        Scanner scan = new Scanner(System.in);
        String direction;

        direction = scan.nextLine();

        if ((!(room.getNorth() == null)) && direction.toLowerCase().equals("n")) {
            cur = room.getNorth();
        }
        if ((!(room.getSouth() == null)) && direction.toLowerCase().equals("s")) {
            cur = room.getSouth();
        }
        if ((!(room.getEast() == null)) && direction.toLowerCase().equals("e")) {
            cur = room.getEast();
        }
        if ((!(room.getWest() == null)) && direction.toLowerCase().equals("w")) {
            cur = room.getWest();
        }
        return cur;
    }

    public Room curRoom() {
        return cur;
    }

    public boolean checkWin(Room room) {
        return (room.isWin());
    }
}
