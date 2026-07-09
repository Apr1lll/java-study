package main.java.com.homework;

import java.io.Serializable;

public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int lvl;
    private Weapon weapon;
    private Armor armor;
    
    public Hero() {}
    
    public Hero(String name, int lvl, Weapon weapon, Armor armor) {
        this.name = name;
        this.lvl = lvl;
        this.weapon = weapon;
        this.armor = armor;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getLvl() { 
        return lvl; 
    }
    
    public void setLvl(int lvl) { 
        this.lvl = lvl; 
    }
    
    public Weapon getWeapon() { 
        return weapon; 
    }
    
    public void setWeapon(Weapon weapon) { 
        this.weapon = weapon; 
    }
    
    public Armor getArmor() { 
        return armor; 
    }
    
    public void setArmor(Armor armor) { 
        this.armor = armor; 
    }
    
    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", lvl=" + lvl +
                ", weapon=" + weapon +
                ", armor=" + armor +
                '}';
    }
}
