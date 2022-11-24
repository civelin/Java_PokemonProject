package attacks;

import Utilities.Comparable;
import users.User;

public abstract class PokemonAttack implements Description, Comparable<PokemonAttack> {

    // fields
    protected String name;
    protected String type;
    protected String description;
    protected int attackPower = 15;

    // methods
    @Override
    public String getDescription() {
        return "    --> " + this.description;
    }

    @Override
    public boolean compare(PokemonAttack attack) {
        return this.getName().equals(attack.getName());
    }

    public abstract int attack(User user, User enemyUser);

    // getters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

}