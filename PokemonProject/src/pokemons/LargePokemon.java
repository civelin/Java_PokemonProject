package pokemons;

import attacks.PokemonAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargePokemon extends Pokemon {

    public LargePokemon(String name, List<String> types ) {
        this.name = name;
        this.types = types;
        this.hp = this.returnInitialHP(); // can do it because defaultHp is package private
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    // the default constructor is only used for testing
    public LargePokemon(){
        this.name = "Pikachu";
        this.types = new ArrayList<>(Arrays.asList("fire", "bug", "grass", "normal", "electric"));
        this.hp = this.returnInitialHP();
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    @Override
    public double returnInitialHP() {
        return 1.2 * Pokemon.defaultHp;
    }

    @Override
    public double returnInitialAttackPoints() {
        return 1.2 * Pokemon.defaultAttackPoints;
    }

    @Override
    public double returnInitialDefencePoints() {
        return 1.2 * Pokemon.defaultDefencePoints;
    }
}