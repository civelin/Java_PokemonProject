package pokemons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalPokemon extends Pokemon {

    public NormalPokemon(String name, List<String> types) {
        this.name = name;
        this.types = types;
        this.hp = this.returnInitialHP(); // can do it because defaultHp is package private
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    // the default constructor is only used for testing
    public NormalPokemon(){
        this.name = "Pikachu";
        this.types = new ArrayList<>(Arrays.asList("fire", "bug", "grass", "normal", "electric"));
        this.hp = this.returnInitialHP();
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    // methods
    @Override
    public int returnInitialHP() {
        return Pokemon.defaultHp;
    }

    @Override
    public int returnInitialAttackPoints() {
        return Pokemon.defaultAttackPoints;
    }

    @Override
    public int returnInitialDefencePoints() {
        return Pokemon.defaultDefencePoints;
    }

}
