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
public class Room {
    private String description;
    private Room north, south, east, west;
    
    public Room(String description, Room north, Room south, Room, east, Room west) {
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    
}
