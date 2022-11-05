package pokemons;

import java.util.List;

public class LargePokemon extends Pokemon {

    public LargePokemon(String name, List<String> types) {
        this.name = name;
        this.types = types;
        this.hp = (int) (1.2 * Pokemon.defaultHp); // can do it because defaultHp is package private
        this.attackPoints = (int) (1.2 * Pokemon.defaultAttackPoints);
        this.defencePoints = (int) (1.2 * Pokemon.defaultDefencePoints);
    }


    @Override
    public void revivePokemon() {
        this.hp = (int) (1.2 * Pokemon.defaultHp);
    }

}
