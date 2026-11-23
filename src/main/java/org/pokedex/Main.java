package org.pokedex;

public class Main {
    static void main() {
        Database db = Database.getInstance();

        IO.println("Inserici i dati di un nuovo pokemon:");

        int index = Integer.parseInt(IO.readln("Index: "));
        String nome = IO.readln("Nome: ");
        ElementType tipo1 = ElementType.fromItalianName(IO.readln("Tipo Primario: ").toUpperCase());

        String tipo2String = IO.readln("Tipo Secondario (opzionale): ").toUpperCase();
        ElementType tipo2;
        if(tipo2String.isEmpty())
            tipo2 = null;
        else
            tipo2 = ElementType.fromItalianName(tipo2String);
        int hp = Integer.parseInt(IO.readln("HP: "));
        String abilita = IO.readln("Abilità: ");

        db.addPokemon(new Pokemon(index, nome, tipo1, tipo2, hp, abilita));

    }
}
