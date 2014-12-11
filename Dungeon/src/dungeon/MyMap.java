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
    private Event event;
    private Player plr;

    public MyMap() {
        plr = new Player("name", 100, 5);
        map = new Map(4, 3);
        cur = map.getRoom(0, 0);
        event = new Event();

        map.getRoom(0, 0).setSouth(map.getRoom(0, 1));
        map.getRoom(0, 0).setEast(map.getRoom(1, 0));
        map.getRoom(0, 0).setDescription("You Enter a dark room. Toward east there is a big illuminated door, towards south there is a tiny basement door. Which door do you choose?");

        map.getRoom(1, 0).setSouth(map.getRoom(1, 1));
        map.getRoom(1, 0).setEast(map.getRoom(2, 0));
        map.getRoom(1, 0).setEvent(true);
        map.getRoom(1, 0).setEventString("goblin");
        map.getRoom(1, 0).setDescription("You enter a tiny room, filled with creepy goblin statues. Towards east there is a small door with the sign 'WRONG WAY' towards south there is"
                + "a sign saying 'TO FIND THE TREASURE GO THIS WAY'");

        map.getRoom(2, 0).setEast(map.getRoom(3, 0));
        map.getRoom(2, 0).setEvent(true);
        map.getRoom(2, 0).setEventString("chest");
        map.getRoom(2, 0).setDescription("As you enter the new room the door behind you disapears. In the middle of the room there is a chest, towards east there is a door.");

        map.getRoom(3, 0).setSouth(map.getRoom(3, 1));
        map.getRoom(3, 0).setDescription("There are giant windoms in this room overlooking a nearby forest Towards south there is a door");

        map.getRoom(0, 1).setSouth(map.getRoom(0, 2));
        map.getRoom(0, 1).setEast(map.getRoom(1, 1));
        map.getRoom(0, 1).setDescription("You enter a giant room, filled with beautiful furniture. Towards south there is an old damaged door, and towards east there is a normal looking"
                + " half opened door, that gives a nasty sound every time it moves.");

        map.getRoom(1, 1).setNorth(map.getRoom(1, 0));
        map.getRoom(1, 1).setSouth(map.getRoom(1, 2));
        map.getRoom(1, 1).setDescription("By the look of this room it appears you have entered an old ball hall. "
                + "Towards north there is a giant door, and towards south there is also a giant door.");

        map.getRoom(2, 1).setNorth(map.getRoom(2, 0));
        map.getRoom(2, 1).setSouth(map.getRoom(2, 2));
        map.getRoom(2, 1).setWest(map.getRoom(1, 1));
        map.getRoom(2, 1).setDescription("You enter an oval room. Towards north there is a door, towards south there is another door, "
                + "and towards west there is a latter you can climb down.");

        map.getRoom(3, 1).setSouth(map.getRoom(3, 2));
        map.getRoom(3, 1).setWest(map.getRoom(2, 1));
        map.getRoom(3, 1).setDescription("In this room you get the feeling that you are getting closer. Towards south you see a door, slightly hidden behind an old paining, "
                + "and towards west you can see right into an oval room");

        map.getRoom(0, 2).setDescription("You fall through a trap door and end up in a dungeon. Game Over!");

        map.getRoom(1, 2).setWest(map.getRoom(0, 2));
        map.getRoom(1, 2).setDescription("In this room there is only a slide down towards west. Over the slide there is a sign 'WELCOME TO THE DUNGEON'");

        map.getRoom(2, 2).setNorth(map.getRoom(2, 1));
        map.getRoom(2, 2).setWest(map.getRoom(1, 2));
        map.getRoom(2, 2).setDescription("You enter a small room. Towards north there is a tiny door, and towards west there is an even tinier one");

        map.getRoom(3, 2).setWin(true);
        map.getRoom(3, 2).setDescription("In the last room there was a tiny little gold coin. So congrats!");
    }

    public void checkRoom(Room room) {
        if ((!room.isWin())) {
            System.out.println(room.getDescription());

            if (room.getNorth() == null && room.getSouth() == null && room.getEast() == null && room.getWest() == null) {
                System.exit(0);
            }

            System.out.println("In this room you can go ");

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
            if (room.isEvent()) {
                switch (room.getEventString()) {
                    case "chest":
                        System.out.println("You can also open the chest");
                        break;
                    case "goblin":
                        System.out.println("Goblins attack you press 't' to fight them");
                        break;
                }
            }

            System.out.println("Type the first letter of the direction you want to go");

            if (room.isEvent()) {
                System.out.println("Type 't' to trigger the event");
            }
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
        if (room.isEvent() && direction.toLowerCase().equals("t")) {
            switch (room.getEventString()) {
                case "chest":
                    plr.setDMG(event.chest(plr.getDMG()));
                    room.setEvent(false);
                    break;
                case "goblin":
                    plr.setHP(event.fightGoblins(plr.getHP(), plr.getDMG()));
                    room.setEvent(false);
                    break;
            }

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
