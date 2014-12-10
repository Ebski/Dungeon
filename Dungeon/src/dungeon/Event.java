/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

import java.util.Random;

/**
 *
 * @author Ebbe
 */
public class Event {
    Random ran = new Random();
    
    public int chest(int dmg) {
        int chance = 0;
        chance = ran.nextInt(3)+1;
        
        switch(chance) {
            case 1:
                System.out.println("There is a sword in the chest. Player dmg increased by 2");
                dmg = dmg + 2;
                break;
            case 2:
                System.out.println("You use your sword to open the chest and it is damaged. Player dmg decreased by 2");
                dmg = dmg - 2;
                break;
            case 3:
                System.out.println("There is nothing in the chest");
                break;
        }
        return dmg;
    }
            
    
}
