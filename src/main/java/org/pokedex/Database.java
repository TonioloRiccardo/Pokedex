package org.pokedex;

import java.sql.*;

public class Database {
    private static Database instance;

    public static Database getInstance() {
        if(instance == null)
            instance = new Database();
        return  instance;
    }

    private Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPokemon(Pokemon pokemon) {
        String query = "INSERT INTO pokemon('index', nome, tipo1, tipo2, HP, abilita) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, pokemon.index);
            statement.setString(2, pokemon.name);
            statement.setString(3, pokemon.tipo1.toString());
            if(pokemon.tipo2 == null)
                statement.setString(4, null);
            else
                statement.setString(4, pokemon.tipo2.toString());
            statement.setInt(5, pokemon.HP);
            statement.setString(6, pokemon.abilita);

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon getPokemon(int index) {
        String query = "SELECT nome, tipo1, tipo2, HP, abilita from pokemon where ('index' == ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, index);
            statement.execute();

            ResultSet set = statement.getResultSet();

            Pokemon pokemon = new Pokemon(
                set.getInt(1),
                set.getString(2),
                ElementType.valueOf(set.getString(3)),
                ElementType.valueOf(set.getString(4)),
                set.getInt(5),
                set.getString(6)
            );

            return pokemon;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
