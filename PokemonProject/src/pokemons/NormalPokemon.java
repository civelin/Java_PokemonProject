package pokemons;

import java.util.List;

public class NormalPokemon extends Pokemon {

    public NormalPokemon(String name, List<String> types) {
        this.name = name;
        this.types = types;
        this.hp = (int) (Pokemon.defaultHp); // can do it because defaultHp is package private
        this.attackPoints = (int) (Pokemon.defaultAttackPoints);
        this.defencePoints = (int) (Pokemon.defaultDefencePoints);

    }


    @Override
    public void revivePokemon() {
        this.hp = (int) (Pokemon.defaultHp);
    }

}
