package pokemons;

import java.util.List;

public class NormalPokemon extends Pokemon {

    public NormalPokemon(String name, List<String> types) {
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
        return  Pokemon.defaultHp;
    }

    @Override
    public double returnInitialAttackPoints() {
        return  Pokemon.defaultAttackPoints;
    }

    @Override
    public double returnInitialDefencePoints() {
        return  Pokemon.defaultDefencePoints;
    }

}
