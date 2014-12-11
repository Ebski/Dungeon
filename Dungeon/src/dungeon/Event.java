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
        chance = ran.nextInt(3) + 1;

        switch (chance) {
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

    public int fightGoblins(int hp, int dmg) {
        int chance = 0;
        chance = ran.nextInt(10) + 1;
        int event = 0;
        if (dmg <= 3) {
            event = 1;
        } else if (dmg > 3 && dmg <= 6) {
            event = 2;
        } else {
            event = 3;
        }

        switch (event) {
            case 1:
                System.out.println("Your sword is rusty and therefore the battle is a real struggle");
                if (chance <= 2) {
                    System.out.println("You win the fight but takes 25 dmg");
                    hp = hp - 25;
                } else {
                    System.out.println("You lose the fight but manages to get away. you take 75 dmg");
                    hp = hp - 75;
                }
                break;
            case 2:
                System.out.println("The battle is ballanced");
                if (chance <= 5) {
                    System.out.println("You win the fight but takes 10 dmg");
                    hp = hp - 10;
                } else {
                    System.out.println("The fight is a draw and you take 30 dmg");
                    hp = hp - 25;
                }
                break;

            case 3:
                System.out.println("You have control over the battle");
                if (chance <= 8) {
                    System.out.println("You win the battle, and the goblin leader tells you the treasure is in the most southern part of the dungeon");
                } else {
                    System.out.println("You win the battle but takes 10 dmg during the struggle");
                    hp = hp - 10;
                }
                break;
        }
        return hp;
    }

}
