package com.homework; 

import java.io.Serializable;

public class Armor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int defense;
    
    public Armor() {}
    
    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getDefense() { 
        return defense; 
    }
    
    public void setDefense(int defense) { 
        this.defense = defense; 
    }
    
    @Override
    public String toString() {
        return name + " (защита: " + defense + ")";
    }
}
