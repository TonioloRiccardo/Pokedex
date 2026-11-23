package org.pokedex;

public enum ElementType {
    NORMAL("Normale"),
    FIRE("Fuoco"),
    WATER("Acqua"),
    ELECTRIC("Elettro"),
    GRASS("Erba"),
    ICE("Ghiaccio"),
    FIGHTING("Lotta"),
    POISON("Veleno"),
    GROUND("Terra"),
    FLYING("Volante"),
    PSYCHIC("Psico"),
    BUG("Coleottero"),
    ROCK("Roccia"),
    GHOST("Spettro"),
    DRAGON("Drago"),
    DARK("Buio"),
    STEEL("Acciaio"),
    FAIRY("Folletto");

    private final String italianName;

    ElementType(String italianName) {
        this.italianName = italianName;
    }

    public String getItalianName() {
        return italianName;
    }

    public static ElementType fromItalianName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Il nome del tipo non può essere null");
        }
        for (ElementType type : values()) {
            if (type.italianName.equalsIgnoreCase(name.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo Pokémon non trovato: " + name);
    }
}
