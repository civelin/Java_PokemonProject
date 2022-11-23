package pokemons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallPokemon extends Pokemon {
    public SmallPokemon(String name, List<String> types ) {
        this.name = name;
        this.types = types;
        this.hp = this.returnInitialHP();
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    // the default constructor is only used for testing
    public SmallPokemon(){
        this.name = "Pikachu";
        this.types = new ArrayList<>(Arrays.asList("fire", "bug", "grass", "normal", "electric"));
        this.hp = this.returnInitialHP();
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

// methods
    @Override
    public int returnInitialHP() {
        return (int) (0.8 * Pokemon.defaultHp);
    }

    @Override
    public int returnInitialAttackPoints() {
        return (int) (0.8 * Pokemon.defaultAttackPoints);
    }

    @Override
    public int returnInitialDefencePoints() {
        return (int) (0.8 * Pokemon.defaultDefencePoints);
    }
}
