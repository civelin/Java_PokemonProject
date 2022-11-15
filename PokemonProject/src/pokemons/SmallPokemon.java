package pokemons;

import attacks.PokemonAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallPokemon extends Pokemon {
    public SmallPokemon(String name, List<String> types ) {
        this.name = name;
        this.types = types;
        this.hp = this.returnInitialHP(); // can do it because defaultHp is package private
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


    @Override
    public double returnInitialHP() {
      return 0.8 * Pokemon.defaultHp;
    }

    @Override
    public double returnInitialAttackPoints() {
        return 0.8 * Pokemon.defaultAttackPoints;
    }

    @Override
    public double returnInitialDefencePoints() {
        return 0.8 * Pokemon.defaultDefencePoints;
    }
}
