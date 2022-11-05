package pokemons;

import java.util.List;

public class SmallPokemon extends Pokemon {
    public SmallPokemon(String name, List<String> types) {
        this.name = name;
        this.types = types;
        this.hp = (int) (0.8 * Pokemon.defaultHp); // can do it because defaultHp is package private
        this.attackPoints = (int) (0.8 * Pokemon.defaultAttackPoints);
        this.defencePoints = (int) (0.8 * Pokemon.defaultDefencePoints);
    }


    @Override
    public void revivePokemon() {
        this.hp = (int) (0.8 * Pokemon.defaultHp);
    }
}
