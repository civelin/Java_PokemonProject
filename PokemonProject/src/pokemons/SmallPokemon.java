package pokemons;

import attacks.PokemonAttack;

import java.util.ArrayList;
import java.util.List;

public class SmallPokemon extends Pokemon {
    public SmallPokemon(String name, List<String> types ) {
        this.name = name;
        this.types = types;
        this.hp = this.returnInitialHP(); // can do it because defaultHp is package private
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();

    }


    @Override
    public void revivePokemon() {
        this.hp = this.returnInitialHP();
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
