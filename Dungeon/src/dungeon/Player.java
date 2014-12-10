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
public class Player {
    private String name;
    private int hp, dmg;
    
    public Player(String name, int hp, int dmg) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
    }
    
    public String getName() {
        return this.name;
    }
            
    public int getHP() {
        return this.hp;
    }
    
    public int getDMG() {
        return this.dmg;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
    
    public void setDMG(int dmg) {
        this.dmg = dmg;
    }
    
}
