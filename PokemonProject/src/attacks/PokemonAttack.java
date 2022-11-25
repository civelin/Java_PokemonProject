package attacks;

import users.User;

import java.util.Objects;

public abstract class PokemonAttack implements Description, IAttack {

    // fields
    protected String name;
    protected String type;
    protected String description;
    protected int attackPower = 15;

    // methods
    @Override
    public String returnDescription() {
        return "    --> " + this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonAttack that = (PokemonAttack) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

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