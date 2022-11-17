package attacks;

import pokemons.Pokemon;

import java.util.List;

public abstract class PokemonAttack implements Description, Comparable<PokemonAttack> {

    // fields
    protected String name;
    protected String type;
    protected String description;
    protected double attackPower = 10;

    // methods
    public String getDescription() {
        return "    -> " + this.description;
    }

    public boolean compare(PokemonAttack attack) {
        return this.getName().equals(attack.getName());
    }

    public abstract double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons);
    // getters and setters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getAttackPower() {
        return attackPower;
    }
}
