package attacks;

import users.User;

public abstract class PokemonAttack implements Description, Comparable<PokemonAttack> {

    // fields
    protected String name;
    protected String type;
    protected String description;
    protected double attackPower = 10;

    // methods
    @Override
    public String getDescription() {
        return "    -> " + this.description;
    }

    @Override
    public boolean compare(PokemonAttack attack) {
        return this.getName().equals(attack.getName());
    }

    public abstract double attack(User user, User enemyUser);

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