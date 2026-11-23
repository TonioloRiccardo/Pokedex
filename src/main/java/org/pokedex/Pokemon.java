package org.pokedex;

public class Pokemon {
    public int index;
    public String name;
    public ElementType tipo1;
    public ElementType tipo2;
    public int HP;
    public String abilita;

    public Pokemon(int index, String name, ElementType tipo1, ElementType tipo2, int HP, String abilita) {
        this.index = index;
        this.name = name;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.HP = HP;
        this.abilita = abilita;
    }
}
